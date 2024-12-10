<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Producto" %>
<%@ page import="dao.DaoProducto" %>
<%
    DaoProducto daoProducto = new DaoProducto();
    ArrayList<Producto> productos = daoProducto.obtenerTodos();
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Productos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            color: #333;
        }
        header {
          
            color: white;
          
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
            color: black ;
            
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
            font-weight: bold;
        }
        td a:hover {
            text-decoration: underline;
            color: #005bb5;
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
        footer {
            text-align: center;
            padding: 20px;
            background-color: #0078d7;
            color: white;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <header>
    <img src="img/headerazarquiel.jpg" alt="">
        <h1>BIENVENIDO A LA PAGINA DE COMPRA</h1>
    </header>
    <main>
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Acciones</th>
            </tr>
            <%
                for (Producto producto : productos) {
            %>
            <tr>
                <td><%= producto.getId() %></td>
                <td><%= producto.getNombre() %></td>
                <td>€<%= producto.getPrecioNormal() %></td>
                <td>
                   <a href="agregarProducto?id=<%= producto.getId() %>"><img src="img/tobasket_button.gif" alt=""></a> 	
                </td>
            </tr>
            <%
                }
            %>
             
        </table>
        <a href="carrito.jsp" class="formalizar-btn">Carrito de Compras</a>
    </main>
    <footer>
   
        <p>© Alex Muñoz</p>
    </footer>
</body>
</html>
