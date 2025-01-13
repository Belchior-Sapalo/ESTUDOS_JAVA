package com.estudosjava.exercicios.Library_manager_app.service;

import com.estudosjava.exercicios.Library_manager_app.models.LoanModel;
import com.estudosjava.exercicios.Library_manager_app.repository.LoanRepository;

import java.sql.SQLException;
import java.util.List;

public class LoanService {
    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void addLoan(LoanModel loan) throws SQLException {
        loanRepository.addLoan(loan);
    }

    public List<LoanModel> getAllLoans() throws SQLException {
        return loanRepository.getAllLoans();
    }

    public LoanModel getLoan(int id) throws SQLException {
        return loanRepository.getLoan(id);
    }

    public List<LoanModel> getLoanByUser(int id) throws SQLException {
        return loanRepository.getLoanByUser(id);
    }

    public boolean returnLoan(int id) throws SQLException {
        return loanRepository.returnLoan(id);
    }
}
