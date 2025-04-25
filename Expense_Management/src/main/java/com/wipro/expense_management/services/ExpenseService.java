package com.wipro.expense_management.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.expense_management.dto.ExpenseDTO;
import com.wipro.expense_management.entity.Category;
import com.wipro.expense_management.entity.Expense;
import com.wipro.expense_management.entity.User;
import com.wipro.expense_management.exception.ResourceNotFoundException;
import com.wipro.expense_management.repository.CategoryRepository;
import com.wipro.expense_management.repository.ExpenseRepository;
import com.wipro.expense_management.repository.UserRepository;

@Service
public class ExpenseService {

 @Autowired
 private ExpenseRepository expenseRepository;

 @Autowired
 private UserRepository userRepository;

 @Autowired
 private CategoryRepository categoryRepository;

 public List<Expense> getAllExpenses() {
     return expenseRepository.findAll();
 }

 public Optional<Expense> getExpenseById(Long id) {
     return expenseRepository.findById(id);
 }

 public Expense createExpense(Expense expense) {
   return expenseRepository.save(expense);
 }

 public Expense updateExpense(Long id, Expense expense) {
	 Optional<Expense> expense1=expenseRepository.findById(id);
	 if(expense1.isPresent()) {
		 expense.setExpenseId(id);
		 expenseRepository.save(expense);
		 return expense;
	 }else {
		 throw new ResourceNotFoundException("Expense Not Found");
	 }
 }

 public void deleteExpense(Long id) {
     expenseRepository.deleteById(id);
 }

}
