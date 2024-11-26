package com.laxman.model;

import com.laxman.domain.VerificationType;
//import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;

public class TwoFactorAuth {
    private boolean isEnable =false;
    private VerificationType sendTo;

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public VerificationType getSendTo() {
        return sendTo;
    }

    public void setSendTo(VerificationType sendTo) {
        this.sendTo = sendTo;
    }
}
