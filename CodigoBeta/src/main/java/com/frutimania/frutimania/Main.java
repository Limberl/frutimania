package com.frutimania;

/**
 *
 * @author José Castillo
 */
import com.frutimania.controllers.ProductoController;
import com.frutimania.controllers.ReportesController;
import com.frutimania.models.Producto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProductoController pc = new ProductoController();
        ReportesController rc = new ReportesController();

        try {
            // Crear un producto de ejemplo
            Producto p = new Producto();
            p.setNombre("Manzana");
            p.setCategoria("Fruta");
            p.setStock(10);
            p.setPrecioCompra(5.0);
            p.setPrecioVenta(8.0);

            pc.crearProducto(p);
            System.out.println("Producto creado correctamente");

            // Obtener lista de productos
            List<Producto> lista = pc.obtenerProductos();
            System.out.println("Productos registrados:");
            for (Producto prod : lista) {
                System.out.println(prod);
            }

            // Crear archivo de reporte (se guarda dentro de /frutimania/)
            rc.exportarReporteProductosTxt(lista, "reporte_productos.txt");
            System.out.println("Reporte generado en la carpeta del proyecto.");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
