package edu.infosys.FarmVerseApplication.service;

import edu.infosys.FarmVerseApplication.entity.Crop;
import edu.infosys.FarmVerseApplication.entity.Farm;
import edu.infosys.FarmVerseApplication.entity.FarmCropInputs;
import edu.infosys.FarmVerseApplication.repository.CropDao;
import edu.infosys.FarmVerseApplication.repository.CropDao;
import edu.infosys.FarmVerseApplication.repository.FarmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CropInputsService {

    @Autowired
    private CropDao cropDao;

    @Autowired
    private FarmUserService service;

    @Autowired
    private FarmDao farmDao;

    public FarmCropInputs setFarmCropInputData(String cropId) {
        Crop crop = cropDao.getCropById(cropId);
        Farm farm = farmDao.getFarmById(crop.getFarmId());
        return new FarmCropInputs(crop, farm.getSoil());
    }

    public CropInputs setCropInputData(FarmCropInputs farmCropInputs) {
        CropInputs cropInputs = new CropInputs(farmCropInputs);
        cropInputs.setAgroTools(1.0);
        return cropInputs;
    }
}