package com.hefti

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MagicSpec extends Specification implements DomainUnitTest<Magic> {

     void "test domain constraints"() {
        when:
        Magic domain = new Magic()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
