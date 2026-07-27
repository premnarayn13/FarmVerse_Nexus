package edu.infosys.FarmVerseApplication.repository;

/*public interface FarmRepository {
}
 */
//package edu.infosys.farmVerseApplication.dao;

import edu.infosys.FarmVerseApplication.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FarmRepository extends JpaRepository<Farm, Long> {

    @Query("Select max(farmId) from Farm")
    public Long getMaxFarmId();
    @Query("SELECT f FROM Farm f WHERE f.username = ?1")
    List<Farm> getFarmsByUsername(String username);
}