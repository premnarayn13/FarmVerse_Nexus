package edu.infosys.FarmVerseApplication.service;


import edu.infosys.FarmVerseApplication.entity.Farm;
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
        String username = service.getUserId();
        crop.setUsername(username);
        return crop;
    }


    public boolean validateCropArea(Crop crop) {

        Farm farm = FarmDao.getFarmById(crop.getFarmId());

        if (farm == null) {
            return false;
        }

        double usedArea = 0;

        for (Crop c : cropDao.getCropsByFarmId(crop.getFarmId())) {
            usedArea += c.getCropArea();
        }

        return (usedArea + crop.getCropArea()) <= farm.getArea();
    }

}

