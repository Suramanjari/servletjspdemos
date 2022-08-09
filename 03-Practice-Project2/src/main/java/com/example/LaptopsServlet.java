package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LaptopShop")
public class LaptopsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LaptopsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
        try {
               SessionFactory factory = HibernateUtil.getSessionFactory();
               
               Session session = factory.openSession();
               // using HQL
               List<laptops> list = session.createQuery("from laptops", laptops.class).list();
               
               session.close();
               
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<b>Product Listing</b><br>");
                for(laptops p: list) {
                        out.println("ID: " + String.valueOf(p.getId()) + ", Name: " + p.getName() +
                                        ", Price: " + String.valueOf(p.getPrice()) + ", Color: " + p.getColor().toString() + "<br>");
                }
                
            out.println("</body></html>");
            
            
        } catch (Exception ex) {
                throw ex;
        }

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<b>Adding Laptop</b> " + request.getParameter("name") + "<br>");
        out.println("<a href='index.jsp'>Return to Main</a><br>");
        out.println("</body></html>");
        
        Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		double price = Double.parseDouble(request.getParameter("price"));
		String petPrice = String.format("%.0f", price);
		request.getSession(true);
		try {		
			LaptopShopDAO PetShopDAO = new LaptopShopDAO();
			PetShopDAO.addLaptop(name, color, petPrice);
			response.sendRedirect("Success");
		} catch(Exception e) {
			System.err.println("doPost");
			e.printStackTrace();
		}
        
	}
}