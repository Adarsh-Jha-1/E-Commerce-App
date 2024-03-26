<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Products</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    h1 {
        color: maroon;
        text-align: center;
    }

    form {
        max-width: 400px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
    }

    input[type="text"],
    input[type="number"] {
        width: calc(100% - 30px); /* Adjusting width for better alignment */
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: maroon;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #800000;
    }
</style>
</head>
<body>
<h1> <%= session.getAttribute("MerchantId") %></h1>
<form action="addProduct" method="post">
    <label>Enter Brand : </label><input type="text" name="brand"><br> 
    <label>Enter Category : </label><input type="text" name="category"><br>
    <label>Enter Model : </label><input type="text" name="model"><br>
    <label>Enter Price : </label><input type="number" name="price"><br>
    <label>Enter Stock : </label><input type="number" name="stock"><br>
    <input type="submit" value="Add Product">
</form>
</body>
</html>
