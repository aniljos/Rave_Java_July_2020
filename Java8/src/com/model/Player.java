package com.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = { "name", "role", "totalRuns", "totalWickets", "teamName", "debutDate" })
public class Player {

	private String name;
	private Role role;

	private int totalRuns;
	private short totalWickets;

	private Optional<String> teamName = Optional.empty(); // optional
	private LocalDate debutDate;

	public Player() {

	}

	public Player(String name, Role role, int totalRuns, short totalWickets, Optional<String> teamName,
			LocalDate debutDate) {
		super();
		this.name = name;
		this.role = role;
		this.totalRuns = totalRuns;
		this.totalWickets = totalWickets;
		this.teamName = teamName;
		this.debutDate = debutDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}

	public short getTotalWickets() {
		return totalWickets;
	}

	public void setTotalWickets(short totalWickets) {
		this.totalWickets = totalWickets;
	}

	public String getTeamName() {

		return teamName.orElse("");
	}

	public void setTeamName(String teamName) {
		if (teamName != null && !teamName.isEmpty()) {
			this.teamName = Optional.of(teamName);
		} else {
			this.teamName = Optional.empty();
		}
	}

//	public void setTeamName(Optional<String> teamName) {
//
//		this.teamName = teamName;
//	}

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDebutDate() {
		return debutDate;
	}

	public void setDebutDate(LocalDate debutDate) {
		this.debutDate = debutDate;
	}

	public void print() {

		System.out.println("--------------------------");
		System.out.println("Name: " + name);
		System.out.println("Role: " + role);
		System.out.println("Total Runs: " + totalRuns);
		System.out.println("Total Wickets: " + totalWickets);
		System.out.println("Team Name: " + teamName.orElse("No Team"));
		System.out.println("Debut Date: " + debutDate.format(DateTimeFormatter.ISO_DATE));
		System.out.println("**********************");
	}

}
