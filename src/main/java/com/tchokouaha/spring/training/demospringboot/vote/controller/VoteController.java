package com.tchokouaha.spring.training.demospringboot.vote.controller;

import com.tchokouaha.spring.training.demospringboot.vote.model.Vote;
import com.tchokouaha.spring.training.demospringboot.vote.service.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class VoteController {
    VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("/votes")
    ResponseEntity<List<Vote>> getAllVotes() {
        List<Vote> votes = voteService.getAllVotes();
        return ResponseEntity.of(Optional.of(votes));
    }

    @PostMapping("/votes")
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote) {
        Vote voteCreated = voteService.createVote(vote);
        return ResponseEntity.of(Optional.of(voteCreated));
    }

    @PostMapping("/template")
    public String savevoteByTemplate(@RequestBody Vote vote) {
        RestTemplate restTemplate = new RestTemplate();
        log.info("called");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/api/votes", vote, String.class);
        return responseEntity.getBody();
    }


}
