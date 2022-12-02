package com.tp.salledesport.heartratesensorworker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class HeartRateUser {

    private Integer id;
    private String userName;
    private String yearOfBirth;
}
