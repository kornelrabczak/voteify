package com.thecookiezen.control

import com.thecookiezen.entity.Vote
import com.thecookiezen.boundary.VoteView
import pl.setblack.airomem.core.WriteChecker

import java.util.concurrent.CopyOnWriteArrayList
import java.util.stream.Collectors

class VotesStorage implements VoteView, Serializable {
    CopyOnWriteArrayList<Vote> votes

    VotesStorage() {
        votes = new CopyOnWriteArrayList<>();
    }

    @Override
    def List<Vote> getVotes() {
        votes.stream().collect(Collectors.toList())
    }

    @Override
    def void addVote(Vote vote) {
        assert WriteChecker.hasPrevalanceContext();
        votes.add(vote)
    }

    @Override
    def void removeVote(String id) {
        def found = votes.find { it -> it.id == id }
        votes.remove(found)
    }

    @Override
    Vote getVote(String id) {
        return null
    }
}
