<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Options</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            text-align: center; /* Center aligning the content */
        }

        #Customer_login,
        #Merchant_login {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: inline-block; /* Displaying login options side by side */
            margin-bottom: 20px; /* Adding some space between login options */
        }

        #Customer_login a,
        #Merchant_login a {
            display: block;
            padding: 10px;
            background-color: maroon;
            color: #fff;
            text-decoration: none; /* Removing default underline */
            border-radius: 5px;
            transition: background-color 0.3s ease; /* Smooth transition on hover */
        }

        #Customer_login a:hover,
        #Merchant_login a:hover {
            background-color: #800000;
        }
    </style>
    <link rel="icon" href="shopping-cart5929.jpg">
</head>

<body>
    <div id="Customer_login">
        <a href="addCustomer">Login As a Customer</a>
    </div>

    <div id="Merchant_login">
        <a href="MerchantLogin.jsp">Login as a Merchant</a>
    </div>

</body>

</html>
