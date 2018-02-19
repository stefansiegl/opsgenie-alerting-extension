/*
 *   Copyright 2018. AppDynamics LLC and its affiliates.
 *   All Rights Reserved.
 *   This is unpublished proprietary source code of AppDynamics LLC and its affiliates.
 *   The copyright notice above does not evidence any actual or intended publication of such source code.
 *
 */

package com.appdynamics.extension;

import com.appdynamics.opsgenie.type.AD_AlertData;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.zip.DataFormatException;

/**
 * Created with IntelliJ IDEA.
 * User: dbershadsky
 * Date: 1/31/14
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AlertingExtension {

    private static Logger logger = Logger.getLogger(AlertingExtension.class);


    /**
     * Main class that accepts command line arguments
     *
     * @param args Command line arguments
     * @throws Exception
     */
    public static void main(String args[]) {
        try {
            removeDoubleQuotes(args);
            AD_AlertData alertData = parseArgs(args);

            logger.info("Finished parsing arguments");

            ApplicationContext context =
                    new ClassPathXmlApplicationContext("META-INF/spring.xml");
            AlertSender alertSender = (AlertSender) context.getBean("alertSender");
            alertSender.sendAlert(alertData);

            logger.info("-------------Alert Sent!---------------");

        } catch (Exception e) {
            logger.error("Failed to send alert: " + e.getMessage(), e);
        }
    }


    /**
     * Removes double quotes from passed arguments
     *
     * @param args Passed arguments
     */
    private static void removeDoubleQuotes(String[] args) {
        for (int i = 0; i < args.length; i++) {
            args[i] = args[i].replaceAll("\"", "");
        }
    }

    /**
     * Parses the command line arguments that are passed
     *
     * @param args Arguments passed to this project
     * @throws DataFormatException Unable to parse arguments
     */
    private static AD_AlertData parseArgs(String[] args) throws Exception {
        try {
            logger.info("Parsing the arguments");
            logger.debug(Arrays.asList(args));


            AD_AlertData result = new AD_AlertData();

            if (args[0].equals("--help") || args[0].equals("--h") || args[0].equals("-h") || args[0].equals("-help")) {

                System.out.println("Usage: java -jar opsGenie.jar -m <options>\n");

                System.out.println("Options:");
                System.out.println("\t-a\t-\tApplication Name");
                System.out.println("\t-trig\t-\tTriggered by");
                System.out.println("\t-n\t-\tNodes involved");
                System.out.println("\t-b\t-\tBusiness txns involved");
                System.out.println("\t-mac\t-\tMachines involved");
                System.out.println("\t-tier\t-\tTiers involved");
                System.out.println("\t-e\t-\tEvent Time");
                System.out.println("\t-sever\t-\tSeverity");
                System.out.println("\t-type\t-\tType");
                System.out.println("\t-summ\t-\tSummary");
                System.out.println("\t-link\t-\tLink");
                System.out.println("\t-tag\t-\tTag");
                return null;

            } else if (args[0].equals("-m")) {

                for (int i = 1; i < args.length - 1; i++) {
                    if (args[i].equals("-a")) {
                        result.setApplicationName(args[++i]);
                    } else if (args[i].equals("-trig")) {
                        result.setPolicyName(args[++i]);
                    } else if (args[i].equals("-n")) {
                        result.setNodes(args[++i]);
                    } else if (args[i].equals("-b")) {
                        result.setBTs(args[++i]);
                    } else if (args[i].equals("-mac")) {
                        result.setMachines(args[++i]);
                    } else if (args[i].equals("-tier")) {
                        result.setTiers(args[++i]);
                    } else if (args[i].equals("-e")) {
                        result.setAlertTime(args[++i]);
                    } else if (args[i].equals("-sever")) {
                        result.setSeverity(args[++i]);
                    } else if (args[i].equals("-type")) {
                        result.setAffectedEntityType(args[++i]);
                    } else if (args[i].equals("-summ")) {
                        result.setSummaryMessage(args[++i]);
                    } else if (args[i].equals("-link")) {
                        result.setDeepLinkURL(args[++i]);
                    } else if (args[i].equals("-tag")) {
                        result.setTag(args[++i]);
                    }
                }
                return result;
            }

            int param = 0;
            if (args[args.length - 1].startsWith("http")) {    //other events
//[JBoss, 2, Sun Feb 02 20:46:07 PST 2014, 1, INFO, OpsGenieTest, APP_SERVER_RESTART, 12004, 1, 1, APP_SERVER_RESTART, 1,
// 1, 12004, Sun Feb 02 20:46:07 PST 2014, 1, INFO,
// APP_SERVER_RESTART triggered at Sun Feb 02 20:46:07 PST 2014. This policy was violated because the following conditions were met for the Type:MACHINE_INSTANCE, id:3 for the last 1 minute(s): ,
// http://ubuj:8090/controller/#location=APP_EVENT_VIEWER_MODAL&eventSummary=]
                result.setHealthRuleViolation(false);
                result.setApplicationName(args[param++]);
                result.setApplicationId(args[param++]);
                result.setAlertTime(args[param++]);
                result.setPriority(args[param++]);
                result.setSeverity(args[param++]);
                result.setTag(args[param++]);
                result.setNotificationName(args[param++]);
                result.setNotificationId(args[param++]);
                result.setNotificationInterval(args[param++]);

                result.setNUMBER_OF_EVENT_TYPES(Integer.parseInt(args[param++]));

                ArrayList<AD_AlertData.Event_Type> event_types = new ArrayList<AD_AlertData.Event_Type>();
                for (int i = 0; i < result.getNUMBER_OF_EVENT_TYPES(); i++) {
                    AD_AlertData.Event_Type event_type = new AD_AlertData.Event_Type();
                    event_type.setEVENT_TYPE(args[param++]);
                    event_type.setEVENT_TYPE_NUM(Integer.parseInt(args[param++]));
                    event_types.add(event_type);

                }
                result.setEventTypes(event_types);
                result.setNUMBER_OF_EVENT_SUMMARIES(Integer.parseInt(args[param++]));

                ArrayList<AD_AlertData.Event_Summary> event_summaries = new ArrayList<AD_AlertData.Event_Summary>();
                for (int i = 0; i < result.getNUMBER_OF_EVENT_SUMMARIES(); i++) {
                    AD_AlertData.Event_Summary event_summary = new AD_AlertData.Event_Summary();
                    event_summary.setEVENT_SUMMARY_ID(args[param++]);
                    event_summary.setEVENT_SUMMARY_TIME(args[param++]);
                    event_summary.setEVENT_SUMMARY_TYPE(args[param++]);
                    event_summary.setEVENT_SUMMARY_SEVERITY(args[param++]);
                    event_summary.setEVENT_SUMMARY_STRING(args[param++]);
                    event_summaries.add(event_summary);
                }

                result.setEventSummaries(event_summaries);

                result.setDeepLinkURL(args[param] + result.getNotificationId());

            } else {    //health rule violation
                result.setHealthRuleViolation(true);

                result.setApplicationName(args[param++]);
                result.setApplicationId(args[param++]);
                result.setPVN_ALERT_TIME(args[param++]);
                result.setPriority(args[param++]);
                result.setSeverity(args[param++]);
                result.setTag(args[param++]);
                result.setPolicyName(args[param++]);
                result.setPolicyId(args[param++]);
                result.setPVN_TIME_PERIOD_IN_MINUTES(args[param++]);
                result.setAffectedEntityType(args[param++]);
                result.setAffectedEntityName(args[param++]);
                result.setAffectedEntityId(args[param++]);
                result.setNUMBER_OF_EVALUATION_ENTITIES(Integer.parseInt(args[param++]));


                ArrayList<AD_AlertData.Evaluation_Entity> entities = new ArrayList<AD_AlertData.Evaluation_Entity>();
                for (int i = 0; i < result.getNUMBER_OF_EVALUATION_ENTITIES(); i++) {
                    AD_AlertData.Evaluation_Entity entity = new AD_AlertData.Evaluation_Entity();
                    entity.setEVALUATION_ENTITY_TYPE(args[param++]);

                    entity.setEVALUATION_ENTITY_NAME(args[param++]);

                    entity.setEVALUATION_ENTITY_ID(args[param++]);

                    if (entity.getEVALUATION_ENTITY_TYPE().contains("APPLICATION_COMPONENT_NODE"))
                        result.setNodes(result.getNodes() + entity.getEVALUATION_ENTITY_NAME() + " ");
                    else if (entity.getEVALUATION_ENTITY_TYPE().contains("APPLICATION_COMPONENT"))
                        result.setTiers(result.getTiers() + entity.getEVALUATION_ENTITY_NAME() + " ");
                    else if (entity.getEVALUATION_ENTITY_TYPE().contains("MACHINE_INSTANCE"))
                        result.setMachines(result.getMachines() + entity.getEVALUATION_ENTITY_NAME() + " ");
                    else if (entity.getEVALUATION_ENTITY_TYPE().contains("BUSINESS_TRANSACTION"))
                        result.setBTs(result.getBTs() + entity.getEVALUATION_ENTITY_NAME() + " ");
                    else if (result.getAffectedEntityType().contains("BUSINESS_TRANSACTION"))
                        result.setBTs(result.getBTs() + result.getAffectedEntityName() + " ");

                    entity.setNUMBER_OF_TRIGGERED_CONDITIONS_PER_EVALUATION_ENTITY(Integer.parseInt(args[param++]));

                    for (int j = 0; j < entity.getNUMBER_OF_TRIGGERED_CONDITIONS_PER_EVALUATION_ENTITY(); j++) {
                        AD_AlertData.Triggered_Condition trigger = new AD_AlertData.Triggered_Condition();
                        trigger.setSCOPE_TYPE_x(args[param++]);
                        trigger.setSCOPE_NAME_x(args[param++]);
                        trigger.setSCOPE_ID_x(args[param++]);
                        trigger.setCONDITION_NAME_x(args[param++]);
                        trigger.setCONDITION_ID_x(args[param++]);
                        trigger.setOPERATOR_x(args[param++]);
                        trigger.setCONDITION_UNIT_TYPE_x(args[param++]);

                        if (trigger.getCONDITION_UNIT_TYPE_x().contains("BASELINE_")) {
                            trigger.setUSE_DEFAULT_BASELINE_x(args[param++]);
                            if (trigger.getUSE_DEFAULT_BASELINE_x().toLowerCase().equals("false")) {
                                trigger.setBASELINE_NAME_x(args[param++]);
                                trigger.setBASELINE_ID_x(args[param++]);
                            }
                        }

                        trigger.setTHRESHOLD_VALUE_x(args[param++]);
                        trigger.setOBSERVED_VALUE_x(args[param++]);

                        entity.addTrigger(trigger);
                    }
                    entities.add(entity);
                }

                result.setSummaryMessage(args[param++]);
                result.setIncidentId(args[param++]);
                result.setDeepLinkURL(args[param++] + result.getIncidentId());

            }
            logger.info("Alert object created: " + result);
            return result;

        } catch (Exception e) {
            throw new Exception("Error while parsing arguments", e);
        }
    }


}
