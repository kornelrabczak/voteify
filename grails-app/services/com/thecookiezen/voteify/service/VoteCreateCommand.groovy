package com.thecookiezen.voteify.service

import com.thecookiezen.domain.Vote
import pl.setblack.airomem.core.VoidCommand
import pl.setblack.airomem.data.DataRoot

import java.time.LocalDateTime

class VoteCreateCommand implements VoidCommand<DataRoot<VoteView, VotesStorage>> {

    String author
    LinkedList options

    @Override
    void executeVoid(DataRoot<VoteView, VotesStorage> system) {
        if (options.empty)
            throw new RuntimeException("empty options !")
        system.getDataObject().addVote(new Vote(id: UUID.randomUUID().toString(), author: author, created: LocalDateTime.now(), options: options))
    }
}
