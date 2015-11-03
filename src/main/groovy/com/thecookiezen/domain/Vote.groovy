package com.thecookiezen.domain

import grails.converters.JSON

import java.time.LocalDateTime

class Vote {
    String author
    LocalDateTime created
    LinkedList options

    static {
        JSON.registerObjectMarshaller(Vote) {
            ["author": it.author, created: it.created.toString(), options: it.options]
        }
    }

    @Override
    String toString() {
        author + ", " + created + ", " + options
    }
}
