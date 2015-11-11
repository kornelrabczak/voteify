package com.thecookiezen.control.command

import com.thecookiezen.boundary.VoteView
import com.thecookiezen.control.VotesStorage
import pl.setblack.airomem.core.VoidCommand
import pl.setblack.airomem.data.DataRoot

class VoteRemoveCommand implements VoidCommand<DataRoot<VoteView, VotesStorage>> {

    String id

    @Override
    void executeVoid(DataRoot<VoteView, VotesStorage> system) {
        system.getDataObject().removeVote(id)
    }
}
