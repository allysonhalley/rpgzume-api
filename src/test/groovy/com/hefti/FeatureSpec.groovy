package com.hefti

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class FeatureSpec extends Specification implements DomainUnitTest<Feature> {

     void "test domain constraints"() {
        when:
        Feature domain = new Feature()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
