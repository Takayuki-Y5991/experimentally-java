package com.example.javautilslibrary.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NotNull
public class AuthRequest {

    @NotBlank
    @JsonProperty("accountName")
    private String accountName;
    @NotBlank
    @JsonProperty("password")
    private String password;

    public AuthRequest() {
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
