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
public class NotificationDTO {

	private Long notificationId;
    private Long userId;
    private String message;
    private LocalDate date;
    private String status;
}
