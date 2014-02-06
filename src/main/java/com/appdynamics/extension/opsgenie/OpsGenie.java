/**
 * Copyright 2013 AppDynamics
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.appdynamics.extension.opsgenie;


import java.util.*;

import com.appdynamics.extension.AlertSender;
import com.appdynamics.opsgenie.type.AD_AlertData;
import com.ifountain.opsgenie.client.IAlertOpsGenieClient;
import com.ifountain.opsgenie.client.OpsGenieClient;
import com.ifountain.opsgenie.client.model.alert.CreateAlertRequest;
import com.ifountain.opsgenie.client.model.alert.CreateAlertResponse;
import org.apache.log4j.Logger;

/**
 * Java class allows sending OpsGenie Alerts
 */
public class OpsGenie implements AlertSender {
    private static Logger logger = Logger.getLogger(OpsGenie.class);

    public void setCustomerKey(String customerKey) {
        this.customerKey = customerKey;
    }

    private String customerKey;

    public String getRecipientList() {
        return recipientList;
    }

    public void setRecipientList(String recipientList) {
        this.recipientList = recipientList;
    }

    private String recipientList;


    public void sendAlert(AD_AlertData alertData) throws Exception {
        logger.info("Sending alert to opsGenie");
        logger.debug(alertData);
        OpsGenieClient client = new OpsGenieClient();
        CreateAlertRequest request = new CreateAlertRequest();
        request.setCustomerKey(getCustomerKey());

        String notificationName = alertData.getNotificationName()==null?"":alertData.getNotificationName();
        request.setMessage(alertData.getSeverity() + " " + notificationName + " reported by application " + alertData.getApplicationName());

        request.setDescription(request.getMessage());
        if (alertData.isHealthRuleViolation()) {
            request.setDescription(alertData.getSummaryMessage());
//            for (Iterator<AD_AlertData.Event_Summary> iterator = alertData.getEventSummaries().iterator(); iterator.hasNext(); ) {
//                AD_AlertData.Event_Summary next = (AD_AlertData.Event_Summary) iterator.next();
//                request.setDescription(request.getDescription() + " " + next.getEVENT_SUMMARY_STRING());
//            }
        }

        Map<String, String> details = new HashMap<String, String>();
        details.put("Application", alertData.getApplicationName());
        details.put("Tiers", alertData.getTiers());
        details.put("BTs", alertData.getBTs());
        details.put("Machines: ", alertData.getMachines());
        request.setDetails(details);

        request.setEntity(alertData.getMachines());
        request.setActions(Arrays.asList("open", alertData.getLink()));
//        request.setTags(Arrays.asList("network", "operations"));
        request.setRecipients(Arrays.asList(recipientList.split(",")));
        IAlertOpsGenieClient alerter = client.alert();

        CreateAlertResponse response = alerter.createAlert(request);

        String alertId = response.getAlertId();
        logger.info("alert sent, alertId: " + alertId);

    }


    public String getCustomerKey() {
        return customerKey;
    }

}
