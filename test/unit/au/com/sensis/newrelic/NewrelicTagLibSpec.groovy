package au.com.sensis.newrelic

import grails.util.Environment
import spock.lang.Specification

class NewrelicTagLibSpec extends Specification {

    def NewrelicTagLib tagLib = new NewrelicTagLib()

    def setup() {
        tagLib.grailsApplication =  [ config: [:] ]
    }

    def "should be enabled for PRODUCTION by default"() {
        when:
            setEnvironment(Environment.PRODUCTION)

        then:
            assert tagLib.enabled == true
    }

    def "should be disabled for NON-PRODUCTION by default" () {
        when:
            setEnvironment(Environment.CUSTOM)

        then:
            assert tagLib.enabled == false
    }

    def "should be enabled when config enables NewRelic" () {
        when:
            enableNewRelic(true)

        then:
            assert tagLib.enabled == true
    }

    def "should be disabled for PRODUCTION when config disables NewRelic" () {
        when:
            setEnvironment(Environment.PRODUCTION)
            enableNewRelic(false)

        then:
            assert tagLib.enabled == false
    }

    private setEnvironment(environment) {
        Environment.metaClass.static.getCurrent = { ->
            return environment
        }
    }

    private enableNewRelic(boolean value){
        tagLib.grailsApplication.config = [
            newrelic: [
                enabled: value
            ]
        ]
    }
}
