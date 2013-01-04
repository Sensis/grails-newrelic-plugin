class NewrelicGrailsPlugin {
    // the plugin version
    def version = "2.12.0"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Newrelic Plugin"
    def author = "C.P. Lim"
    def authorEmail = "c.p.lim@sensis.com.au"
    def description = '''\
Newrelic plugin for Grails
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/newrelic"

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
    def organization = [ name: "Sensis", url: "http://developers.sensis.com.au/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ url: "https://github.com/Sensis/grails-newrelic-plugin/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/Sensis/grails-newrelic-plugin/" ]
}
