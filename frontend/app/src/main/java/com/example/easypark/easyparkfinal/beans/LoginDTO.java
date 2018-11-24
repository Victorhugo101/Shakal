package com.example.easypark.easyparkfinal.beans;

import java.io.Serializable;

public class LoginDTO  implements Serializable {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getSenha() {

        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String senha;

}
