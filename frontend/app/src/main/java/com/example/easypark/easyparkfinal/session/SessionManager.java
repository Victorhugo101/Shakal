package com.example.easypark.easyparkfinal.session;

import android.content.SharedPreferences;

public class SessionManager {

    private static SessionManager instance;
    private Session session;
    private SharedPreferences sharedPreferences;

    public static SessionManager getInstance(){
        return instance = (instance == null)? new SessionManager(): instance;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public Session getSession() {
        return session;
    }
    public void setSession(Session session){
        this.session = session;
    }

    public Session createSession(SharedPreferences shared){
        this.sharedPreferences =shared;
        session = new Session() {
            @Override
            public boolean isLoggedIn() {
                return sharedPreferences.contains("token");
            }

            @Override
            public void saveToken(String token) {
                SharedPreferences.Editor ed = sharedPreferences.edit();
                ed.putString("token", token);
                ed.commit();
            }

            @Override
            public String getToken() {
                return sharedPreferences.getString("token","DEFAULT");
            }

            @Override
            public void saveEmail(String email) {
                SharedPreferences.Editor ed = sharedPreferences.edit();
                ed.putString("email", email);
                ed.commit();
            }

            @Override
            public String getEmail() {
                return sharedPreferences.getString("email","DEFAULT");
            }

            @Override
            public void savePassword(String password) {
                SharedPreferences.Editor ed = sharedPreferences.edit();
                ed.putString("senha", password);
                ed.commit();
            }

            @Override
            public String getPassword() {
                return sharedPreferences.getString("senha","DEFAULT");
            }

            @Override
            public void invalidate() {
                SharedPreferences.Editor ed = sharedPreferences.edit();
                ed.remove("senha");
                ed.remove("email");
                ed.remove("token");
                ed.commit();
            }
        };
        return session;
    }
}
