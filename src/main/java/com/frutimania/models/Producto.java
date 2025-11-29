package com.frutimania.models;

/**
 *
 * @author José Castillo
 */
public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private int stock;
    private double precioCompra;
    private double precioVenta;

    public Producto() {}

    public Producto(int id, String nombre, String categoria, int stock, double precioCompra, double precioVenta) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public Producto(String nombre, String categoria, int stock, double precioCompra, double precioVenta) {
        this(0, nombre, categoria, stock, precioCompra, precioVenta);
    }

    // getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public double getPrecioCompra() { return precioCompra; }
    public void setPrecioCompra(double precioCompra) { this.precioCompra = precioCompra; }

    public double getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }

    @Override
    public String toString() {
        return String.format("Producto{id=%d, nombre='%s', categoria='%s', stock=%d, precioCompra=%.2f, precioVenta=%.2f}",
                id, nombre, categoria, stock, precioCompra, precioVenta);
    }
}
