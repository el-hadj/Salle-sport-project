package com.tp.salledesport.heartratesensorworker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoachProfile {


    private Integer idCoach;
    private String coachName;
    private Integer userAssigned;
}
