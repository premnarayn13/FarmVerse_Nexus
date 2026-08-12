package edu.infosys.FarmVerseApplication.repository;

import edu.infosys.FarmVerseApplication.entity.CropInputs;

public interface CropInputsDao {
    public void addCropInputs(CropInputs cropInputs);
    public CropInputs getCropInputsById(String id);
    public void deleteCropInputsById(String id);
}
