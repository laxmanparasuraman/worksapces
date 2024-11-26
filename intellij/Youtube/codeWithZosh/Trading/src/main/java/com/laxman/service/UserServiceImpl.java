package com.laxman.service;

import com.laxman.config.JwtProvider;
import com.laxman.model.User;
import com.laxman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User findUserProfileByEmail(String email) {
        User user =userRepository.findByEmail(email);
        if (user==null){
            throw new Exception("User not found");
        }

        return user;
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws Exception {

        String email= JwtProvider.getEmailFromToken(jwt);
        User user =userRepository.findByEmail(email);
          if (user==null){
              throw new Exception("User not found");
          }

        return user;
    }

    @Override
    public User findUserProfileById(String id) {


    }

    @Override
    public User enableTwoFactorAuthentication(User user) {
        return null;
    }

    @Override
    public User updatePassword(User user, String newPassword) {
        return null;
    }
}
