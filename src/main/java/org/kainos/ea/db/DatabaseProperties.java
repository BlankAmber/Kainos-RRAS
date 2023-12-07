package org.kainos.ea.db;

public class DatabaseProperties {
    private String username;
    private String password;
    private String host;
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DatabaseProperties(
            String username,
            String password,
            String host,
            String name
    ) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.name = name;
    }

    public boolean isValid() {
        return this.username != null
                && this.password != null
                && this.host != null
                && this.name != null;
    }
}
