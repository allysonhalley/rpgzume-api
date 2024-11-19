package com.hefti

import grails.rest.Resource

@Resource(uri = '/features', formats = ['json', 'xml'])
class Feature {

    Card card
    String prerequisites
    String benefit
    String normal
    String special

    static constraints = {
        card nullable: false
        prerequisites maxSize: 255
        benefit nullable: true
        normal nullable: true
        special nullable: true
    }
}