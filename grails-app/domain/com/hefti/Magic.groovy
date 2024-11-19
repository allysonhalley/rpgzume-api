package com.hefti

import grails.rest.Resource

@Resource(uri = '/magics', formats = ['json', 'xml'])
class Magic {

    Card card
    String type
    String level
    String components
    String castTime
    String range
    String targetArea
    String duration
    String savingThrow
    String spellResistance
    String effect

    static constraints = {
        card nullable: false
        type blank: false, maxSize: 255
        level maxSize: 50
        components nullable: true
        castTime maxSize: 255
        range maxSize: 255
        targetArea maxSize: 255
        duration maxSize: 255
        savingThrow maxSize: 255
        spellResistance maxSize: 255
        effect nullable: true
    }
}