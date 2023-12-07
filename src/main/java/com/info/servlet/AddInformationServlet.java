package com.info.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.model.Information;
import com.info.service.*;


//@WebServlet("/AddInformationServlet")
public class AddInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AddInformationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Information information = new Information();
		
		information.setLocationID(request.getParameter("locationID"));
		information.setHeading(request.getParameter("heading"));
		information.setDescription(request.getParameter("description"));
		
		
		IInfoService iinfoService = new InfoServiceImpl();
		
		if(!information.getDescription().equals("") && !information.getLocationID().equals("") && information.getLocationID().contains("LOC-")) {
			iinfoService.addInformation(information);
		}
			
		request.setAttribute("information", information);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.html");
		dispatcher.forward(request, response);
	}

}
