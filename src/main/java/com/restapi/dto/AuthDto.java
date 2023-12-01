package com.restapi.dto;

import com.restapi.model.AppUser;
import com.restapi.request.RegisterRequest;
import com.restapi.response.AuthResponse;
import org.springframework.stereotype.Component;

@Component
public class AuthDto {

    public AppUser mapToAppUser(RegisterRequest user) {
        AppUser appUser = new AppUser();
        appUser.setUsername(user.getUsername());
        appUser.setName(user.getName());
        appUser.setPassword(user.getPassword());
       appUser.setAddress(user.getAddress());
        appUser.setPhoneNumber(user.getPhoneNumber());
        appUser.setProfession(user.getProfession());
        return appUser;
    }


    public AuthResponse mapToAuthResponse(AppUser appUser) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setId(appUser.getId());
        authResponse.setName(appUser.getName());
        authResponse.setUsername(appUser.getUsername());
        authResponse.setRole(appUser.getRoles().getName());
        authResponse.setAddress(appUser.getAddress());
        authResponse.setPhoneNumber(appUser.getPhoneNumber());
        authResponse.setProfession(appUser.getProfession());
        return authResponse;
    }

}
