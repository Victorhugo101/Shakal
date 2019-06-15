package com.example.easypark.easyparkfinal.session;

import android.content.SharedPreferences;

public class SessionManager {

    private static SessionManager instance;
    private ISession session;
    private SharedPreferences sharedPreferences;

    public static SessionManager getInstance(){
        if(instance == null){
            instance = new SessionManager();
        }
        return instance;

    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public ISession getSession() {
        return session;
    }
    public void setSession(ISession session){
        this.session = session;
    }

    public ISession createSession(SharedPreferences shared){
        this.sharedPreferences =shared;
        session = new ISession() {
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
            public Long getId() {
                return sharedPreferences.getLong("id",0);
            }

            @Override
            public void saveId(Long id) {
                SharedPreferences.Editor ed = sharedPreferences.edit();
                ed.putLong("id", id);
                ed.commit();
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
                ed.remove("id");
                ed.commit();
            }
        };
        return session;
    }
}
