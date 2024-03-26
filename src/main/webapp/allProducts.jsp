<%@ page import="com.ECommerce.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Products</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        text-align: center;
    }

    h2 {
        color: maroon;
    }

    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
    }

    th, td {
        padding: 10px;
        border: 1px solid #ccc;
    }

    th {
        background-color: maroon;
        color: white;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    a {
        text-decoration: none;
        padding: 5px 10px;
        border-radius: 3px;
        background-color: maroon;
        color: white;
    }

    a:hover {
        background-color: #800000;
    }
</style>
</head>
<body>
    <% List<Product> productList = (List<Product>) request.getAttribute("ProductList"); %>
    
    <h2>All Products</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Brand</th>
            <th>Category</th>
            <th>Model</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Action</th>
            <th>Edit</th>
        </tr>
        <% for (Product product : productList) { %>
            <tr>
                <td><%= product.getId() %></td>
                <td><%= product.getBrand() %></td>
                <td><%= product.getCategory() %></td>
                <td><%= product.getModel() %></td>
                <td><%= product.getPrice() %></td>
                <td><%= product.getStock() %></td>
                <td><a href="deleteProducts?id=<%=product.getId()%>">Delete</a></td>
                <td><a href="editProduct?id=<%=product.getId()%>">Edit</a></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
