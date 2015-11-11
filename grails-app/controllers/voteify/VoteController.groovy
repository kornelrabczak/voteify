package voteify

import com.thecookiezen.entity.Vote
import com.thecookiezen.voteify.service.VoteService
import grails.rest.RestfulController

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NO_CONTENT

class VoteController extends RestfulController {

    VoteService voteService

    static responseFormats = ['json']

    VoteController() {
        super(Vote.class)
    }

    @Override
    def index() {
        respond voteService.getAllVotes()
    }

    @Override
    def save() {
        def instance = voteService.createVote(params.author as String, params.options as LinkedList)
        respond instance, [status: CREATED]
    }

    @Override
    def delete() {
        def instance = queryForResource(params.id as String)
        if (instance == null) {
            notFound()
            return
        }

        voteService.removeVote(instance.id)
        render status: NO_CONTENT
    }


    @Override
    protected Vote queryForResource(Serializable id) {
        respond voteService.getById(id)
    }
}
