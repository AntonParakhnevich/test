package com.example.test.test.repository;

import com.example.test.test.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

  Integer countByPhone(String phone);
}
