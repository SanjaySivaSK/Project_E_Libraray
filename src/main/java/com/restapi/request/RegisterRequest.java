package com.restapi.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class RegisterRequest {
    private Long id;
//
//    @NotEmpty
//    @Size(min = 2, message = "Username should have at least 2 characters")
//    @Pattern(regexp = "^[A-Z][a-zA-Z0-9]*$", message = "Username must start with a capital letter")
    private String username;

//    @NotEmpty(message = "password cannot be null")
//    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$%^&+=])(?=.*[a-z])(?=.*\\d).*$",
//            message = "Password must start with a capital letter and contain at least one special character, " +
//                    "one lowercase letter, and one digit")
//    @Size(min = 2, message = "Password should have at least 2 characters")
    private String password;



////    @Pattern(regexp = "^[A-Z][a-zA-Z0-9]*$", message = "Username must start with a capital letter")
//    @Size(min = 5, message = "Name should have at least 2 characters")
    private String name;

    private String address;


    private String profession;




    private Long phoneNumber;
}
