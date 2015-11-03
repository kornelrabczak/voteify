package voteify

import com.thecookiezen.voteify.service.VoteService
import grails.converters.JSON

class HelloController {

    VoteService voteService

    def index() {
        def method = voteService.serviceMethod()
        [something: "Hello world! \n" + method]
    }

    def asJson() {
        def method = voteService.serviceMethod()
        render method as JSON
    }
}
