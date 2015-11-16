package com.thecookiezen.entity

import grails.validation.Validateable

import java.time.LocalDateTime

class Vote implements Validateable {

    String id
    String author
    LocalDateTime created
    LinkedList options

    static constraints = {
        author size: 5..15, blank: false
        options size: 0..15, blank: false
    }

    @Override
    String toString() {
       id + ", " + author + ", " + created + ", " + options
    }
}
