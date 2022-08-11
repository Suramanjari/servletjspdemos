<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Product Details Portal</title>
</head>
<style>
    div.ex {
        text-align: right
        width: 300px;
        padding: 10px;
        margin: 0px
    }
</style>
<body>
<h1>Product Details Portal</h1>
<div class="ex">
    <form action="ProductDetails" method="post">
        <table style="with: 50%">
            <tr>
                <td>Product Name</td>
                <td><input type="text" name="productname"/></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price"/></td>
            </tr>
            <tr>
                <td>Color</td>
                <td><input type="text" name="color"/></td>
            </tr>
            <tr>
                <td>Manufacturing Date</td>
                <td><input type="text" name="date"/></td>
            </tr>
            <tr>
                <td>Discount Percentage</td>
                <td><input type="text" name="percent"/></td>
            </tr>

        </table>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>