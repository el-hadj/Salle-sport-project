package com.tp.salledesport.heartratesensorworker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
