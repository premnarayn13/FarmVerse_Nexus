package edu.infosys.FarmVerseApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.infosys.FarmVerseApplication.AiService.YeildPredictService;
import edu.infosys.FarmVerseApplication.AiService.ExpensePredictService;
import edu.infosys.FarmVerseApplication.entity.Crop;
import edu.infosys.FarmVerseApplication.entity.FarmCrop;
import edu.infosys.FarmVerseApplication.entity.FarmCropInputs;
import edu.infosys.FarmVerseApplication.repository.CropDao;
import edu.infosys.FarmVerseApplication.service.CropInputsService;
import edu.infosys.FarmVerseApplication.service.CropService;

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
//	@PostMapping("/yield")
//	public FarmCrop getExpectedYield(@RequestBody FarmCrop farmCrop) {
//	 // AI processes the crop, populates yield and comments, and returns it
//	 return yService.predictYield(farmCrop);
//	 }
    @PostMapping("/yield/{id}")
    public FarmCrop getExpectedYield(@PathVariable String id) {
        Crop crop=cropDao.getCropById(id);
        FarmCrop farmCrop1=cService.setFarmCrop(crop);
        FarmCrop farmCrop2=yService.predictYield(farmCrop1);
        crop.setYield(farmCrop2.getYield());
        cropDao.addCrop(crop);
        return farmCrop2;
    }
    @PostMapping("/predict")
    public FarmCropInputs getExpectedExpenses(@RequestBody FarmCropInputs cropInputs) {
        return eService.predictResourceExpenses(cropInputs);
    }
    @PostMapping("/predict/{id}")
    public FarmCropInputs getExpectedExpenses(@PathVariable String id) {
        FarmCropInputs farmCropInputs=iService.setFarmCropInputData(id);
        return eService.predictResourceExpenses(farmCropInputs);
    }
}