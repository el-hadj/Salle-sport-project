package com.tp.salledesport.userprofile.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public UserProfile(Integer id, String userName, Double weight, Integer age, Gender sex, TrainingProfile trainingProfile) {
        this.id = id;
        this.userName = userName;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
        this.trainingProfile = trainingProfile;
    }

    public UserProfile(String userName, Double weight, Integer age, Gender sex, TrainingProfile trainingProfile) {
        this.userName = userName;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
        this.trainingProfile = trainingProfile;
    }
}
