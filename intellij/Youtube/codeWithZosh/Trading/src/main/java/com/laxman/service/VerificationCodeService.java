package com.laxman.service;

import com.laxman.domain.VerificationType;
import com.laxman.model.User;
import com.laxman.model.VerificationCode;

public interface VerificationCodeService{
    VerificationCode sendVerificationCode(

            User user, VerificationType verificationType);

    VerificationCode getVerificationCodeById(Long id) throws Exception;

    VerificationCode  getVerificationCodeByUser(Long userId);

    void deleteVerificationCodeById(VerificationCode verificationCode);


}
