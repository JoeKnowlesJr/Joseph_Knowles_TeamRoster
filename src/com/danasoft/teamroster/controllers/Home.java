package com.danasoft.teamroster.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Team> teamList = (ArrayList<Team>)session.getAttribute("teams");
		
		ArrayList<Team> teams = new ArrayList<Team>();
		
		if (teamList == null) {
			Team lions = new Team("Lions");
			Team tigers = new Team("Tigers");
			Team bears = new Team("Bears");
			Team ohmy = new Team("Ohmy");
			ArrayList<Player> players = new ArrayList<>();
			
			players.add(new Player("Jenny", "Smith", 31));
			players.add(new Player("Frank", "Wilson", 41));
			players.add(new Player("Mary", "Nelson", 51));
			players.add(new Player("Fritz", "Paulson", 21));
			players.add(new Player("Hank", "Nesbit", 38));
			lions.getPlayers().addAll(players);
			
			players.clear();
			
			players.add(new Player("Larry", "Porter", 52));
			players.add(new Player("Wilma", "Green", 72));
			players.add(new Player("Bud", "Good", 25));
			players.add(new Player("Grant", "Parsons", 47));
			players.add(new Player("Jeff", "Unger", 46));
			tigers.getPlayers().addAll(players);
			
			players.clear();
			
			players.add(new Player("Gilroy", "Peerbourne", 35));
			players.add(new Player("Sally", "Cranston", 72));
			players.add(new Player("Martha", "Kravitz", 42));
			players.add(new Player("Nefertiti", "Alonso", 19));
			players.add(new Player("Martin", "Owings", 45));
			bears.getPlayers().addAll(players);
			
			players.clear();
			
			players.add(new Player("Harley", "Pak", 32));
			players.add(new Player("Austin", "Brandback", 63));
			players.add(new Player("Penny", "Horscholt", 34));
			players.add(new Player("Winston", "Meyers", 45));
			players.add(new Player("Paul", "LePage", 67));
			ohmy.getPlayers().addAll(players);				
			
			teams.add(lions);
			teams.add(tigers);
			teams.add(bears);
			teams.add(ohmy);
		} else { 
			teams.addAll(teamList);
		}
		session.setAttribute("teams", teams);
		request.setAttribute("teams", teams);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/home.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
