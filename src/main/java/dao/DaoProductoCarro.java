package dao;



import model.Producto;
import model.ProductoCarro;

import java.sql.SQLException;

public class DaoProductoCarro extends DaoProducto {

    // Método para convertir un Producto en un ProductoCarro con una cantidad específica
    public ProductoCarro convertirAProductoCarro(long idProducto, int cantidad) throws SQLException {
        ProductoCarro productoCarro = null;
        Producto producto = buscarPorId(idProducto);

        if (producto != null) {
            productoCarro = new ProductoCarro(producto, cantidad);
        }
        return productoCarro;
    }
}

