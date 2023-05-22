package com.example.demo.service;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Exceptions.InvalidCredentialsException;
import com.example.demo.model.UserDetails;
import com.example.demo.repositiory.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public UserRepository userRepo;

    public String  loginUser(LoginDto loginDt0) throws InvalidCredentialsException {
        System.out.println(loginDt0.getEmail());
        UserDetails user = userRepo.findEmailAndPassword(loginDt0.getEmail(),loginDt0.getPassword());
        if(user == null){
            throw new InvalidCredentialsException("username or password invalid");
        }
        return "login Sucessfull";
    }
}
