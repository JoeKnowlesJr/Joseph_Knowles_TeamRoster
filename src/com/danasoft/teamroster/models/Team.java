package com.danasoft.teamroster.models;

import java.util.ArrayList;

public class Team implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String team_name;
	private ArrayList<Player> players;
	
	protected Team() {
		
	}
	public Team(String name) {
		this.team_name = name;
		this.players = new ArrayList<Player>();
	}
	
	public String getName() {
		return this.team_name;
	}
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	public void setName(String name) {
		this.team_name = name;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void printDetails() {
		System.out.println(this.getName());
		for (Player item : this.getPlayers()) {
			item.printDetails();
		}
	}
}
