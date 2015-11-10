import grails.converters.JSON

import java.time.LocalDateTime

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(LocalDateTime) { LocalDateTime time ->
            time.toString()
        }
    }

    def destroy = {
    }
}
