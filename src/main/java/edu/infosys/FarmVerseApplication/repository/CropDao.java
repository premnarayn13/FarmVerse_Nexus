package edu.infosys.FarmVerseApplication.repository;

import java.util.List;

import edu.infosys.FarmVerseApplication.entity.Crop;

public interface CropDao {

    public void addCrop(Crop crop);
    public Crop getCropById(String id);
    public List<Crop> getCropsByUsername(String username);
    public void deleteCropById(String id);
    public Long getMaxCropId();
}
