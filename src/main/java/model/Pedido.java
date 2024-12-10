package model;


import java.util.Date;

public class Pedido {
    private long idPedido;
    private long idCliente;
    private String estado;
    private Date fecha;
    private String direccionEnvio;

    // Constructores
    public Pedido() {}

    public Pedido(long idPedido, long idCliente, String estado, Date fecha, String direccionEnvio) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.estado = estado;
        this.fecha = fecha;
        this.direccionEnvio = direccionEnvio;
    }

    // Getters y Setters
    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }
}
