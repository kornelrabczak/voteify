package com.thecookiezen.voteify.serializer

import grails.converters.JSON
import org.grails.web.converters.exceptions.ConverterException
import org.grails.web.converters.marshaller.ObjectMarshaller

import java.time.LocalDateTime

class LocalDateTimeMarshaller implements ObjectMarshaller<JSON> {
    @Override
    boolean supports(Object object) {
        object instanceof LocalDateTime
    }

    @Override
    void marshalObject(Object object, JSON converter) throws ConverterException {
        def time = (LocalDateTime) object
        time.toString()
    }
}
