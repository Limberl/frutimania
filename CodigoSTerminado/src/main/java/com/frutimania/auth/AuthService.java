
package com.frutimania.auth;

/**
 *
 * @author José Castillo
 */
import com.frutimania.model.User;
import com.frutimania.persistence.Database;
import java.util.ArrayList;
import java.util.List;

public class AuthService {

    private final Database db;
    private List<User> users;

    public AuthService() {
        db = new Database();
        users = db.loadUsers();

        // Si no hay usuarios, crear uno por defecto
        if (users.isEmpty()) {
            User admin = new User("admin", "admin123", "admin");
            users.add(admin);
            db.saveUsers(users);
        }
    }

    /**
     * Verifica si el usuario y contraseña son correctos.
     */
    public User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) &&
                u.getPassword().equals(password)) {
                return u; // login correcto
            }
        }
        return null; // login fallido
    }

    /**
     * Permite agregar nuevos usuarios (opcional)
     */
    public void addUser(String username, String password, String role) {
        users.add(new User(username, password, role));
        db.saveUsers(users);
    }

    public List<User> getUsers() {
        return users;
    }
}
