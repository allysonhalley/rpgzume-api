package com.hefti

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CardSpec extends Specification implements DomainUnitTest<Card> {

     void "test domain constraints"() {
        when:
        Card domain = new Card()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
