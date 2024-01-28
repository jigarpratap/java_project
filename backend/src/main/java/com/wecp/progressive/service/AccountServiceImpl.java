package com.wecp.progressive.service;


//import com.wecp.progressive.dao.AccountDAO;
import com.wecp.progressive.entity.Accounts;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class AccountServiceImpl implements AccountService {
    //private AccountDAO accountDAO;

    private static List<Accounts> accountsList = new ArrayList<>();
    

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        return accountsList;
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
          for(Accounts a: accountsList){
                    if(a.getAccountId()==accountId){
                        return a;
                    }
          }
          return null;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
          if(accounts.getAccountId()!=0 || accounts.getCustomerId()!=0){
            accountsList.add(accounts);
             return accounts.getAccountId();
          }
          return 0;
    }

    @Override
    public void updateAccount(Accounts accounts) throws SQLException {
          for(Accounts a:accountsList){
            if(a.getAccountId()==accounts.getAccountId()){
                a.setAccountId(accounts.getAccountId());
                a.setCustomerId(accounts.getCustomerId());
                a.setBalance(accounts.getBalance());
            }
          }
    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {
          for(Accounts a:accountsList){
             if(a.getAccountId()==accountId){
                accountsList.remove(a);
                break;
             }
          }
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        List<Accounts> sortedAccounts = accountsList;
        if (sortedAccounts != null) {
            sortedAccounts.sort(Comparator.comparingDouble(Accounts::getBalance)); // Sort by account balance
        }
        return sortedAccounts;
    }


    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException{
           return accountsList;
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalanceFromArrayList() {
        List<Accounts> sortedAccounts = accountsList;
        sortedAccounts.sort(Comparator.comparingDouble(Accounts::getBalance)); // Sort by account balance
        return sortedAccounts;
    }

    @Override
    public void emptyArrayList() {
        accountsList = new ArrayList<>();
    }

    @Override
    public List<Accounts> getAllAccountsFromArrayList() {
        return accountsList;
    }
    @Override
    public List<Accounts> addAccountToArrayList(Accounts accounts) {
        accountsList.add(accounts);
        return accountsList;
    }
}