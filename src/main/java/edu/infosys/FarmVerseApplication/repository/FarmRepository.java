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
    @Query("Select username from Farm where username=?1")
    public List<Farm> getFarmsByUsername(String username);
}