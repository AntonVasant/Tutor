package com.anton.TutoringNetwork.model;

import lombok.Data;
import org.springframework.data.aot.ManagedTypesBeanRegistrationAotProcessor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
@Data
public class Tutor {
    private Long id;

    private String userName;
    private String email;
    private String password;

}
