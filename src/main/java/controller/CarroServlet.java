package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class CarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        CarroController carro = (CarroController) request.getSession().getAttribute("carro");

        if (carro == null) {
            carro = new CarroController();
            request.getSession().setAttribute("carro", carro);
        }

        try {
            switch (action) {
                case "/agregarProducto":
                    long id = Long.parseLong(request.getParameter("id"));
                    carro.agregarProducto(id, 1); // Si es necesario, puedes personalizar la cantidad
                    response.sendRedirect("productos.jsp"); // Redirige al listado de productos o a una página específica
                    break;
                case "/incrementarCantidad":
                    carro.incrementarCantidad(Long.parseLong(request.getParameter("id")));
                    response.sendRedirect("carrito.jsp");
                    break;
                case "/disminuirCantidad":
                    carro.disminuirCantidad(Long.parseLong(request.getParameter("id")));
                    response.sendRedirect("carrito.jsp");
                    break;
                case "/eliminarProducto":
                    carro.eliminarProducto(Long.parseLong(request.getParameter("id")));
                    response.sendRedirect("carrito.jsp");
                    break;
                default:
                    response.sendRedirect("productos.jsp");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Considera pasar un mensaje de error en la redirección
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        if ("/formalizarPedido".equals(action)) {
            try {
                CarroController carro = (CarroController) request.getSession().getAttribute("carro");
                long idCliente = Long.parseLong(request.getParameter("idCliente"));
                String direccion = request.getParameter("direccionEnvio");
                carro.formalizarPedido(idCliente, direccion);
                response.sendRedirect("productos.jsp");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        }
    }
}

