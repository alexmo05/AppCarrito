package model;

import java.math.BigDecimal;

public class DetallePedido {
    private long idPedido;
    private int lineaDetalle;
    private long idProducto;
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal totalLineaDetalle;

    // Constructores
    public DetallePedido() {}

    public DetallePedido(long idPedido, int lineaDetalle, long idProducto, int cantidad, BigDecimal precioUnitario) {
        this.idPedido = idPedido;
        this.lineaDetalle = lineaDetalle;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.totalLineaDetalle = precioUnitario.multiply(new BigDecimal(cantidad));
    }

    // Getters y Setters
    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public int getLineaDetalle() {
        return lineaDetalle;
    }

    public void setLineaDetalle(int lineaDetalle) {
        this.lineaDetalle = lineaDetalle;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getTotalLineaDetalle() {
        return totalLineaDetalle;
    }

    public void setTotalLineaDetalle(BigDecimal totalLineaDetalle) {
        this.totalLineaDetalle = totalLineaDetalle;
    }
}
