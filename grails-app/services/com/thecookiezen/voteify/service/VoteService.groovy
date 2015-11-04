package com.thecookiezen.voteify.service

import com.thecookiezen.domain.Vote
import grails.transaction.Transactional
import pl.setblack.airomem.core.PersistenceController
import pl.setblack.airomem.core.builders.PersistenceFactory
import pl.setblack.airomem.data.DataRoot

import javax.annotation.PostConstruct

@Transactional
class VoteService {

    PersistenceController<DataRoot<VoteView, Vote>, VoteView> controller;

    @PostConstruct
    def init() {
        final PersistenceFactory factory = new PersistenceFactory();
        controller = factory.initOptional("vote", { new DataRoot<>(new Vote()) });
    }

    def createVote(String author, LinkedList options) {
//        controller.execute({ cmd -> cmd.addVote(author, options) })
    }

    def getAllVotes() {
        controller.query({ view -> view.getVotes() })
    }
}
