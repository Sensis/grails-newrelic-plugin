[![Build Status](https://travis-ci.org/Sensis/grails-newrelic-plugin.png?branch=master)](https://travis-ci.org/Sensis/grails-newrelic-plugin)

Introduction
============
This plugin will make [New Relic](http://newrelic.com) instrumentation available to a Grails project.  New Relic provides some extensive documentation on adding their Agent to a running web application, however the Real User Monitoring (RUM) feature is not automatically enabled for GSP pages.  This project aims to bridge that gap by providing a taglib to call on the GSP Layout page.

New Relic
=========
To be able to use this plugin, NewRelic must be installed and configured.
Installation
------------
New Relic needs to be installed on the running application server in order for the plugin to work.  This is [extensively documented](https://newrelic.com/docs/java/java-agent-installation) by the New Relic team.

Configuration
-------------
Once installed, New Relic will need to be configured to both [enable RUM](https://newrelic.com/docs/java/real-user-monitoring-in-java#enable) and [turn off auto instrumentation](https://newrelic.com/docs/java/real-user-monitoring-in-java#manual).

Grails New Relic Plugin
=======================
Install plugin
--------------
This plugin is hosted on Grails Plugins Central so it is as easy as:

```bash
grails install-plugin newrelic
```

Usage
-----
Once New Relic and this plugin has been added to your web application, you are ready to add the tags to your page(s).  New Relic provides some [recommendations](https://newrelic.com/docs/java/real-user-monitoring-in-java) on when to all these tag methods.  Ideally, you would only need to add it to your layout page(s) as follows:

```jsp
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <newrelic:browserTimingHeader/>
    <!-- other tags -->
</head>
<body>
    <!-- more tags -->
    <newrelic:browserTimingFooter/>
</body>
</html>
``` 

However, if there are more GSP that need these tags, then just make sure they are added at the appropriate locations in the DOM.

Configs
-------
By default the New Relic RUM code will only be enabled for Production environments.  If you need it to be enabled for other environments, make sure that it is explicitly enabled in your configs

```
newrelic.enabled = true
```

Enabling NewRelic for Development
---------------------------------
NewRelic should be enabled in the production environment as per the instructions [here](https://newrelic.com/docs/java/java-agent-installation), but if you need to enable this in other environments, make sure that the configs have enabled NewRelic for your environment, and add the following to your GRAILS_OPT environment

```bash
export GRAILS_OPTS="-javaagent:/path/to/newrelic.jar"
```

The next time you execute 'run-app' or 'run-war', NewRelic instrumentation code will be included in your generated HTML pages.

On newer versions of grails that use a forked jvm, you may need to include the java agent in your tomcat configuration. This is in BuildConfig.groovy.

```groovy
grails.tomcat.jvmArgs = ["-javaagent:/path/to/newrelic.jar"]
```

Advanced topics
===============
For other usages of the NewRelic plugin, see the [wiki pages](https://github.com/Sensis/grails-newrelic-plugin/wiki) for more information.
