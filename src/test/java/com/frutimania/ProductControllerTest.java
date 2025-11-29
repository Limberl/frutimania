package com.frutimania;

/**
 *
 * @author José Castillo
 */
import com.frutimania.controllers.ProductoController;
import com.frutimania.models.Producto;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest {

    private static final ProductoController pc = new ProductoController();
    private static int idCreado;

    @Test
    @Order(1)
    public void testCrearProducto() throws SQLException {
        Producto p = new Producto();
        p.setNombre("Prueba");
        p.setCategoria("Test");
        p.setStock(5);
        p.setPrecioCompra(10.0);
        p.setPrecioVenta(15.0);

        pc.crearProducto(p);

        List<Producto> lista = pc.obtenerProductos();
        Assertions.assertFalse(lista.isEmpty());

        idCreado = lista.get(lista.size() - 1).getId();
        Assertions.assertTrue(idCreado > 0);
    }

    @Test
    @Order(2)
    public void testActualizarProducto() throws SQLException {
        List<Producto> lista = pc.obtenerProductos();
        Assertions.assertFalse(lista.isEmpty());

        Producto p = lista.get(0);
        int oldStock = p.getStock();

        p.setStock(oldStock + 1);
        pc.actualizarProducto(p);

        List<Producto> lista2 = pc.obtenerProductos();
        Producto actualizado = lista2.stream()
                .filter(x -> x.getId() == p.getId())
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(actualizado);
        Assertions.assertEquals(oldStock + 1, actualizado.getStock());
    }

    @Test
    @Order(3)
    public void testEliminarProducto() throws SQLException {
        pc.eliminarProducto(idCreado);

        List<Producto> lista = pc.obtenerProductos();
        boolean sigueExistiendo = lista.stream().anyMatch(p -> p.getId() == idCreado);

        Assertions.assertFalse(sigueExistiendo);
    }
}
