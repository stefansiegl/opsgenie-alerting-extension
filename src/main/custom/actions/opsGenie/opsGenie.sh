#!/bin/sh -x

###
# Copyright 2013 AppDynamics
# 
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
# 
# http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
###

# Uncomment to allow monitoring of this extension (define the POJO on com.appdynamics.extension.AlertingExtension.main())
#MONITOR_WITH_AGENT=true


if [ "x$MONITOR_WITH_AGENT" = "x" ]; then
        echo "Extension monitoring is disabled"
    else
        JAVA_OPT="-javaagent:../../../appserver/glassfish/domains/domain1/appagent/javaagent.jar -Dappdynamics.cron.vm=true -Dappdynamics.controller.hostName=localhost -Dappdynamics.controller.port=8090 -Dappdynamics.agent.accountAccessKey=SJ5b2m7d1\$354 -Dappdynamics.agent.accountName=customer1 -Dappdynamics.agent.applicationName=OpsGenieExt -Dappdynamics.agent.tierName=OpsGenie -Dappdynamics.agent.nodeName=OpsGenie"
    fi

java  $JAVA_OPT -Dlog4j.configuration=file:./conf/log4j.xml -jar ./lib/opsGenie.jar "$@"
