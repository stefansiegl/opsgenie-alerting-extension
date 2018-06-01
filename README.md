# AppDynamics OpsGenie Alerting Integration

##Use Case

OpsGenie is a notification/alerting system that helps you configure how and when your alerts are being delivered.

With this extension you can forward alerts triggered via an AppDynamics 3.6/3.7 event or policy violation
to the OpsGenie system for further delivery to the individual recipients.

This extension is configured as a custom action on the AppDynamics controller (see Installation).

## Extension
This is a quick fix for a customer project in which we need to report to OpsGenie. Unfortunately right now the proxy settings in AppDynamics do not apply to HTTP Request templates, thus the usual integration with OpsGenie is not working in our setup (we need a proxy). Thus in this quick fix, I simply set the proxy within the code. A more suitable solution would be to set the proxy in the configuration, but I feel that this is not a time well spent, as the integration should be done via HTTP Request Templates anyway, so this is just there until the bug is fixed with AppDynamics.

##Installation

1. Deploy into Controller directory

    1.1  Either download the OpsGenieAlertingExtension.zip file from [AppSphere](http://appsphere.appdynamics.com/)
    or type "ant package" (without the quotes) in the root directory of the cloned repository and find the zip file in the 'dist' directory.
    
    1.2  Copy the zip file into the \<Controller-install-dir\> directory. Unzip the file. You will see a prompt if you already have a custom.xml
    in the \<Controller-install-dir\>/custom/actions/ directory, don't let the unzip process overwrite it. Instead, merge
    the contents.
    
2. cd into \<Controller-install-dir\>/custom/opsgenie/lib and edit the config.properties configuration file:

	###Parameters
	#Customer key for the OpsGenie authentication
    customer-key=e83a2035-x992-44e3-8974-4727c738fc30
    # Comma separated list of emails to receive the alerts
    recipient-list=dbershadsky@appdynamics.com
	~~~~
	
3.  Now you are ready to use this extension as a custom action. In the AppDynamics UI, go to 'Alert & Respond' -> 
'Actions'. Click on the 'Create Action' button. Select 'Custom Action' and click OK. In the drop-down menu you
can find the action called 'opsgenie'.

##Debugging

To debug the code:

1.  Modify the custom\actions\opsgenie\conf\log4j.xml config file and enable debug level logs.


	~~~~
    <logger name="com.appdynamics" additivity="false">
    	<level value="debug"/>
	~~~~

2.  Open \<custom\_action\_directory\>/logs/opsGenie.log

##Testing

If you'd like to send a test alert for Debug purpose please use the opsGenieSendSampleAlert.sh script.
This Script will send a simple alert using the Action Configuration.
You can use this to verify that the transmission works and the alert would be received *without* the need of producing a real error or event.


##Using the jar file as a standalone

The jar file can be used as a standalone. For information enter "--help" when running the jar:

	~~~~
    java -jar opsGenie.jar --help
   	~~~~



##Contributing

Always feel free to fork and contribute any changes directly via [GitHub](https://github.com/Appdynamics/opsgenie-alerting-extension).

##Community

Find out more in the [AppSphere](http://appsphere.appdynamics.com/) community.

##Support

For any questions or feature request, please contact [AppDynamics Center of Excellence](mailto:ace-request@appdynamics.com).
