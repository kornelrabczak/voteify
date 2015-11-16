package voteify

import com.thecookiezen.entity.Vote
import com.thecookiezen.voteify.service.VoteService
import grails.rest.RestfulController
import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.*

class VoteController extends RestfulController {

    VoteService voteService

    static allowedMethods = [index: "GET", save: "POST", update: "PUT", delete: "DELETE"]
    static responseFormats = ['json']

    VoteController() {
        super(Vote.class)
    }

    @Override
    def index() {
        respond voteService.getAllVotes()
    }

    def save(Vote vote) {
        def instance = voteService.createVote(vote.author, vote.options)
        respond status: CREATED, instance
    }

    @Override
    def delete() {
        def instance = queryForResource(params.id as String)
        if (instance == null) {
            respond status: NOT_FOUND
        }

        voteService.removeVote(instance.id)
        respond status: GONE
    }

    @Override
    protected Vote queryForResource(Serializable id) {
        println id
        voteService.getById(id)
    }
}
