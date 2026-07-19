package edu.infosys.FarmVerseApplication.repository;

//package edu.infosys.farmVerseApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.infosys.FarmVerseApplication.entity.Crop;

public interface CropRepository extends JpaRepository<Crop, String> {


    @Query(value = "SELECT MAX(CAST(SUBSTRING(cropId, 2) AS UNSIGNED)) FROM crop", nativeQuery = true)
    public Long getMaxCropId();

    @Query("Select a from Crop a where a.username=?1")
    public List<Crop> getCropsByUsername(String username);

}

