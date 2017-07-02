/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.hellojd.jpetstore.domain.service.account;

import javax.inject.Inject;

import com.hellojd.jpetstore.domain.model.Account;
import com.hellojd.jpetstore.domain.repository.account.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eduardo Macarron
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    /*
     * (non-Javadoc)
     * @see com.hellojd.jpetstore.domain.service.account.AccountService#getAccount(java.lang.String)
     */
    @Override
    public Account getAccount(String username) {
        return accountRepository.getAccountByUsername(username);
    }

    /*
     * (non-Javadoc)
     * @see com.hellojd.jpetstore.domain.service.account.AccountService#getAccount(java.lang.String, java.lang.String)
     */
    @Override
    public Account getAccount(String username, String password) {
        return accountRepository.getAccountByUsernameAndPassword(username,
                password);
    }

    /*
     * (non-Javadoc)
     * @see com.hellojd.jpetstore.domain.service.account.AccountService#insertAccount(com.hellojd.jpetstore.domain.model.Account)
     */
    @Override
    @Transactional
    public void insertAccount(Account account) {
        accountRepository.insertAccount(account);
        accountRepository.insertProfile(account);
        accountRepository.insertSignon(account);
    }

    /*
     * (non-Javadoc)
     * @see com.hellojd.jpetstore.domain.service.account.AccountService#updateAccount(com.hellojd.jpetstore.domain.model.Account)
     */
    @Override
    @Transactional
    public void updateAccount(Account account) {
        accountRepository.updateAccount(account);
        accountRepository.updateProfile(account);

        if (account.getPassword() != null && account.getPassword().length() > 0) {
            accountRepository.updateSignon(account);
        }
    }

}
