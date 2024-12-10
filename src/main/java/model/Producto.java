package model;

import java.math.BigDecimal;

public class Producto {
    private long id;
    private String nombre;
    private BigDecimal precioNormal;
    private BigDecimal precioMinimo;

    // Constructores
    public Producto() {}

    public Producto(long id, String nombre, BigDecimal precioNormal, BigDecimal precioMinimo) {
        this.id = id;
        this.nombre = nombre;
        this.precioNormal = precioNormal;
        this.precioMinimo = precioMinimo;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(BigDecimal precioNormal) {
        this.precioNormal = precioNormal;
    }

    public BigDecimal getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(BigDecimal precioMinimo) {
        this.precioMinimo = precioMinimo;
    }
}
