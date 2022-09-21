package com.tchokouaha.spring.training.demospringboot.vote.service;

import com.tchokouaha.spring.training.demospringboot.vote.model.Vote;
import com.tchokouaha.spring.training.demospringboot.vote.repository.VoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VoteService {

    private VoteRepository voteRepository;

    @Autowired

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> getAllVotes() {
        List<Vote> votes = new ArrayList<>();
        Iterable<Vote> votesIterable = voteRepository.findAll();
        votesIterable.forEach(votes::add);
        return votes;
    }

    public Vote createVote(Vote vote) {
        Vote voteSaved = voteRepository.save(vote);
        log.info("Vote: {} created successfully", voteSaved);
        return voteSaved;
    }

    public Optional<Vote> getVoteById(Long id) {
        return voteRepository.findById(id);
    }

    public void deleteVote(Long id) {
        Optional<Vote> voteOptional = getVoteById(id);
        if (voteOptional.isPresent()) {
            Vote vote = voteOptional.get();
            voteRepository.delete(vote);
            log.info("Vote with id: {} deteted successfully", id);
        } else {
            log.warn("Vote with id: {} NOT FOUND and therefore cannot be deleted", id);
        }
    }
}
