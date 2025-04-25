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
public class ReportDTO {

	private Long reportId;
	private Long userId; // Mapping to user entity
    private String period;
    private Double totalAmount;
    private LocalDate generatedDate;
}
