<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Product Details Portal</title>
</head>
<style>
    table#nat {
        width: 50%;
    }
</style>
</head>
<body>
<h1>Product Details Portal</h1>

<% 		String productname = request.getParameter("productname");
		String price = request.getParameter("price");
		String color = request.getParameter("color");
		String date = request.getParameter("date");
		String percent = request.getParameter("percent"); %>
<table id="nat">
    <tr>
        <td>Product Name</td>
        <td><%= productname %>
        </td>
    </tr>
    <tr>
        <td>Price</td>
        <td><%= price %>
        </td>
    </tr>
    <tr>
        <td>Color</td>
        <td><%= color %>
        </td>
    </tr>
    <tr>
        <td>Manufacturing Date</td>
        <td><%= date %>
        </td>
    </tr>
    <tr>
        <td>Discount Percentage</td>
        <td><%= percent %>
        </td>
    </tr>

</table>
	<p><a href="index.jsp">Return to menu</a></p>
</body>
</html>