package edu.infosys.FarmVerseApplication.service;


import edu.infosys.FarmVerseApplication.entity.Farm;
import edu.infosys.FarmVerseApplication.entity.FarmCrop;
import edu.infosys.FarmVerseApplication.repository.FarmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infosys.FarmVerseApplication.entity.Crop;
import edu.infosys.FarmVerseApplication.repository.CropDao;

@Service
public class CropService {

    @Autowired
    private CropDao cropDao;

    @Autowired
    private FarmUserService service;

    @Autowired
    private FarmDao farmDao;

    public String generateCropId() {
        Long value = cropDao.getMaxCropId();

        if (value == null)
            value = 1000001L;
        else
            value = value + 1;

        String newId = "C"+value;

        return newId;
    }

    public Crop setUsername(Crop crop) {
        String username = service.getCurrentUserId();
        crop.setUsername(username);
        return crop;
    }


    public boolean validateCropArea(Crop crop) {

        Farm farm = farmDao.getFarmById(crop.getFarmId());

        if (farm == null) {
            return false;
        }

        double usedArea = 0;

        for (Crop c : cropDao.getCropsByFarmId(crop.getFarmId())) {
            usedArea += c.getCropArea();
        }

        return (usedArea + crop.getCropArea()) <= farm.getArea();
    }

    public FarmCrop setFarmCrop(Crop crop) {

        Farm farm = farmDao.getFarmById(crop.getFarmId());

        FarmCrop farmCrop = new FarmCrop();

        // Farm Details
        farmCrop.setFarmId(farm.getFarmId());
        farmCrop.setFarmName(farm.getFarmName());
        farmCrop.setArea(farm.getArea());
        farmCrop.setSoil(farm.getSoil());

        // Crop Details
        farmCrop.setCropId(crop.getCropId());
        farmCrop.setCropName(crop.getCropName());
        farmCrop.setCropArea(crop.getCropArea());
        farmCrop.setSownMonthYear(crop.getSownMonthYear());
        farmCrop.setHarvestMonthYear(crop.getHarvestMonthYear());

        return farmCrop;
    }
}

