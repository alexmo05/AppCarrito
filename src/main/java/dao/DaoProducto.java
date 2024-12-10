package dao;

import model.Producto;

import java.sql.*;
import java.util.ArrayList;

import conexion.Conexion;

public class DaoProducto {
    public ArrayList<Producto> obtenerTodos() throws SQLException {
        String query = "SELECT id, nombre, precio_normal, precio_minimo FROM Producto";
        ArrayList<Producto> productos = new ArrayList<>();
        
        try (Connection conexion = Conexion.getConnection();
             PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getBigDecimal("precio_normal"),
                        rs.getBigDecimal("precio_minimo")
                );
                productos.add(producto);
            }
        }
        return productos;
    }

    public Producto buscarPorId(long id) throws SQLException {
        String query = "SELECT id, nombre, precio_normal, precio_minimo FROM Producto WHERE id = ?";
        Producto producto = null;

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto(
                            rs.getLong("id"),
                            rs.getString("nombre"),
                            rs.getBigDecimal("precio_normal"),
                            rs.getBigDecimal("precio_minimo")
                    );
                }
            }
        }
        return producto;
    }
}

