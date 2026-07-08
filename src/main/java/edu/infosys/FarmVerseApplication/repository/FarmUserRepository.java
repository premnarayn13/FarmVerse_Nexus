package edu.infosys.FarmVerseApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.infosys.FarmVerseApplication.entity.FarmUser;
import java.util.List;

public interface FarmUserRepository extends JpaRepository<FarmUser, String > {

  /*  @Query("Select username from FarmUser where role=?1")
    public List<String> getUsersByRole(String role);*/
}