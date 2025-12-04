
package com.frutimania.model;

/**
 *
 * @author José Castillo
 */
import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password; // (por ahora sin hash para que funcione fácil)
    private String role;     // admin / empleado

    public User() {}

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}