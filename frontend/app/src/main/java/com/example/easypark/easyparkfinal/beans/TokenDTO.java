package com.example.easypark.easyparkfinal.beans;

public class TokenDTO {

    private long id;
    private String email;
    private String token;

    public TokenDTO(long id, String email,String token){
        this.id = id;
        this.email = email;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
