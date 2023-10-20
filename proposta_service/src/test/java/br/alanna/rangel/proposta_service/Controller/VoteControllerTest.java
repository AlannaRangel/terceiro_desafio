package br.alanna.rangel.proposta_service.Controller;

import br.alanna.rangel.proposta_service.Model.Vote;
import br.alanna.rangel.proposta_service.Model.VotoType;
import br.alanna.rangel.proposta_service.Service.VoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VoteControllerTest {

    @InjectMocks
    private VoteController voteController;

    @Mock
    private VoteService voteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCastVoteWithValidVoteType() {
        Vote vote = new Vote();
        vote.setVotoType(VotoType.APPROVE);

        when(voteService.castVote(vote)).thenReturn(vote);

        ResponseEntity<Vote> response = voteController.castVote(vote);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(vote, response.getBody());
    }

    @Test
    public void testCastVoteWithInvalidVoteType() {
        Vote vote = new Vote();
        vote.setVotoType(null);

        ResponseEntity<Vote> response = voteController.castVote(vote);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testCastVoteWithException() {
        Vote vote = new Vote();
        vote.setVotoType(VotoType.APPROVE);

        when(voteService.castVote(vote)).thenThrow(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));

        ResponseEntity<Vote> response = voteController.castVote(vote);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}