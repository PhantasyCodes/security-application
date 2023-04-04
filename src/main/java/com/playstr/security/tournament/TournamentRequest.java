package com.playstr.security.tournament;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TournamentRequest {
    private String name;
    private String description;
    private String tournamentUrl;
    private String gameUrl;
    private String game;
}
