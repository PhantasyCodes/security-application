package com.playstr.security.tournament;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private String tournamentUrl;
    private String gameUrl;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
