package com.wipro.expense_management.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

	private Long userId;
    private String name;
    private String email;
    private String password;
    private String role; // ADMIN or USER
    private List<ExpenseDTO> expenses;
//    private List<NotificationDTO> notifications;	
}
