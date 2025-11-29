package com.frutimania.controllers;

/**
 *
 * @author José Castillo
 */

import com.frutimania.database.Conexion;
import com.frutimania.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {

    // Crear un nuevo producto
    public void crearProducto(Producto producto) throws SQLException {
        String sql = "INSERT INTO productos (nombre, categoria, stock, precio_compra, precio_venta) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getCategoria());
            stmt.setInt(3, producto.getStock());
            stmt.setDouble(4, producto.getPrecioCompra());
            stmt.setDouble(5, producto.getPrecioVenta());

            stmt.executeUpdate();
        }
    }

    // Obtener la lista de productos
    public List<Producto> obtenerProductos() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapProducto(rs));
            }
        }

        return lista;
    }

    // Actualizar producto
    public void actualizarProducto(Producto producto) throws SQLException {
        String sql = "UPDATE productos SET nombre=?, categoria=?, stock=?, precio_compra=?, precio_venta=? WHERE id=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getCategoria());
            stmt.setInt(3, producto.getStock());
            stmt.setDouble(4, producto.getPrecioCompra());
            stmt.setDouble(5, producto.getPrecioVenta());
            stmt.setInt(6, producto.getId());

            stmt.executeUpdate();
        }
    }

    // Eliminar producto
    public void eliminarProducto(int id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Convertir datos SQL → objeto Producto
    private Producto mapProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getInt("id"));
        p.setNombre(rs.getString("nombre"));
        p.setCategoria(rs.getString("categoria"));
        p.setStock(rs.getInt("stock"));
        p.setPrecioCompra(rs.getDouble("precio_compra"));
        p.setPrecioVenta(rs.getDouble("precio_venta"));
        return p;
    }
}

