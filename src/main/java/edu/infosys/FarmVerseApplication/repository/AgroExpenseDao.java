package edu.infosys.FarmVerseApplication.repository;

//public interface AgroExpenseDao {
//}
//package edu.infosys.farmVerseApplication.dao;

import java.util.List;

import edu.infosys.FarmVerseApplication.entity.AgroExpense;

public interface AgroExpenseDao {

    public void addAgroExpense(AgroExpense agroExpense);

    public AgroExpense getAgroExpenseById(Integer id);

    public List<AgroExpense> getAllAgroExpenses();

    public void deleteAgroExpenseById(Integer id);

    public Integer getMaxExpenseId();

}