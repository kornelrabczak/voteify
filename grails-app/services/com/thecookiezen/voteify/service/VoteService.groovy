package com.thecookiezen.voteify.service

import com.thecookiezen.domain.Vote
import grails.transaction.Transactional

import java.time.LocalDateTime

@Transactional
class VoteService {

    def serviceMethod() {
        new Vote(author: "test", created: LocalDateTime.now(), options: [1,2,3,4,5])
    }
}
