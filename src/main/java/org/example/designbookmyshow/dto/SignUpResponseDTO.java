package org.example.designbookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    private Long userId;
    private ResponseStatus responseStatus;
    private String message;
}
