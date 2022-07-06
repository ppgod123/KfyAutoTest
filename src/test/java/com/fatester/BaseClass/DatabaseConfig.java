package com.fatester.BaseClass;

public class DatabaseConfig {
    private String driver;
    private String ip;
    private Integer port;
    private String dbname;
    private String username;
    private String password;
    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public Integer getPort() {
        return port;
    }
    public void setPort(Integer port) {
        this.port = port;
    }
    public String getDbname() {
        return dbname;
    }
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }
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
        return "\nDriver: " + driver +"\nip:"+ ip +"\nport: "
                + port + "\ndbname: " + dbname
                + "\nusername: " + username
                + "\npassword: " + password + "\n";
    }
}
