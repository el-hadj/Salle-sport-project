package com.tp.salledesport.userprofile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CoachProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCoach;
    private String coachName;
    private Integer userAssigned;
}
