<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Merchant Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: maroon;
            text-align: center;
        }

        #AddProduct,
        #ViewProduct {
            margin-top: 20px;
            text-align: center;
        }

        a {
            display: block;
            padding: 10px;
            background-color: maroon;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        a:hover {
            background-color: #800000;
        }
    </style>
</head>

<body>
    <%int id = (int) session.getAttribute("MerchantId"); %>
    <h1> <%= session.getAttribute("MerchantId") %></h1>
    
    <div class="container">
        <div id="addProduct">
            <a href="addproduct.jsp">Add a Product</a>
        </div>

        <div id="viewProduct">
            <a href="viewProduct">View Products</a>
        </div>
    </div>
</body>

</html>
