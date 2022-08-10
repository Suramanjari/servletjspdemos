package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productdetailsservlet")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	@Override
	public void init() throws ServletException {
		try {
			System.out.println("Inside Product Details init() method. DB Connection Created");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "12345");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		int productid = Integer.parseInt(req.getParameter("category_id"));

		try (Statement statement = connection.createStatement();) {
			String query = "(select * from mydb.laptop where category_id=" + productid + ")";

			ResultSet resultset = statement.executeQuery(query);
			PrintWriter out = res.getWriter();
			if (!resultset.isBeforeFirst()) {
				out.println("<h2>Invalid ProductID</h2>");
			} else {
				
				out.println("<table>");
			    out.println("<table border=3>");
				out.println("<tr>");
				out.println("<th><tr><td>category_id</td></tr></th>");
				out.println("<th><tr><td>name</td></tr></th>");
				out.println("<th><tr><td>price</td></tr></th>");
				out.println("</tr>");

				while (resultset.next()) {
					out.println("<tr>");
					out.println("<table>");
				    out.println("<table border=3>");
					out.println("<th><tr><td>" + resultset.getString(1) + "</td></tr></th>");
					out.println("<th><tr><td>" + resultset.getString(2) + "</td></tr></th>");
					out.println("<th><tr><td>" + resultset.getString(3) + "</td></tr></th>");
					out.println("</table>");
					out.println("</tr>");
				}
				out.println("</table>");

			}
			out.println("<p><a href=\"home.html\">Return to Home-Page</a></p>");
			out.println("<p><a href=\"index.html\">Return to ProductID</a></p>");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		try {
			System.out.println("Inside Product Details destroy() method.DB connection destroyed");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}