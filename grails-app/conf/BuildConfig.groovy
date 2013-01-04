grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
    }
    dependencies {
    }
    plugins {
        compile(':rest-client-builder:1.0.2') {
            export = false
        }
        build(":tomcat:$grailsVersion",
              ":release:2.0.4") {
            export = false
        }
        test ":spock:0.6"
    }
}
