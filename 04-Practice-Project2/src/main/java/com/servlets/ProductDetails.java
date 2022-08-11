package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String productname = request.getParameter("productname");
        String price = request.getParameter("price");
        String color = request.getParameter("color");
        String date = request.getParameter("date");
        String percent = request.getParameter("percent");
        if (productname.isEmpty() || price.isEmpty() || color.isEmpty() || date.isEmpty() || percent.isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            out.println("<font color=red>Please fill all the required fields</font>");
            rd.include(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        }
		
    }
}