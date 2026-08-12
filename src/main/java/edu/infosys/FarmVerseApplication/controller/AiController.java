package edu.infosys.FarmVerseApplication.controller;

import edu.infosys.FarmVerseApplication.AiService.ExpensePredictService;
import edu.infosys.FarmVerseApplication.AiService.YeildPredictService;
import edu.infosys.FarmVerseApplication.entity.Crop;
import edu.infosys.FarmVerseApplication.entity.FarmCrop;

import edu.infosys.FarmVerseApplication.repository.CropDao;
import edu.infosys.FarmVerseApplication.service.CropInputsService;
import edu.infosys.FarmVerseApplication.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmverse")
@CrossOrigin(origins = "http://localhost:3636", allowCredentials = "true")
public class AiController {

    @Autowired
    private YeildPredictService yService;
    @Autowired
    private ExpensePredictService eService;
    @Autowired
    private CropService cService;
    @Autowired
    private CropDao cropDao;
    @Autowired
    private CropInputsService iService;


    @PostMapping("/yield/{id}")
    public FarmCrop getExpectedYield(@PathVariable String id) {

        Crop crop = cropDao.getCropById(id);

        FarmCrop farmCrop1 = cropService.setFarmCrop(crop);

        FarmCrop farmCrop2 = yeildPredictService.predictYield(farmCrop1);

        crop.setYield(farmCrop2.getYield());

        cropDao.addCrop(crop);

        return farmCrop2;
    }

    @PostMapping("/predict/{id}")
    public FarmCropInputs getExpectedExpenses(@PathVariable String id) {
        FarmCropInputs farmCropInputs=iService.setFarmCropInputData(id);
        return eService.predictResourceExpenses(farmCropInputs);
    }
}