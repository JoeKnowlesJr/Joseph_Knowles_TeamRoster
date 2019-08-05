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

import com.danasoft.teamroster.models.Player;
import com.danasoft.teamroster.models.Team;

/**
 * Servlet implementation class AddPlayer
 */
@WebServlet("/AddPlayer")
public class AddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlayer() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Team> teams = (ArrayList<Team>)session.getAttribute("teams");
		Team currentTeam = teams.get(id);
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		int age = Integer.parseInt(request.getParameter("age"));
		Player player = new Player(firstName, lastName, age);
		currentTeam.getPlayers().add(player);
		teams.set(id, currentTeam);
		session.setAttribute("teams", teams);
		response.sendRedirect("/TeamRoster/ShowRoster?id=" + id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		int age = Integer.parseInt(request.getParameter("age"));
		if (firstName.length() < 2 || lastName.length() < 2) {
			request.setAttribute("id", id);
			request.setAttribute("error","Names must be at least 2 characters!"); 
            RequestDispatcher view = request.getRequestDispatcher("players.jsp");
            view.forward(request, response);
		} else if (age < 18) {
			request.setAttribute("id", id);
			request.setAttribute("error","Only players 18 years, and up!"); 
            RequestDispatcher view = request.getRequestDispatcher("players.jsp");
            view.forward(request, response);
		} else {
			doGet(request, response);
		}
	}

}
