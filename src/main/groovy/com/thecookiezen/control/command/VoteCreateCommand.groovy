package com.thecookiezen.control.command

import com.thecookiezen.boundary.VoteView
import com.thecookiezen.control.VotesStorage
import com.thecookiezen.entity.Vote
import pl.setblack.airomem.core.Command
import pl.setblack.airomem.data.DataRoot

import java.time.LocalDateTime

class VoteCreateCommand implements Command<DataRoot<VoteView, VotesStorage>, Vote> {

    String author
    LinkedList options

    @Override
    Vote execute(DataRoot<VoteView, VotesStorage> system) {
        if (options.empty)
            throw new RuntimeException("empty options !")

        def vote = new Vote(id: UUID.randomUUID().toString(), author: author, created: LocalDateTime.now(), options: options)
        system.getDataObject().addVote(vote)
        vote
    }
}
