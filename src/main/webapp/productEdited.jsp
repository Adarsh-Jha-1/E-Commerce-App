<!DOCTYPE html>
<%@page import="com.ECommerce.entity.Product"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Edited</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        text-align: center;
    }

    .container {
        max-width: 800px;
        margin: 50px auto;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        padding: 30px;
    }

    h1 {
        color: #B22222;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: maroon;
        color: white;
    }

    strong {
        color: #B22222;
    }

    a.button {
        text-decoration: none;
        display: inline-block;
        padding: 10px 20px;
        border-radius: 5px;
        background-color: #B22222;
        color: #fff;
        transition: background-color 0.3s ease;
    }

    a.button:hover {
        background-color: #800000;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Product Details Updated</h1>
        <table>
            <tr>
                <th>Attribute</th>
                <th>Value</th>
            </tr>
            <tr>
                <td><strong>Brand:</strong></td>
                <td><%= ((Product) request.getAttribute("updatedProduct")).getBrand() %></td>
            </tr>
            <tr>
                <td><strong>Category:</strong></td>
                <td><%= ((Product) request.getAttribute("updatedProduct")).getCategory() %></td>
            </tr>
            <tr>
                <td><strong>Model:</strong></td>
                <td><%= ((Product) request.getAttribute("updatedProduct")).getModel() %></td>
            </tr>
            <tr>
                <td><strong>Price:</strong></td>
                <td><%= ((Product) request.getAttribute("updatedProduct")).getPrice() %></td>
            </tr>
            <tr>
                <td><strong>Stock:</strong></td>
                <td><%= ((Product) request.getAttribute("updatedProduct")).getStock() %></td>
            </tr>
        </table>

        <div>
            <a href="viewProduct" class="button">View All Products</a>
        </div>
    </div>
</body>
</html>
