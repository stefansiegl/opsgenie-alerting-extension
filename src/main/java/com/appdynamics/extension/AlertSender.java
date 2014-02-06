package com.appdynamics.extension;

import com.appdynamics.opsgenie.type.AD_AlertData;

/**
 * Created with IntelliJ IDEA.
 * User: dbershadsky
 * Date: 1/31/14
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AlertSender {
    void sendAlert(AD_AlertData alertData) throws Exception;
}
