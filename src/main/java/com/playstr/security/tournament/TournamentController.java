package com.playstr.security.tournament;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tournaments")
@RequiredArgsConstructor
public class TournamentController {
    private final TournamentService tournamentService;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/all-tournaments")
    public List<Tournament> getTournaments() {
        return tournamentService.getTournaments();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/{id}")
    public Optional<Tournament> getTournament(@PathVariable Integer id) {
        return tournamentService.getTournament(id);
    }

    @PostMapping
    public ResponseEntity<Tournament> createTournament(@RequestBody TournamentRequest tournamentRequest) {
        return ResponseEntity.ok(tournamentService.createTournament(tournamentRequest));
    }

    @PostMapping("/tournament-list")
    public ResponseEntity<List<Tournament>> createTournaments(@RequestBody TournamentListRequest tournamentListRequest) {
        return ResponseEntity.ok(tournamentService.createTournaments(tournamentListRequest));
    }
}
