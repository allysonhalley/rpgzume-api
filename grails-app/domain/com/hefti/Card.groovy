package com.hefti

import grails.rest.Resource

@Resource(uri = '/cards', formats = ['json', 'xml'])
class Card {

    String name
    String resume
    String description
    String book
    Integer page

    static constraints = {
        name blank: false, maxSize: 255
        resume maxSize: 500
        description nullable: true
        book maxSize: 255
        page nullable: true, min: 1
    }
}