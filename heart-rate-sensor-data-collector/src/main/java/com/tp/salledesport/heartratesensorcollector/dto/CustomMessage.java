package com.tp.salledesport.heartratesensorcollector.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomMessage {


    private String idMessage;
    private Integer idHeartUser;
    private Integer userId;
    private Integer age;
    private Float heartRateNow;
}
