package com.laxman.service;

import com.laxman.model.TwoFactorOTP;
import com.laxman.model.User;

public interface TwoFactorOtpService {

    TwoFactorOTP CreateTwoFactoryOtp(User user, String otp, String jwt );
    TwoFactorOTP findById(String id);
    TwoFactorOTP findByUser(Long userId);
    boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOTP,String opt);
    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP);
}
