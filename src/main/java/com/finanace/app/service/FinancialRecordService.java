package com.finanace.app.service;
import com.finanace.app.model.FinancialRecord;
import com.finanace.app.repository.FinancialRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialRecordService {

    private final FinancialRecordRepository repository;

    public FinancialRecordService(FinancialRecordRepository repository) {
        this.repository = repository;
    }

    public FinancialRecord createRecord(FinancialRecord record) {
        return repository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return repository.findAll();
    }

    public FinancialRecord updateRecord(Long id, FinancialRecord updated) {
        FinancialRecord record = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setAmount(updated.getAmount());
        record.setType(updated.getType());
        record.setCategory(updated.getCategory());
        record.setDate(updated.getDate());
        record.setNotes(updated.getNotes());

        return repository.save(record);
    }

    public List<FinancialRecord> getFiltered(String type, String category) {
        if (type != null) return repository.findByType(type);
        if (category != null) return repository.findByCategory(category);
        return repository.findAll();
    }
    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
}