package com.laxman.Controller;

import com.laxman.config.JwtProvider;
import com.laxman.model.TwoFactorOTP;
import com.laxman.model.User;
import com.laxman.repository.UserRepository;
import com.laxman.response.AuthResponse;
import com.laxman.service.CustomUserDetailService;
import com.laxman.service.EmailService;
import com.laxman.service.TwoFactorOtpService;
import com.laxman.utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
   @Autowired
    private CustomUserDetailService customUserDetailService;

   @Autowired
    private TwoFactorOtpService twoFactorOtpService;
   @Autowired
   private EmailService emailService;
   @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register (@RequestBody User user) throws Exception {

        User isEmailExit=userRepository.findByEmail(user.getEmail());

         if (isEmailExit!=null) throw new Exception(" the give email is used by another Account ");

           User newUser =new User();
           newUser.setEmail(user.getEmail());
           newUser.setFullName(user.getFullName());
           newUser.setPassword(user.getPassword());

            User savedUser =userRepository.save(newUser);




           Authentication auth=new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()

        );
        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwt= JwtProvider.generateToken(auth);

        AuthResponse response =new AuthResponse();
        response.setJwt(jwt);
        response.setStatus(true);
        response.setMessage("registeration Sucessful");



        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> Login (@RequestBody User user) throws Exception {

    /*    User isEmailExit=userRepository.findByEmail(user.getEmail());

        if (isEmailExit!=null) throw new Exception(" the give email is used by another Account ");
*/
/*
        User newUser =new User();
        newUser.setEmail(user.getEmail());
        newUser.setFullName(user.getFullName());
        newUser.setPassword(user.getPassword());

        User savedUser =userRepository.save(newUser);
*/


  String UserName=user.getEmail();
  String password= user.getPassword();


        Authentication auth= authenticate(UserName,password);
        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwt= JwtProvider.generateToken(auth);

        User authUser = userRepository.findByEmail(UserName);

        if (user.getTwoFactorAuth().isEnable()){

            AuthResponse response =new AuthResponse();
            response.setMessage("Two factor Auth Is Enabled");
            response.setTwoFactorAuthEnabled(true);
            String otp = OtpUtils.generateOtp();

            TwoFactorOTP oldTwoFactorOtp= twoFactorOtpService.findByUser(authUser);

            if (oldTwoFactorOtp!=null){
                twoFactorOtpService.deleteTwoFactorOtp(oldTwoFactorOtp);

            }
            TwoFactorOTP  newTwoFactorOtp=twoFactorOtpService.CreateTwoFactoryOtp(
                    authUser,otp,jwt
            );
            emailService.sendVerificationOtpEmail(UserName,otp);
            response.setSession(newTwoFactorOtp.getId());
            return  new ResponseEntity<>(response,HttpStatus.CREATED);
        }

        AuthResponse response =new AuthResponse();
        response.setJwt(jwt);
        response.setStatus(true);
        response.setMessage("Login sucessful");



        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    private Authentication authenticate(String userName, String password) throws Exception {

        /*User isEmailExit=userRepository.findByEmail(user.getEmail());

        if (isEmailExit!=null) throw new Exception(" the give email is used by another Account ");
*/

        UserDetails userDetails=customUserDetailService.loadUserByUsername(userName);
        if (userDetails==null){
            throw new Exception("wrong userdetails username");
        //    throw  new BadCredentialsException("invalid Username");
        }
        if (!password.equals(userDetails.getPassword())) {
            throw new Exception("wrong userdetails password");
            //throw  new BadCredentialsException("invalid password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());

    }
    public  ResponseEntity<AuthResponse> verifySigningOtp(@PathVariable String otp,@RequestParam String id ) throws Exception {

       TwoFactorOTP  twoFactorOTP=twoFactorOtpService.findById(id);
       if (twoFactorOtpService.verifyTwoFactorOtp(twoFactorOTP,otp)){
           AuthResponse response=new AuthResponse();
           response.setMessage("Two factor authentication verified");
           response.setTwoFactorAuthEnabled(true);
           response.setJwt(twoFactorOTP.getJwt());
           return new ResponseEntity<>(response,HttpStatus.OK);


       }
       throw new Exception("invalid Otp");
    }
}
