package org.example.designbookmyshow.controller;

import org.example.designbookmyshow.dto.ResponseStatus;
import org.example.designbookmyshow.dto.SignUpRequestDTO;
import org.example.designbookmyshow.dto.SignUpResponseDTO;
import org.example.designbookmyshow.model.User;
import org.example.designbookmyshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public SignUpResponseDTO signUp(SignUpRequestDTO requestDTO) {
        SignUpResponseDTO signupResponseDTO = new SignUpResponseDTO();

        try {
            User user = userService.signUp(
                    requestDTO.getUserName(),
                    requestDTO.getEmail(),
                    requestDTO.getPassword()
            );

            signupResponseDTO.setUserId(user.getId());
            signupResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            signupResponseDTO.setMessage("User registered successfully");
        } catch (Exception e) {
            signupResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            signupResponseDTO.setMessage(e.getMessage());
        }

        return signupResponseDTO;
    }
}
