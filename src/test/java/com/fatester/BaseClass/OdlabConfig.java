package com.fatester.BaseClass;

public class OdlabConfig {
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "\nusername: " + username
                + "\npassword: " + password + "\n";
    }

}
