package edu.infosys.FarmVerseApplication.repository;

import java.util.List;

import edu.infosys.FarmVerseApplication.entity.Farm;

public interface FarmDao {

    void addFarm(Farm farm);

    Farm getFarmById(Long id);

    List<Farm> getFarmsByUsername(String username);

    void deleteFarmById(Long id);

    Long getMaxFarmId();
}