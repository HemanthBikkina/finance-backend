package com.finanace.app.controller;

import jakarta.validation.Valid;
import com.finanace.app.model.FinancialRecord;
import com.finanace.app.service.FinancialRecordService;
import com.finanace.app.model.Role;
import com.finanace.app.security.RoleChecker;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    private final FinancialRecordService service;

    public FinancialRecordController(FinancialRecordService service) {
        this.service = service;
    }

    @PostMapping
    public FinancialRecord create(@Valid @RequestBody FinancialRecord record,
                                  @RequestHeader Role role) {
        RoleChecker.checkAdmin(role);
        return service.createRecord(record);
    }

    @GetMapping
    public List<FinancialRecord> getAll(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category,
            @RequestHeader Role role) {

        RoleChecker.checkViewerOrAnalyst(role);
        return service.getFiltered(type, category);
    }

    @PutMapping("/{id}")
    public FinancialRecord update(@PathVariable Long id,
                                  @RequestBody FinancialRecord record,
                                  @RequestHeader Role role) {
        RoleChecker.checkAdmin(role);
        return service.updateRecord(id, record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id,
                       @RequestHeader Role role) {
        RoleChecker.checkAdmin(role);
        service.deleteRecord(id);
    }
}