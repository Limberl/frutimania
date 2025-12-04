package com.frutimania.database;

/**
 *
 * @author José Castillo
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String DB_URL = "jdbc:sqlite:frutimania.db";

    // Siempre devuelve una nueva conexión para evitar "database connection closed"
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
