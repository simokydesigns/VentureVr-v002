package com.vrvideo.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.vrvideo.data.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	Account findAccountByUserId(long userId);

}
