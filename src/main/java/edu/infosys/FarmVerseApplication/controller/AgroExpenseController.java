package edu.infosys.FarmVerseApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.infosys.FarmVerseApplication.entity.AgroExpense;
import edu.infosys.FarmVerseApplication.repository.AgroExpenseDao;
import edu.infosys.FarmVerseApplication.service.AgroExpenseService;

@RestController
@RequestMapping("/farmverse/")
@CrossOrigin(origins = "http://localhost:3636", allowCredentials = "true")
public class AgroExpenseController {

    @Autowired
    private AgroExpenseDao agroExpenseDao;

    @Autowired
    private AgroExpenseService service;

    @PostMapping("/agroexpense")
    public void addAgroExpense(@RequestBody AgroExpense agroExpense) {
        agroExpenseDao.addAgroExpense(agroExpense);
    }

    @PutMapping("/agroexpense")
    public void updateAgroExpense(@RequestBody AgroExpense agroExpense) {
        agroExpenseDao.addAgroExpense(agroExpense);
    }

    @GetMapping("/agroexpense/{id}")
    public AgroExpense getAgroExpenseById(@PathVariable Integer id) {
        return agroExpenseDao.getAgroExpenseById(id);
    }

    @GetMapping("/agroexpense")
    public List<AgroExpense> getAllAgroExpenses() {
        return agroExpenseDao.getAllAgroExpenses();
    }

    @DeleteMapping("/agroexpense/{id}")
    public void deleteAgroExpenseById(@PathVariable Integer id) {
        agroExpenseDao.deleteAgroExpenseById(id);
    }

    @GetMapping("/agroexpense-id")
    public Integer generateExpenseId() {
        return service.generateExpenseId();
    }

}