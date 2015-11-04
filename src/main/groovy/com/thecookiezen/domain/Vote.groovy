package com.thecookiezen.domain

import com.thecookiezen.voteify.serializer.LocalDateTimeMarshaller
import com.thecookiezen.voteify.service.VoteView
import grails.converters.JSON
import pl.setblack.airomem.core.WriteChecker

import java.time.LocalDateTime
import java.util.concurrent.CopyOnWriteArrayList
import java.util.stream.Collectors

class Vote implements VoteView, Serializable {
    private CopyOnWriteArrayList<Vote> votes;

    String author
    LocalDateTime created
    LinkedList options

    static {
        JSON.registerObjectMarshaller(new LocalDateTimeMarshaller())
    }

    @Override
    String toString() {
        author + ", " + created + ", " + options
    }

    @Override
    List<Vote> getVotes() {
        votes.stream().collect(Collectors.toList())
    }

    @Override
    void addVote(String author, LinkedList options) {
        assert WriteChecker.hasPrevalanceContext();
        votes.add(new Vote(author: "test", created: LocalDateTime.now(), options: [1,2,3,4,5]))
    }
}
