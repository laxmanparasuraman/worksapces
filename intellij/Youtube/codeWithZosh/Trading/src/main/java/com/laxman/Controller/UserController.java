package com.laxman.Controller;

import com.laxman.domain.VerificationType;
import com.laxman.model.User;
import com.laxman.model.VerificationCode;
import com.laxman.service.EmailService;
import com.laxman.service.UserService;
import com.laxman.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

   @Autowired
    private VerificationCodeService verificationCodeService;

    @GetMapping("/api/users/profile")
    public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization" )String jwt){


        User user =userService.findUserProfileByJwt(jwt);

        return  new ResponseEntity<User>(user, HttpStatus.OK);

    }

    @PostMapping("/api/users/Verification/{verificationType}/send-otp")
    public ResponseEntity<String>  sendVerificationOtp(
            @RequestHeader("Authorization" )String jwt,
              @PathVariable VerificationType verificationType){

        User user =userService.findUserProfileByJwt(jwt);

        VerificationCode verificationCode =verificationCodeService.getVerificationCodeByUser(user.getId());

        if (verificationCode==null){
            verificationCode=verificationCodeService
                    .sendVerificationCode(user,verificationType);

        }

        if (verificationType.equals(VerificationType.EMAIL)){

            verificationCode=verificationCodeService
                    .sendVerificationCode(user,verificationType);
        }
        return  new ResponseEntity<>("Verfication otp sent Succesfuuly", HttpStatus.OK);


    }
@PatchMapping("/api/users/enable-two-factor/verify-otp/{otp}")
    public ResponseEntity<User> enableTwoFactorAuthentication(@RequestHeader("Authorization" )String jwt){


        User user =userService.findUserProfileByJwt(jwt);

        VerificationCode verificationCode=verificationCodeService.getVerificationCodeByUser(user.getId());
        String sendTo=verificationCode.getVerificationType().equals(VerificationType.EMAIL)?
                verificationCode.getEmail():verificationCode.getMobile();



        return  new ResponseEntity<User>(user, HttpStatus.OK);

    }



}
