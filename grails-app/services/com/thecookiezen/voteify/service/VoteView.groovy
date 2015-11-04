package com.thecookiezen.voteify.service

import com.thecookiezen.domain.Vote

interface VoteView {
    List<Vote> getVotes()
    void addVote(String author, LinkedList options)
}
