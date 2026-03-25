package org.example.lendingserver.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;


public class LendingRequestDTO {
    public interface OnCreate {}

    @NotBlank(groups = OnCreate.class, message = "Lending ID is required")
    private String lendingId;

    @NotBlank(message = "Reader ID is required")
    private String readerId;

    @NotBlank(message = "Book ID is required")
    private String bookId;

    @NotNull(message = "Borrowed date is required")
    private LocalDate borrowedDate;

    @NotNull(message = "Due date is required")
    private LocalDate dueDate;

    private LocalDate returnDate;

    @NotBlank(message = "Status is required")
    private String status;


    public String getLendingId() { return lendingId; }
    public void setLendingId(String lendingId) { this.lendingId = lendingId; }
    public String getReaderId() { return readerId; }
    public void setReaderId(String readerId) { this.readerId = readerId; }
    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }
    public LocalDate getBorrowedDate() { return borrowedDate; }
    public void setBorrowedDate(LocalDate borrowedDate) { this.borrowedDate = borrowedDate; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
