package com.laxman.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.laxman.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.Data;

import com.laxman.model.TwoFactorAuth;
@Data
@Entity
public class User {
      @Id
     @GeneratedValue(strategy = GenerationType.AUTO )
     private Long id;
     private  String fullName;
     private  String email;
     @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
     private  String  password;
     @Embedded
    private  TwoFactorAuth twoFactorAuth =new TwoFactorAuth();
     private USER_ROLE role =USER_ROLE.ROLE_CUSTOMER;

}

