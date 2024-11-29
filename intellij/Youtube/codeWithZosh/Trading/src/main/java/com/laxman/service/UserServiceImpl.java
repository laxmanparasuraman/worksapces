package com.laxman.service;

import com.laxman.config.JwtProvider;
import com.laxman.domain.VerificationType;
import com.laxman.model.TwoFactorAuth;
import com.laxman.model.User;
import com.laxman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
        Optional<User>user=userRepository.findById(id);
        if (user.isEmpty()){
            throw new Exception("user not found");
        }
        return  user.get();


    }

    @Override
    public User enableTwoFactorAuthentication(VerificationType verificationType, String sendTo, User user) {
        TwoFactorAuth twoFactorAuth=new TwoFactorAuth();
        twoFactorAuth.setEnable(true);
        twoFactorAuth.setSendTo(verificationType);
        user.setTwoFactorAuth(twoFactorAuth);
        return  userRepository.save(user);

    }


    @Override
    public User updatePassword(User user, String newPassword) {

         user.setPassword(newPassword);
         return  userRepository.save(user);
    }
}
