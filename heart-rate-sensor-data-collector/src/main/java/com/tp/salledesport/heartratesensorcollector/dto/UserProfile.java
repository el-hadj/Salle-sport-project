package com.tp.salledesport.heartratesensorcollector.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {


    private Integer id;
    private String userName;
    private Double weight;
    private Integer age;
    private boolean subscription;
    private Integer coachId;

}
