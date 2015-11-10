package voteify

import com.thecookiezen.voteify.service.VoteService
import grails.converters.JSON

class HelloController {

    VoteService voteService

    def index() {
        [something: "Hello world! \n"]
    }

    def asJson() {
        def method = voteService.getAllVotes()
        render method as JSON
    }

    def create() {
        voteService.createVote("test", [1, 2, 3, 4] as LinkedList)
    }

    def remove() {
        [something: "todo remote! \n"]
    }
}