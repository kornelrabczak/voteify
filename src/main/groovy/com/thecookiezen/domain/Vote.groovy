package com.thecookiezen.domain

import java.time.LocalDateTime

class Vote {

    String id
    String author
    LocalDateTime created
    LinkedList options

    @Override
    String toString() {
       id + ", " + author + ", " + created + ", " + options
    }
}
