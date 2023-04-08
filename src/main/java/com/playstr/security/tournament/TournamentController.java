package com.playstr.security.tournament;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = { "multipart/form-data", "Content-Type" })
    @PostMapping(value="/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Tournament> createTournament(@RequestParam("name") String name,
                                                       @RequestParam("game") String game,
                                                       @RequestParam("price") Integer price,
                                                       @RequestParam("date") String date,
                                                       @RequestParam("description") String description,
                                                       @RequestParam("tournamentPic")MultipartFile tournamentPic) {
        return ResponseEntity.ok(tournamentService.createTournament(name, game, price, date, description, tournamentPic));
    }

//    @PostMapping("/tournament-list")
//    public ResponseEntity<List<Tournament>> createTournaments(@RequestBody TournamentListRequest tournamentListRequest) {
//        return ResponseEntity.ok(tournamentService.createTournaments(tournamentListRequest));
//    }
}
