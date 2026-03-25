package org.example.lendingserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "lendings")
public class Lending {
    @Id
    @Column(name = "lending_id", nullable = false, length = 10)
    private String lendingId;

    @Column(name = "reader_id", nullable = false)
    private String readerId;

    @Column(name = "book_id", nullable = false)
    private String bookId;

    @Column(name = "borrowed_date", nullable = false)
    private LocalDate borrowedDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "status", nullable = false)
    private String status; // BORROWED, RETURNED, OVERDUE

    public Lending() {
    }

    public Lending(String lendingId, String readerId, String bookId, LocalDate borrowedDate, LocalDate dueDate, LocalDate returnDate, String status) {
        this.lendingId = lendingId;
        this.readerId = readerId;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public String getLendingId() {
        return lendingId;
    }

    public void setLendingId(String lendingId) {
        this.lendingId = lendingId;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
