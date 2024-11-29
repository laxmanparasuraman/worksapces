package com.laxman.service;

import com.laxman.domain.VerificationType;
import com.laxman.model.User;

public interface UserService {

    public User findUserProfileByEmail(String email);
    public User findUserProfileByJwt(String jwt);
    public User findUserProfileById(String id);

    public  User enableTwoFactorAuthentication(VerificationType verificationType,
                                               String sendTo,User user);
    User updatePassword(User user ,String newPassword);
}
