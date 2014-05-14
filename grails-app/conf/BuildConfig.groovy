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
        mavenCentral()
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        compile "com.newrelic.agent.java:newrelic-api:3.6.0"
        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
    }
    plugins {
        compile(':rest-client-builder:1.0.3') {
            export = false
        }
        build(":tomcat:$grailsVersion",
              ":release:2.2.1") {
            export = false
        }
        test(":spock:0.7") {
            exclude "spock-grails-support"
            export = false
        }
    }
}
