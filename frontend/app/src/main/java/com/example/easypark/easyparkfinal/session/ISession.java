package com.example.easypark.easyparkfinal.session;

public interface ISession {

    boolean isLoggedIn();

    void saveToken(String token);

    String getToken();

    void saveEmail(String email);

    String getEmail();

    Long getId();

    void saveId(Long id);

    void savePassword(String password);

    String getPassword();

    void invalidate();
}
