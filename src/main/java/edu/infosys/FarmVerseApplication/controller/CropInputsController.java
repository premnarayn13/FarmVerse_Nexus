package edu.infosys.FarmVerseApplication.controller;

import edu.infosys.FarmVerseApplication.entity.CropInputs;
import edu.infosys.FarmVerseApplication.entity.FarmCropInputs;
import edu.infosys.FarmVerseApplication.entity.FarmCropReport;
import edu.infosys.FarmVerseApplication.repository.CropInputsDao;
import edu.infosys.FarmVerseApplication.service.CropInputsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmverse")
@CrossOrigin(origins = "http://localhost:3636", allowCredentials = "true")
public class CropInputsController {

    @Autowired
    private CropInputsDao cropInputsDao;

    @Autowired
    private CropInputsService service;

    @PostMapping("/crop-input")
    public void addCropInputs(@RequestBody FarmCropInputs farmCropInputs) {
        CropInputs cropInputs = service.setCropInputData(farmCropInputs);
        cropInputsDao.addCropInputs(cropInputs);
    }

    @GetMapping("/crop-input/{id}")
    public CropInputs getCropInputsById(@PathVariable String id) {

        return cropInputsDao.getCropInputsById(id);
    }

    @DeleteMapping("/crop-input/{id}")
    public void deleteCropInputsById(@PathVariable String id) {

        cropInputsDao.deleteCropInputsById(id);
    }

    @GetMapping("/crop-exp/{id}")
    public FarmCropReport expenseCalculation(@PathVariable String id) {
        return service.expenseCalculation(id);
    }

}
