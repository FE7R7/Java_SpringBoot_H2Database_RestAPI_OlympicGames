package com.project.olympicGames.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.olympicGames.dto.UserExploreOlympicGamesDataTable;
import com.project.olympicGames.exception.ResourceNotFoundException;
import com.project.olympicGames.repository.UserOlympicGamesRepository;

@RestController
public class OlympicGamesController {

	// --------------------------------------------------------------------------------

	// This will create an instance of a UserOlympicGamesRepository

	@Autowired
	private UserOlympicGamesRepository userOlympicGamesRepository;

	// --------------------------------------------------------------------------------

	@GetMapping("/")
	public String index() {

		return "<h2>Olympic Games Application from Controller</h2><hr>";
	}

	// --------------------------------------------------------------------------------

	// Building of our entry path for the project

	@GetMapping("/UserExploreOlympicGamesDataTable")
	public List<UserExploreOlympicGamesDataTable> getUserExploreOlympicGamesDataTable() {

		return userOlympicGamesRepository.findAll(); // will return a list of all userOlympicGamesRepository in the DB

	}

	// --------------------------------------------------------------------------------

	// Building the entry path based on a Long id parameter being passed in the
	// request message

	@GetMapping("/UserExploreOlympicGamesDataTable/{id}")
	public ResponseEntity<UserExploreOlympicGamesDataTable> getUserExploreOlympicGamesDataTableById(@PathVariable(value = "id") Long Id) throws ResourceNotFoundException {

		Optional<UserExploreOlympicGamesDataTable> userExploreOlympicGamesDataTable = userOlympicGamesRepository.findById(Id);

		if (userExploreOlympicGamesDataTable.isPresent())

			return ResponseEntity.ok().body(userExploreOlympicGamesDataTable.get());

		else

			throw new ResourceNotFoundException("Olympic Games Data not found...");
	}

	// --------------------------------------------------------------------------------

	// Building of our entry path to add an Entity to the database

	@PostMapping("/UserExploreOlympicGamesDataTable")
	public UserExploreOlympicGamesDataTable createUserExploreOlympicGamesDataTable(@RequestBody UserExploreOlympicGamesDataTable userExploreOlympicGamesDataTable) {

		return userOlympicGamesRepository.save(userExploreOlympicGamesDataTable);
	}

	// --------------------------------------------------------------------------------

	// Building the entry path based on a Long id parameter being passed in the
	// request message

	@DeleteMapping("/UserExploreOlympicGamesDataTable/{id}")
	public void deleteUserExploreOlympicGamesDataTableById(@PathVariable(value = "id") Long userExploreOlympicGamesDataTable) {

		userOlympicGamesRepository.deleteById(userExploreOlympicGamesDataTable);

	}

	// --------------------------------------------------------------------------------

}
