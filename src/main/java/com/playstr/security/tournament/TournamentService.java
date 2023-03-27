package com.playstr.security.tournament;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    public List<Tournament> getTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament createTournament(TournamentRequest tournamentRequest) {
        var tournament = Tournament.builder()
                .name(tournamentRequest.getName())
                .description(tournamentRequest.getDescription())
                .tournamentUrl(tournamentRequest.getTournamentUrl())
                .gameUrl(tournamentRequest.getGameUrl())
                .build();
        tournamentRepository.save(tournament);
        return tournament;
    }

    public List<Tournament> createTournaments(TournamentListRequest tournamentListRequest) {
        for (TournamentRequest tournamentRequest : tournamentListRequest.getTournaments()) {
            var tournament = Tournament.builder()
                    .name(tournamentRequest.getName())
                    .description(tournamentRequest.getDescription())
                    .tournamentUrl(tournamentRequest.getTournamentUrl())
                    .gameUrl(tournamentRequest.getGameUrl())
                    .build();
            tournamentRepository.save(tournament);
        }
        return getTournaments();
    }
}
