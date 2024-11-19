package com.hefti

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class MagicControllerSpec extends Specification implements ControllerUnitTest<MagicController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
