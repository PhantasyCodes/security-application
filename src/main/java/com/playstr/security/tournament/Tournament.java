package com.playstr.security.tournament;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tournament {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] tournamentPic;
    private String game;
    private String date;
    private Integer price;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
