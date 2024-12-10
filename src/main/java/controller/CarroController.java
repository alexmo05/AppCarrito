package controller;

import dao.DaoProducto;
import dao.DaoPedido;
import model.ProductoCarro;
import model.Pedido;
import model.DetallePedido;

import java.util.ArrayList;
import java.util.Date;

public class CarroController {
    private ArrayList<ProductoCarro> carro;

    // Constructor
    public CarroController() {
        this.carro = new ArrayList<>();
    }

    // Método para obtener el carrito
    public ArrayList<ProductoCarro> getCarro() {
        return carro;
    }

    // Método para limpiar el carrito
    public void limpiarCarro() {
        carro.clear();
    }

    // Método para agregar un producto al carrito
    public void agregarProducto(long idProducto, int cantidad) throws Exception {
        DaoProducto daoProducto = new DaoProducto();
        ProductoCarro producto = new ProductoCarro(daoProducto.buscarPorId(idProducto), cantidad);
       
        if (producto.getId() == 0) {
            throw new Exception("Producto con ID " + idProducto + " no encontrado.");
        }

        int index = carro.indexOf(producto);
        if (index == -1) {
            carro.add(producto);
        } else {
            ProductoCarro existente = carro.get(index);
            existente.setCantidad(existente.getCantidad() + cantidad);
        }
    }

    // Método para incrementar la cantidad de un producto en el carrito
    public void incrementarCantidad(long idProducto) {
        for (ProductoCarro producto : carro) {
            if (producto.getId() == idProducto) {
                producto.setCantidad(producto.getCantidad() + 1);
                return;
            }
        }
    }

    // Método para disminuir la cantidad de un producto en el carrito
    public void disminuirCantidad(long idProducto) {
        for (ProductoCarro producto : carro) {
            if (producto.getId() == idProducto) {
                if (producto.getCantidad() > 1) {
                    producto.setCantidad(producto.getCantidad() - 1);
                } else {
                    carro.remove(producto);
                }
                return;
            }
        }
    }

    // Método para eliminar un producto del carrito
    public void eliminarProducto(long idProducto) {
        carro.removeIf(producto -> producto.getId() == idProducto);
    }

    // Método para formalizar un pedido
    public void formalizarPedido(long idCliente, String direccionEnvio) throws Exception {
        if (carro.isEmpty()) {
            throw new Exception("El carrito está vacío. No se puede formalizar el pedido.");
        }

        if (direccionEnvio == null || direccionEnvio.isEmpty()) {
            throw new Exception("La dirección de envío no puede estar vacía.");
        }

        DaoPedido daoPedido = new DaoPedido();

        // Crear un pedido
        Pedido pedido = new Pedido(0, idCliente, "PENDIENTE", new Date(), direccionEnvio);
        long idPedido = daoPedido.insertarPedido(pedido);

        // Crear los detalles del pedido
        int linea = 1;
        for (ProductoCarro producto : carro) {
            DetallePedido detalle = new DetallePedido(
                    idPedido,
                    linea++,
                    producto.getId(),
                    producto.getCantidad(),
                    producto.getPrecioNormal()
            );
            daoPedido.insertarDetallePedido(detalle);
        }

        // Limpiar el carrito después de procesar el pedido
        limpiarCarro();
    }
}

