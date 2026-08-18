package edu.infosys.FarmVerseApplication.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.infosys.FarmVerseApplication.entity.CropInputs;
import edu.infosys.FarmVerseApplication.entity.Farm;

@Repository
@Service
public class CropInputsDaoImpl implements CropInputsDao {

    @Autowired
    private CropInputsRepository repository;

    @Override
    public void addCropInputs(CropInputs cropInputs) {
        repository.save(cropInputs);
    }

    @Override
    public CropInputs getCropInputsById(String cropId) {
        if (cropId == null) return null;
        return repository.findById(cropId).orElse(null);
    }

    @Override
    public void deleteCropInputsById(String cropId) {
        repository.deleteById(cropId);
    }

}