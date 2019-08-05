package com.danasoft.teamroster.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.danasoft.teamroster.models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String)request.getParameter("name");
		Team team = new Team(name);
		ArrayList<Team> teams = (ArrayList<Team>)session.getAttribute("teams");
		teams.add(team);
		session.setAttribute("teams", teams);
		response.sendRedirect("/TeamRoster/Home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String)request.getParameter("name");
		if (name.length() < 2) {
			request.setAttribute("err","Team names must be at least 2 characters long..."); 
            RequestDispatcher view = request.getRequestDispatcher("teams.jsp");
            view.forward(request, response);
		} else {
			doGet(request, response);
		}
	}

}
