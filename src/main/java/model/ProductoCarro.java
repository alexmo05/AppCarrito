package model;

public class ProductoCarro extends Producto {
    private int cantidad;

    // Constructores
    public ProductoCarro() {}

    public ProductoCarro(Producto producto, int cantidad) {
        super(producto.getId(), producto.getNombre(), producto.getPrecioNormal(), producto.getPrecioMinimo());
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
