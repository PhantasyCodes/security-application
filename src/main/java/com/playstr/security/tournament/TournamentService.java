package com.playstr.security.tournament;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    public List<Tournament> getTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournament(Integer id) {
        return tournamentRepository.findById(id);
    }

    public Tournament createTournament(String name, String game, Integer price, String date, String description, MultipartFile tournamentPic) {
        byte[] bytes = null;
        try {
            bytes = tournamentPic.getBytes();
        } catch (IOException e) {
            ;
        }

        var tournament = Tournament.builder()
                .name(name)
                .description(description)
                .tournamentPic(bytes)
                .game(game)
                .date(date)
                .price(price)
                .build();
        tournamentRepository.save(tournament);
        return tournament;
    }

//    public List<Tournament> createTournaments(TournamentListRequest tournamentListRequest) {
//        for (TournamentRequest tournamentRequest : tournamentListRequest.getTournaments()) {
//            var tournament = Tournament.builder()
//                    .name(tournamentRequest.getName())
//                    .description(tournamentRequest.getDescription())
//                    .tournamentUrl(tournamentRequest.getTournamentUrl())
//                    .gameUrl(tournamentRequest.getGameUrl())
//                    .game(tournamentRequest.getGame())
//                    .build();
//            tournamentRepository.save(tournament);
//        }
//        return getTournaments();
//    }
}
