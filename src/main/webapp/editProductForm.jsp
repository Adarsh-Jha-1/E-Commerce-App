<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        text-align: center;
    }

    h1 {
        color: maroon;
    }

    form {
        margin: 20px auto;
        width: 50%;
        background-color: white;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
        display: block;
        margin-bottom: 10px;
        color: maroon;
    }

    input[type="text"] {
        width: calc(100% - 20px);
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }

    input[type="submit"] {
        padding: 10px 20px;
        background-color: maroon;
        color: white;
        border: none;
        border-radius: 3px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #800000;
    }
</style>
</head>
<body>

<h1>Edit Product Details</h1>

<form action="editProduct" method="post">
    <input type="hidden" name="productId" value="<%= request.getAttribute("productId") %>">
    
    <label for="brand">Brand:</label>
    <input type="text" id="brand" name="brand" value="<%= request.getAttribute("brand") %>" readonly><br>
    
    <label for="category">Category:</label>
    <input type="text" id="category" name="category" value="<%= request.getAttribute("category") %>" readonly><br>
    
    <label for="model">Model:</label>
    <input type="text" id="model" name="model" value="<%= request.getAttribute("model") %>" readonly><br>
    
    <label for="price">Price:</label>
    <input type="text" id="price" name="price" value="<%= request.getAttribute("price") %>"><br>
    
    <label for="stock">Stock:</label>
    <input type="text" id="stock" name="stock" value="<%= request.getAttribute("stock") %>"><br>
    
    <input type="submit" value="Update">
</form>

</body>
</html>
