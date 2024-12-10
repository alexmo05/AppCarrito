<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formalizar Pedido</title>
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
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        main h1 {
            text-align: center;
            color: black;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-top: 10px;
            font-weight: bold;
        }
        input {
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            margin-top: 20px;
            padding: 10px;
            background-color: #0078d7;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #005bb5;
        }
        footer {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <header>
    
    <img src="img/headerazarquiel.jpg" alt="">
        
    
        <h1>Formalizar Pedido</h1>
    </header>
    <main>
        <form action="formalizarPedido" method="post">
            <label for="idCliente">ID Cliente:</label>
            <input type="text" name="idCliente" id="idCliente" required 
                   pattern="\d+" title="Por favor, introduce solo números.">
            <label for="direccionEnvio">Dirección de Envío:</label>
            <input type="text" name="direccionEnvio" id="direccionEnvio" required 
                   placeholder="Calle, Ciudad, Código Postal">
            <button type="submit">Confirmar Pedido</button>
        </form>
    </main>
    <footer>
        <p>© 2024 Alex Muñoz</p>
    </footer>
</body>
</html>
