/*
 *   Copyright 2018. AppDynamics LLC and its affiliates.
 *   All Rights Reserved.
 *   This is unpublished proprietary source code of AppDynamics LLC and its affiliates.
 *   The copyright notice above does not evidence any actual or intended publication of such source code.
 *
 */


package com.appdynamics.opsgenie.type;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * AppDynamics Alert Data Object
 */
public class AD_AlertData {
    private String applicationName;
    private String triggeredBy;
    private String nodes = "";
    private String BTs = "";
    private String machines = "";
    private String tiers = "";
    private String eventTime;
    private String severity;
    private String type;
    private String subtype;
    private String link;
    private String tag;
    private String policyName;
    private String alertTime;
    private String affectedEntityType;
    private String summaryMessage;
    private String deepLinkURL;
    private boolean healthRuleViolation;
    private String applicationId;
    private String priority;
    private String notificationName;
    private String notificationId;
    private int NUMBER_OF_EVENT_TYPES;
    private String notificationInterval;
//    private String enTime;
    private String incidentId;
    private String PVN_ALERT_TIME;
    private String policyId;
    private String PVN_TIME_PERIOD_IN_MINUTES;
    private String affectedEntityName;
    private String affectedEntityId;
    private int NUMBER_OF_EVALUATION_ENTITIES;
    private int NUMBER_OF_EVENT_SUMMARIES;
    private ArrayList<Event_Type> eventTypes;
    private ArrayList<Event_Summary> eventSummaries = new ArrayList<Event_Summary>();

    public ArrayList<Event_Summary> getEventSummaries() {
        return eventSummaries;
    }

    public ArrayList<Event_Type> getEventTypes() {
        return eventTypes;
    }

    public void setEventSummaries(ArrayList<Event_Summary> eventSummaries) {
        this.eventSummaries = eventSummaries;
    }


    public static class Event_Summary {
        public Event_Summary() {
        }

        private String EVENT_SUMMARY_ID = "";
        private String EVENT_SUMMARY_TIME = "";
        private String EVENT_SUMMARY_TYPE = "";
        private String EVENT_SUMMARY_SEVERITY = "";
        private String EVENT_SUMMARY_STRING = "";
        public String toString() {
            return AD_AlertData.toString(this);
        }

        public String getEVENT_SUMMARY_ID() {
            return EVENT_SUMMARY_ID;
        }

        public void setEVENT_SUMMARY_ID(String EVENT_SUMMARY_ID) {
            this.EVENT_SUMMARY_ID = EVENT_SUMMARY_ID;
        }

        public String getEVENT_SUMMARY_TIME() {
            return EVENT_SUMMARY_TIME;
        }

        public void setEVENT_SUMMARY_TIME(String EVENT_SUMMARY_TIME) {
            this.EVENT_SUMMARY_TIME = EVENT_SUMMARY_TIME;
        }

        public String getEVENT_SUMMARY_TYPE() {
            return EVENT_SUMMARY_TYPE;
        }

        public void setEVENT_SUMMARY_TYPE(String EVENT_SUMMARY_TYPE) {
            this.EVENT_SUMMARY_TYPE = EVENT_SUMMARY_TYPE;
        }

        public String getEVENT_SUMMARY_SEVERITY() {
            return EVENT_SUMMARY_SEVERITY;
        }

        public void setEVENT_SUMMARY_SEVERITY(String EVENT_SUMMARY_SEVERITY) {
            this.EVENT_SUMMARY_SEVERITY = EVENT_SUMMARY_SEVERITY;
        }

        public String getEVENT_SUMMARY_STRING() {
            return EVENT_SUMMARY_STRING;
        }

        public void setEVENT_SUMMARY_STRING(String EVENT_SUMMARY_STRING) {
            this.EVENT_SUMMARY_STRING = EVENT_SUMMARY_STRING;
        }


    }

    public static class Triggered_Condition {
        public Triggered_Condition() {
        }

        public String toString() {
            return AD_AlertData.toString(this);
        }

        public String SCOPE_TYPE_x = "";
        public String SCOPE_NAME_x = "";
        public String SCOPE_ID_x = "";
        public String CONDITION_NAME_x = "";
        public String CONDITION_ID_x = "";
        public String OPERATOR_x = "";
        public String CONDITION_UNIT_TYPE_x = "";
        public String USE_DEFAULT_BASELINE_x = "";
        public String BASELINE_NAME_x = "";
        public String BASELINE_ID_x = "";
        public String THRESHOLD_VALUE_x = "";
        public String OBSERVED_VALUE_x = "";

        public String getSCOPE_NAME_x() {
            return SCOPE_NAME_x;
        }

        public void setSCOPE_NAME_x(String SCOPE_NAME_x) {
            this.SCOPE_NAME_x = SCOPE_NAME_x;
        }

        public String getSCOPE_ID_x() {
            return SCOPE_ID_x;
        }

        public void setSCOPE_ID_x(String SCOPE_ID_x) {
            this.SCOPE_ID_x = SCOPE_ID_x;
        }

        public String getCONDITION_NAME_x() {
            return CONDITION_NAME_x;
        }

        public void setCONDITION_NAME_x(String CONDITION_NAME_x) {
            this.CONDITION_NAME_x = CONDITION_NAME_x;
        }

        public String getCONDITION_ID_x() {
            return CONDITION_ID_x;
        }

        public void setCONDITION_ID_x(String CONDITION_ID_x) {
            this.CONDITION_ID_x = CONDITION_ID_x;
        }

        public String getOPERATOR_x() {
            return OPERATOR_x;
        }

        public void setOPERATOR_x(String OPERATOR_x) {
            this.OPERATOR_x = OPERATOR_x;
        }

        public String getCONDITION_UNIT_TYPE_x() {
            return CONDITION_UNIT_TYPE_x;
        }

        public void setCONDITION_UNIT_TYPE_x(String CONDITION_UNIT_TYPE_x) {
            this.CONDITION_UNIT_TYPE_x = CONDITION_UNIT_TYPE_x;
        }

        public String getUSE_DEFAULT_BASELINE_x() {
            return USE_DEFAULT_BASELINE_x;
        }

        public void setUSE_DEFAULT_BASELINE_x(String USE_DEFAULT_BASELINE_x) {
            this.USE_DEFAULT_BASELINE_x = USE_DEFAULT_BASELINE_x;
        }

        public String getBASELINE_NAME_x() {
            return BASELINE_NAME_x;
        }

        public void setBASELINE_NAME_x(String BASELINE_NAME_x) {
            this.BASELINE_NAME_x = BASELINE_NAME_x;
        }

        public String getBASELINE_ID_x() {
            return BASELINE_ID_x;
        }

        public void setBASELINE_ID_x(String BASELINE_ID_x) {
            this.BASELINE_ID_x = BASELINE_ID_x;
        }

        public String getTHRESHOLD_VALUE_x() {
            return THRESHOLD_VALUE_x;
        }

        public void setTHRESHOLD_VALUE_x(String THRESHOLD_VALUE_x) {
            this.THRESHOLD_VALUE_x = THRESHOLD_VALUE_x;
        }

        public String getOBSERVED_VALUE_x() {
            return OBSERVED_VALUE_x;
        }

        public void setOBSERVED_VALUE_x(String OBSERVED_VALUE_x) {
            this.OBSERVED_VALUE_x = OBSERVED_VALUE_x;
        }

        public void setSCOPE_TYPE_x(String SCOPE_TYPE_x) {

            this.SCOPE_TYPE_x = SCOPE_TYPE_x;
        }
    }

    public static class Evaluation_Entity {
        //		public Evaluation_Entity() {}
        public String toString() {
            return AD_AlertData.toString(this);
        }

        private String EVALUATION_ENTITY_TYPE = "";
        private String EVALUATION_ENTITY_NAME = "";
        private String EVALUATION_ENTITY_ID = "";
        private Integer NUMBER_OF_TRIGGERED_CONDITIONS_PER_EVALUATION_ENTITY;
        private ArrayList<Triggered_Condition> triggers = new ArrayList<Triggered_Condition>();

        public void setEVALUATION_ENTITY_TYPE(String EVALUATION_ENTITY_TYPE) {
            this.EVALUATION_ENTITY_TYPE = EVALUATION_ENTITY_TYPE;
        }

        public void setEVALUATION_ENTITY_NAME(String EVALUATION_ENTITY_NAME) {
            this.EVALUATION_ENTITY_NAME = EVALUATION_ENTITY_NAME;
        }

        public void setEVALUATION_ENTITY_ID(String EVALUATION_ENTITY_ID) {
            this.EVALUATION_ENTITY_ID = EVALUATION_ENTITY_ID;
        }

        public String getEVALUATION_ENTITY_TYPE() {
            return EVALUATION_ENTITY_TYPE;
        }

        public String getEVALUATION_ENTITY_NAME() {
            return EVALUATION_ENTITY_NAME;
        }

        public void setNUMBER_OF_TRIGGERED_CONDITIONS_PER_EVALUATION_ENTITY(int NUMBER_OF_TRIGGERED_CONDITIONS_PER_EVALUATION_ENTITY) {
            this.NUMBER_OF_TRIGGERED_CONDITIONS_PER_EVALUATION_ENTITY = NUMBER_OF_TRIGGERED_CONDITIONS_PER_EVALUATION_ENTITY;
        }

        public Integer getNUMBER_OF_TRIGGERED_CONDITIONS_PER_EVALUATION_ENTITY() {
            return NUMBER_OF_TRIGGERED_CONDITIONS_PER_EVALUATION_ENTITY;
        }

        public void addTrigger(Triggered_Condition trigger) {
            triggers.add(trigger);
        }
    }

    public static class Event_Type {
        public Event_Type() {
        }

        public String getEVENT_TYPE() {
            return EVENT_TYPE;
        }

        public void setEVENT_TYPE(String EVENT_TYPE) {
            this.EVENT_TYPE = EVENT_TYPE;
        }

        public Integer getEVENT_TYPE_NUM() {
            return EVENT_TYPE_NUM;
        }

        public void setEVENT_TYPE_NUM(Integer EVENT_TYPE_NUM) {
            this.EVENT_TYPE_NUM = EVENT_TYPE_NUM;
        }

        public String EVENT_TYPE = "";
        public Integer EVENT_TYPE_NUM;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getTriggeredBy() {
        return triggeredBy;
    }

    public void setTriggeredBy(String triggeredBy) {
        this.triggeredBy = triggeredBy;
    }

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

    public String getBTs() {
        return BTs;
    }

    public void setBTs(String BTs) {
        this.BTs = BTs;
    }

    public String getMachines() {
        return machines;
    }

    public void setMachines(String machines) {
        this.machines = machines;
    }

    public String getTiers() {
        return tiers;
    }

    public void setTiers(String tiers) {
        this.tiers = tiers;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public void setAlertTime(String alertTime) {
        this.alertTime = alertTime;
    }

    public String getPolicyName() {
        return policyName;
    }

    public String getAlertTime() {
        return alertTime;
    }

    public String getAffectedEntityType() {
        return affectedEntityType;
    }

    public String getSummaryMessage() {
        return summaryMessage;
    }

    public String getDeepLinkURL() {
        return deepLinkURL;
    }

    public boolean isHealthRuleViolation() {
        return healthRuleViolation;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getPriority() {
        return priority;
    }

    public String getNotificationName() {
        return notificationName;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getNotificationInterval() {
        return notificationInterval;
    }

//    public String getEnTime() {
//        return enTime;
//    }

    public String getPVN_ALERT_TIME() {
        return PVN_ALERT_TIME;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getPVN_TIME_PERIOD_IN_MINUTES() {
        return PVN_TIME_PERIOD_IN_MINUTES;
    }

    public String getAffectedEntityName() {
        return affectedEntityName;
    }

    public String getAffectedEntityId() {
        return affectedEntityId;
    }

    public void setAffectedEntityType(String affectedEntityType) {
        this.affectedEntityType = affectedEntityType;
    }

    public void setSummaryMessage(String summaryMessage) {
        this.summaryMessage = summaryMessage;
    }

    public void setDeepLinkURL(String deepLinkURL) {
        this.deepLinkURL = deepLinkURL;
    }

    public void setHealthRuleViolation(boolean healthRuleViolation) {
        this.healthRuleViolation = healthRuleViolation;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setNotificationName(String notificationName) {
        this.notificationName = notificationName;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public void setNUMBER_OF_EVENT_TYPES(int NUMBER_OF_EVENT_TYPES) {
        this.NUMBER_OF_EVENT_TYPES = NUMBER_OF_EVENT_TYPES;
    }

    public void setNotificationInterval(String notificationInterval) {
        this.notificationInterval = notificationInterval;
    }

//    public void setEnTime(String enTime) {
//        this.enTime = enTime;
//    }

    public int getNUMBER_OF_EVENT_TYPES() {
        return NUMBER_OF_EVENT_TYPES;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setPVN_ALERT_TIME(String PVN_ALERT_TIME) {
        this.PVN_ALERT_TIME = PVN_ALERT_TIME;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public void setPVN_TIME_PERIOD_IN_MINUTES(String PVN_TIME_PERIOD_IN_MINUTES) {
        this.PVN_TIME_PERIOD_IN_MINUTES = PVN_TIME_PERIOD_IN_MINUTES;
    }

    public void setAffectedEntityName(String affectedEntityName) {
        this.affectedEntityName = affectedEntityName;
    }

    public void setAffectedEntityId(String affectedEntityId) {
        this.affectedEntityId = affectedEntityId;
    }

    public void setNUMBER_OF_EVALUATION_ENTITIES(int NUMBER_OF_EVALUATION_ENTITIES) {
        this.NUMBER_OF_EVALUATION_ENTITIES = NUMBER_OF_EVALUATION_ENTITIES;
    }

    public int getNUMBER_OF_EVALUATION_ENTITIES() {
        return NUMBER_OF_EVALUATION_ENTITIES;
    }

    public void setNUMBER_OF_EVENT_SUMMARIES(int NUMBER_OF_EVENT_SUMMARIES) {
        this.NUMBER_OF_EVENT_SUMMARIES = NUMBER_OF_EVENT_SUMMARIES;
    }

    public int getNUMBER_OF_EVENT_SUMMARIES() {
        return NUMBER_OF_EVENT_SUMMARIES;
    }

    public String toString() {
        return toString(this);
    }

    public static String toString(Object o) {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append(o.getClass().getName());
        result.append(" Object {");
        result.append(newLine);

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = o.getClass().getDeclaredFields();

        //print field names paired with their values
        for (Field field : fields) {
            result.append("  ");
            try {
                result.append(field.getName());
                result.append(": ");
                //requires access to private field:
                result.append(field.get(o));
            } catch (IllegalAccessException ex) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("}");

        return result.toString();
    }

    public void setEventTypes(ArrayList<Event_Type> eventTypes) {
        this.eventTypes = eventTypes;
    }
}
