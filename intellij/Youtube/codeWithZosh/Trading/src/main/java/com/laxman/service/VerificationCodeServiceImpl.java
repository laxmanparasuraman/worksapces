package com.laxman.service;

import com.laxman.domain.VerificationType;
import com.laxman.model.User;
import com.laxman.model.VerificationCode;
import com.laxman.repository.VerificationCodeRepository;
import com.laxman.utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificationCodeServiceImpl implements  VerificationCodeService {


    @Autowired
    private VerificationCodeRepository verificationCodeRepository;
    @Override
    public VerificationCode sendVerificationCode(User user, VerificationType verificationType) {

           VerificationCode verificationCode1=new VerificationCode();

           verificationCode1.setOtp(OtpUtils.generateOtp());
           verificationCode1.setVerificationType(verificationType);
           verificationCode1.setUser(user);

        return null;
    }

    @Override
    public VerificationCode getVerificationCodeById(Long id) throws Exception {

        Optional<VerificationCode> verificationCode=
                verificationCodeRepository.findById(id);

        if (verificationCode.isPresent()){
            return  verificationCode.get();
        }

        throw new Exception("Verification   code Not Found");
    }

    @Override
    public VerificationCode getVerificationCodeByUser(Long userId) {

       return  verificationCodeRepository.findByUserId(userId);
    }

    @Override
    public void deleteVerificationCodeById(VerificationCode verificationCode) {

        verificationCodeRepository.delete(verificationCode);
    }
}
