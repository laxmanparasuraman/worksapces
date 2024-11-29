package com.laxman.repository;

import com.laxman.model.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface VerificationCodeRepository extends JpaRepository<VerificationCode,Long> {

    public VerificationCode findByUserId(Long userId);



}
