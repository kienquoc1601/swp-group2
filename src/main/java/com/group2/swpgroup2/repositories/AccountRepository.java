package com.group2.swpgroup2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.swpgroup2.models.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
    public Account findByUsername(String username);

}
