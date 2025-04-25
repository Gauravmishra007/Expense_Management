package com.wipro.expense_management.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.expense_management.dto.ExpenseDTO;
import com.wipro.expense_management.entity.Expense;
import com.wipro.expense_management.entity.Notification;
import com.wipro.expense_management.services.ExpenseService;
import com.wipro.expense_management.services.NotificationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user/expenses")
public class ExpenseController {

 @Autowired
 private ExpenseService expenseService;
 
 @Autowired
 private NotificationService notificationService;

 @GetMapping
 public List<Expense> getAllExpenses() {
     return expenseService.getAllExpenses();
 }

 @GetMapping("/{id}")
 public ResponseEntity<Optional<Expense>> getExpenseById(@PathVariable Long id) {
     Optional<Expense> expense = expenseService.getExpenseById(id);
     return ResponseEntity.status(HttpStatus.OK).body(expense);
 }

 @PostMapping
 public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
     Expense createdExpense = expenseService.createExpense(expense);
  // Create a notification for adding an expense
     Notification notification = new Notification();
     notification.setMessage("Expense '" + createdExpense.getDescription() + "' added.");
     notification.setStatus("Unread");
     notification.setDate(LocalDate.now());
     notification.setUser(createdExpense.getUser());
     notificationService.createNotification(notification);
     return new ResponseEntity<>(createdExpense, HttpStatus.CREATED);
 }

 @PutMapping("/{id}")
 public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
     Expense updatedExpense = expenseService.updateExpense(id, expense);
  // Create a notification for adding an expense
     Notification notification = new Notification();
     notification.setMessage("Expense '" + updatedExpense.getDescription() + "' updated.");
     notification.setStatus("Unread");
     notification.setDate(LocalDate.now());
     notification.setUser(updatedExpense.getUser());
     notificationService.createNotification(notification);
     return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
     expenseService.deleteExpense(id);
  // Create a notification for adding an expense 
     Notification notification = new Notification();
     notification.setMessage("Expense with ID" + id + " Deleted.");
     notification.setStatus("Unread");
     notification.setDate(LocalDate.now());
//     notification.setUser();
     notificationService.createNotification(notification);
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 }
}

