package com.info.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.model.Information;
import com.info.service.IInfoService;
import com.info.service.InfoServiceImpl;


//@WebServlet("/UpdateInformationServlet")
public class UpdateInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		Information information = new Information();
		
		String infoID = request.getParameter("infoID");
		
		information.setInfoID(infoID);
		information.setLocationID(request.getParameter("locationID"));
		information.setHeading(request.getParameter("heading"));
		information.setDescription(request.getParameter("description"));
		
		
		IInfoService iinfoService = new InfoServiceImpl();
		
		if(!information.getDescription().equals("") && !information.getLocationID().equals("") && information.getLocationID().contains("LOC-")) {
			iinfoService.updateInformation(infoID, information);
		}
		
		
		request.setAttribute("information", information);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.html");
		dispatcher.forward(request, response);
	}

}
