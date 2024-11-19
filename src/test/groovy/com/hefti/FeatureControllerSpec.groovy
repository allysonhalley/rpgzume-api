package com.hefti

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class FeatureControllerSpec extends Specification implements ControllerUnitTest<FeatureController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
