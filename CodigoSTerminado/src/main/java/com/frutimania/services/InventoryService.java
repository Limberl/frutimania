
package com.frutimania.services;

/**
 *
 * @author José Castillo
 */
import com.frutimania.model.Product;
import com.frutimania.persistence.Database;
import java.util.ArrayList;
import java.util.List;

public class InventoryService {

    private final Database db;
    private List<Product> products;

    public InventoryService() {
        db = new Database();
        products = db.loadProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
        db.saveProducts(products);
    }

    // ---------------------------------------
    // NUEVO: Actualizar producto por nombre
    // ---------------------------------------
    public void updateProduct(String name, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equalsIgnoreCase(name)) {
                products.set(i, updatedProduct);
                db.saveProducts(products);
                return;
            }
        }
    }

    // ---------------------------------------
    // NUEVO: Eliminar producto por nombre
    // ---------------------------------------
    public void deleteProduct(String name) {
        products.removeIf(p -> p.getName().equalsIgnoreCase(name));
        db.saveProducts(products);
    }

    public void save() {
        db.saveProducts(products);
    }
}

