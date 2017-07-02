package com.hellojd.jpetstore.domain.service.account;

import com.hellojd.jpetstore.domain.model.Account;

public interface AccountService {

    Account getAccount(String username);

    Account getAccount(String username, String password);

    void insertAccount(Account account);

    void updateAccount(Account account);

}
