package com.wecp.progressive.service;


import com.wecp.progressive.dao.AccountDAO;
import com.wecp.progressive.entity.Accounts;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private static List<Accounts> list = new ArrayList<>();
    private AccountDAO a;

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.a = accountDAO;
    }
    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        return null;
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        return null;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        return -1;
    }

    @Override
    public void updateAccount(Accounts accounts) throws SQLException {

    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {

    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        return null;
    }


    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException{
        return null;
    }
    @Override
    public List<Accounts> getAllAccountsSortedByBalanceFromArrayList() {
        List<Accounts>sortedAccounts=list;
        sortedAccounts.sort(Comparator.comparingDouble(Accounts::getBalance));
        return sortedAccounts;
    }

    @Override
    public void emptyArrayList() {
        list=new ArrayList<>();
    }

    @Override
    public List<Accounts> getAllAccountsFromArrayList() {
        return list;
    }
    
    @Override
    public List<Accounts> addAccountToArrayList(Accounts acc) {
        list.add(acc);
        return list;
    }
}