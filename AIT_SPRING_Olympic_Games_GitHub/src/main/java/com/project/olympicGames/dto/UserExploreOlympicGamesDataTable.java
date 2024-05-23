package com.project.olympicGames.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "OLYMPIC_GAMES")
public class UserExploreOlympicGamesDataTable {

	// Class Attributes With Table Notations

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID")
	private Long id;

	@Column(name = "CITY")
	private String city;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "DATE")
	private String date;

	@Column(name = "MASCOT")
	private String mascot;

	@Column(name = "NUMBER_OF_ATHLETES")
	private Integer numberOfAthletes;

	@Column(name = "NUMBER_OF_COUNTRIES")
	private Integer numberOfCountries;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "YEAR")
	private Integer year;

	// Constructors (2)

	public UserExploreOlympicGamesDataTable(Long id, String city, String country, String date, String mascot, Integer numberOfAthletes, Integer numberOfCountries, String type, Integer year) {

		super();
		this.id = id;
		this.city = city;
		this.country = country;
		this.date = date;
		this.mascot = mascot;
		this.numberOfAthletes = numberOfAthletes;
		this.numberOfCountries = numberOfCountries;
		this.type = type;
		this.year = year;
	}

	public UserExploreOlympicGamesDataTable() {

		// super();

	}

	// Getter and Setter Methods

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getCity() {

		return city;
	}

	public void setCity(String city) {

		this.city = city;
	}

	public String getCountry() {

		return country;
	}

	public void setCountry(String country) {

		this.country = country;
	}

	public String getDate() {

		return date;
	}

	public void setDate(String date) {

		this.date = date;
	}

	public String getMascot() {

		return mascot;
	}

	public void setMascot(String mascot) {

		this.mascot = mascot;
	}

	public Integer getNumberOfAthletes() {

		return numberOfAthletes;
	}

	public void setNumberOfAthletes(Integer numberOfAthletes) {

		this.numberOfAthletes = numberOfAthletes;
	}

	public Integer getNumberOfCountries() {

		return numberOfCountries;
	}

	public void setNumberOfCountries(Integer numberOfCountries) {

		this.numberOfCountries = numberOfCountries;
	}

	public String getType() {

		return type;
	}

	public void setType(String type) {

		this.type = type;
	}

	public Integer getYear() {

		return year;
	}

	public void setYear(Integer year) {

		this.year = year;
	}

	// To String Method

	@Override
	public String toString() {

		return "UserExploreOlympicGamesDataTable [Id=" + id + ", city=" + city + ", country=" + country + ", date=" + date + ", mascot=" + mascot + ", numberOfAthletes=" + numberOfAthletes + ", numberOfCountries=" + numberOfCountries + ", type=" + type + ", year=" + year + "]";

	}

}