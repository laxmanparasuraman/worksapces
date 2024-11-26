package com.laxman.repository;

import com.laxman.model.TwoFactorOTP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwoFactorOtpRepository extends JpaRepository <TwoFactorOTP,String> {

TwoFactorOTP findByUserId(Long userId);

}
