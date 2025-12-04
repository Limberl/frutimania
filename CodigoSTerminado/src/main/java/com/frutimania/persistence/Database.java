
package com.frutimania.persistence;

/**
 *
 * @author José Castillo
 */
import com.frutimania.model.Product;
import com.frutimania.model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final String DIR = System.getProperty("user.home") + File.separator + ".frutimania";
    private static final String PRODUCTS_FILE = DIR + File.separator + "products.ser";
    private static final String USERS_FILE = DIR + File.separator + "users.ser";

    public Database() {
        File folder = new File(DIR);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // ---------------------
    //   Productos
    // ---------------------

    public void saveProducts(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCTS_FILE))) {
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> loadProducts() {
        File file = new File(PRODUCTS_FILE);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCTS_FILE))) {
            return (List<Product>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // ---------------------
    //   Usuarios
    // ---------------------

    public void saveUsers(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> loadUsers() {
        File file = new File(USERS_FILE);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            return (List<User>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
