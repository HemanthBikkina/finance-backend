package com.finanace.app.controller;

import com.finanace.app.model.FinancialRecord;
import com.finanace.app.service.FinancialRecordService;
import com.finanace.app.service.FinancialRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final FinancialRecordService service;

    public DashboardController(FinancialRecordService service) {
        this.service = service;
    }
    @GetMapping("/summary")
    public Map<String, Double> getSummary() {

        List<FinancialRecord> records = service.getAllRecords();

        double income =records.stream()
                .filter(r -> r.getType().equals("INCOME"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
        double expense =records.stream()
                .filter(r -> r.getType().equals("EXPENSE"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
        double balance = income - expense;

        return Map.of(
                "totalIncome", income,
                "totalExpense", expense,
                "netBalance", balance
        );
    }



}