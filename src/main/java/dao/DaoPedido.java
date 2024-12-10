package dao;


import model.Pedido;
import model.DetallePedido;

import java.sql.*;
import java.util.ArrayList;

import conexion.Conexion;

public class DaoPedido {

    public long insertarPedido(Pedido pedido) throws SQLException {
        String query = "INSERT INTO Pedido (idcliente, estado, fecha, direccion_envio) VALUES (?, ?, ?, ?)";
        long idPedido = -1;

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement stmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, pedido.getIdCliente());
            stmt.setString(2, pedido.getEstado());
            stmt.setDate(3, new java.sql.Date(pedido.getFecha().getTime()));
            stmt.setString(4, pedido.getDireccionEnvio());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    idPedido = rs.getLong(1);
                }
            }
        }
        return idPedido;
    }

    public void insertarDetallePedido(DetallePedido detallePedido) throws SQLException {
        String query = "INSERT INTO DetallePedido (idpedido, linea_detalle, idproducto, cantidad, precio_unitario, total_linea_detalle) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setLong(1, detallePedido.getIdPedido());
            stmt.setInt(2, detallePedido.getLineaDetalle());
            stmt.setLong(3, detallePedido.getIdProducto());
            stmt.setInt(4, detallePedido.getCantidad());
            stmt.setBigDecimal(5, detallePedido.getPrecioUnitario());
            stmt.setBigDecimal(6, detallePedido.getTotalLineaDetalle());

            stmt.executeUpdate();
        }
    }
}
