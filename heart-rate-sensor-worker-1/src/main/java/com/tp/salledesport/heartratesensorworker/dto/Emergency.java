package com.tp.salledesport.heartratesensorworker.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Emergency {

    private Integer idEmergency;
    private Integer idUser;
    private Integer idCoach;
    private LocalDateTime emergencytime;
}
