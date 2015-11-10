package com.thecookiezen.voteify.service

import grails.transaction.Transactional
import pl.setblack.airomem.core.PersistenceController
import pl.setblack.airomem.core.builders.PersistenceFactory
import pl.setblack.airomem.data.DataRoot

import javax.annotation.PostConstruct

@Transactional
class VoteService {

    PersistenceController<DataRoot<VoteView, VotesStorage>, VoteView> controller;

    @PostConstruct
    def init() {
        final PersistenceFactory factory = new PersistenceFactory();
        controller = factory.initOptional("vote", { new DataRoot<>(new VotesStorage()) });
    }

    def createVote(String author, LinkedList options) {
        def command = new VoteCreateCommand(author: author, options: options)
        controller.execute(command)
    }

    def removeVote(String id) {
        def command = new VoteRemoveCommand(id: id)
        controller.execute(command)
    }

    def getAllVotes() {
        controller.query({ view -> view.getVotes() })
    }
}
