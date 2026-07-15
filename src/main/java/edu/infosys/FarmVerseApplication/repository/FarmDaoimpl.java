package edu.infosys.FarmVerseApplication.repository;

import edu.infosys.FarmVerseApplication.entity.Farm;

import java.util.List;

public class FarmDaoimpl implements FarmDao {
    @Override
    public void addFarm(Farm farm) {

    }

    @Override
    public Farm getFarmById(Long id) {
        return null;
    }

    @Override
    public List<Farm> getFarmsByUsername(String username) {
        return List.of();
    }

    @Override
    public void deleteFarmById(Long id) {

    }

    @Override
    public Long getMaxFarmId() {
        return 0L;
    }
}
