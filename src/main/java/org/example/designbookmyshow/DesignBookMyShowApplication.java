package org.example.designbookmyshow;

import org.example.designbookmyshow.controller.UserController;
import org.example.designbookmyshow.dto.SignUpRequestDTO;
import org.example.designbookmyshow.dto.SignUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignBookMyShowApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;

    public void run(String... args) throws Exception {
        SignUpRequestDTO requestDTO = new SignUpRequestDTO();
        requestDTO.setUserName("Sai Krishna");
        requestDTO.setEmail("katanani34@gmail.com");
        requestDTO.setPassword("password123");

        SignUpResponseDTO responseDTO = userController.signUp(requestDTO);
        System.out.println(responseDTO.getResponseStatus());
        System.out.println(responseDTO.getMessage());

        System.out.println("AABBCCDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ");
    }

    public static void main(String[] args) {
        SpringApplication.run(DesignBookMyShowApplication.class, args);
    }
}
