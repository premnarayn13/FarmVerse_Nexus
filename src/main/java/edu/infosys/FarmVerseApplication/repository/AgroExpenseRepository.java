package edu.infosys.FarmVerseApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.infosys.FarmVerseApplication.entity.AgroExpense;

public interface AgroExpenseRepository extends JpaRepository<AgroExpense, Integer> {

    @Query("Select max(expenseId) from AgroExpense")
    public Integer getMaxExpenseId();

}
