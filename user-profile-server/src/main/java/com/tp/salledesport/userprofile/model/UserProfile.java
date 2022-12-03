package com.tp.salledesport.userprofile.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userName;
    private Double weight;
    private Integer age;
    private Gender sex;
    private boolean subscription;
    private TrainingProfile trainingProfile;

    private Integer coachId;

    public UserProfile(Integer id, String userName, Double weight, Integer age, Gender sex, Integer coachId) {
        this.id = id;
        this.userName = userName;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
        this.coachId = coachId;
    }

    public UserProfile(String userName, Double weight, Integer age, Gender sex, TrainingProfile trainingProfile) {
        this.userName = userName;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
        //this.coachProfile = coachProfile;
    }
}
