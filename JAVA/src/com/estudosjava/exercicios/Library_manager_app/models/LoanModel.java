package com.estudosjava.exercicios.Library_manager_app.models;

import java.sql.Date;

public class LoanModel {
    private int id;
    private int userId;
    private int bookId;
    private Date loanDate;
    private Date returnDate;

    public LoanModel(int id, int userId, int bookId, Date loanDate, Date returnDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return String.format(
                "Loan: %s, %s: %s, %s: %s, %s: %s, %s: %s",
                this.getId(),
                "User",
                this.getUserId(),
                "Book",
                this.getBookId(),
                "Date", this.getLoanDate(),
                "ReturnDate", this.getReturnDate() == null ? "Was not returned" : this.getReturnDate().toString());
    }
}
