package com.empresa.motoboy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private int status;
    private String message;
    private LocalDateTime timestamp;

}
