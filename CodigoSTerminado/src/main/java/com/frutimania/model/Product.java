
package com.frutimania.model;

/**
 *
 * @author José Castillo
 */
import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private double quantity;    // kilos o piezas
    private double cost;        // costo de compra
    private double marketPrice; // precio de mercado
    private String entryDate;

    public Product() {
    }

    public Product(String name, double quantity, double cost) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.marketPrice = 0.0;     // valor default
        this.entryDate = "";         // valor default
    }

    // === Constructor original (lo dejo igual) ===
    public Product(String name, double quantity, double cost, double marketPrice, String entryDate) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.marketPrice = marketPrice;
        this.entryDate = entryDate;
    }

    // ======== Getters y Setters =========

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return name;
    }
}
