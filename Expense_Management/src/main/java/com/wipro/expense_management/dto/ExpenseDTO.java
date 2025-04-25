package com.wipro.expense_management.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDTO {

	private Long expenseId;
    private Long userId;
    private Long categoryId;
    private double amount;
    private LocalDate date;
    private String description;
}
