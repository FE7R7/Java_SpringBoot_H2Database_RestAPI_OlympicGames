package com.project.olympicGames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.olympicGames.dto.UserExploreOlympicGamesDataTable;

@Repository
public interface UserOlympicGamesRepository extends JpaRepository<UserExploreOlympicGamesDataTable, Long> {

}
