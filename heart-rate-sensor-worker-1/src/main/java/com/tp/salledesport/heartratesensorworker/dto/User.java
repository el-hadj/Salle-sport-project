package com.tp.salledesport.heartratesensorworker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String userName;
    private Double weight;
    private boolean subscription;
    private Integer age;
}
