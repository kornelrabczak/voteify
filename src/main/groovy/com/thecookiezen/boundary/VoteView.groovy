package com.thecookiezen.boundary

import com.thecookiezen.entity.Vote

interface VoteView {
    List<Vote> getVotes()
    void addVote(Vote vote)
    void removeVote(String id)

    Vote getVote(String id)
}
