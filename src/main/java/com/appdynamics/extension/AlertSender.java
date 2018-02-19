/*
 *   Copyright 2018. AppDynamics LLC and its affiliates.
 *   All Rights Reserved.
 *   This is unpublished proprietary source code of AppDynamics LLC and its affiliates.
 *   The copyright notice above does not evidence any actual or intended publication of such source code.
 *
 */

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
