package com.frutimania.models;

/**
 *
 * @author Joé Castillo
 */
import java.time.LocalDateTime;

public class Movimiento {
    private int id;
    private int productoId;
    private LocalDateTime fecha;
    private String tipo; // "entrada" o "salida"
    private int cantidad;
    private String observaciones;

    public Movimiento() {}

    public Movimiento(int id, int productoId, LocalDateTime fecha, String tipo, int cantidad, String observaciones) {
        this.id = id;
        this.productoId = productoId;
        this.fecha = fecha;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
    }

    // getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProductoId() { return productoId; }
    public void setProductoId(int productoId) { this.productoId = productoId; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
