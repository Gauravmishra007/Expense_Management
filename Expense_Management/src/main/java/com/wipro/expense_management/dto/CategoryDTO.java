package com.wipro.expense_management.dto;

import java.util.List;

import com.wipro.expense_management.entity.Expense;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	
	private Long categoryId;
    private String name;
    private String description;
    private List<Expense> expenses;
}
