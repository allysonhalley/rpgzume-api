package com.hefti

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class CardControllerSpec extends Specification implements ControllerUnitTest<CardController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
