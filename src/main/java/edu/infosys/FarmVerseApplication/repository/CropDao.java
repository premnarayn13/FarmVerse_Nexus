package edu.infosys.FarmVerseApplication.repository;

import java.util.List;

import edu.infosys.FarmVerseApplication.entity.Crop;

public interface CropDao {

    void addCrop(Crop crop);

    Crop getCropById(String id);

    List<Crop> getCropsByUsername(String username);

    List<Crop> getCropsByFarmId(Long farmId);

    void deleteCropById(String id);

    Long getMaxCropId();
}