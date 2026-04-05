package com.finanace.app.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@NotNull
@Positive
    private double amount;
@NotBlank
    private String type; // INCOME / EXPENSE
    @NotBlank
    private String category;
@NotNull
    private LocalDate date;

    private String notes;

    private Long userId;
}