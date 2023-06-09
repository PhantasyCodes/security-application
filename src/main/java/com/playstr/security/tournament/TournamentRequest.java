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
    private byte[] tournamentPic;
    private String game;
    private String date;
    private Integer price;
    private String description;
}
