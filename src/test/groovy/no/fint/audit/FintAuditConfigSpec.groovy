package no.fint.audit

import spock.lang.Specification

class FintAuditConfigSpec extends Specification {

    def "Use test mongo instance when test-mode is enabled"() {
        given:
        def config = new FintAuditConfig(testMode: 'true')

        when:
        def mongo = config.mongo()

        then:
        mongo != null
        mongo.fongo.serverAddress.host == '127.0.0.1' || mongo.fongo.serverAddress.host == 'localhost'
        mongo.fongo.serverAddress.port == 27017
    }
}
