<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ProductoCarro" %>
<%@ page import="controller.CarroController" %>
<%
    CarroController carroController = (CarroController) session.getAttribute("carro");
    if (carroController == null) {
        carroController = new CarroController();
        session.setAttribute("carro", carroController);
    }
    ArrayList<ProductoCarro> productosCarro = carroController.getCarro();
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrito de Compra</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            color: #333;
        }
        header {
           
            text-align: center;
        }
        main {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #0078d7;
            color: white;
        }
        td a {
            text-decoration: none;
            color: #0078d7;
            margin: 0 5px;
            font-weight: bold;
        }
        td a:hover {
            text-decoration: underline;
            color: #005bb5;
        }
        .total {
            font-weight: bold;
            color: #0078d7;
        }
        button, a.formalizar-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            color: white;
            background-color: #0078d7;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            text-align: center;
            transition: background-color 0.3s ease;
        }
        button:hover, a.formalizar-btn:hover {
            background-color: #005bb5;
        }
    </style>
</head>
<body>
    <header>
    <img src="img/headerazarquiel.jpg" alt="">
        
    </header>
    <main>
        <h1>Resumen de tu Carrito</h1>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Cantidad</th>
                <th>Precio Unitario</th>
                <th>Total</th>
                <th>Acciones</th>
            </tr>
            <%
                for (ProductoCarro producto : productosCarro) {
            %>
            <tr>
                <td><%= producto.getNombre() %></td>
                <td><%= producto.getCantidad() %></td>
                <td><%= producto.getPrecioNormal() %></td>
                <td class="total"><%= producto.getPrecioNormal().multiply(new java.math.BigDecimal(producto.getCantidad())) %></td>
                <td>
                    <a href="incrementarCantidad?id=<%= producto.getId() %>"><img src="img/addCarro.png" alt=""></a>
                    <a href="disminuirCantidad?id=<%= producto.getId() %>"><img src="img/delCarro.png" alt=""></a>
                    <a href="eliminarProducto?id=<%= producto.getId() %>"><img src="img/remCarro.png" alt=""></a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
         <a href="productos.jsp" class="formalizar-btn">Lista de Productos</a>
        <a href="formalizarPedido.jsp" class="formalizar-btn">Formalizar Pedido</a>
    </main>
</body>
</html>
