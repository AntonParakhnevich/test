package com.example.test.test.validator;

import com.example.test.test.model.UserAccount;
import com.example.test.test.repository.UserAccountRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ExistUserAccountValidator implements Validator<Long> {

  private final UserAccountRepository userAccountRepository;

  public ExistUserAccountValidator(UserAccountRepository userAccountRepository) {
    this.userAccountRepository = userAccountRepository;
  }

  @Override
  public String validate(Long userAccountId) {
    if (userAccountId == null) {
      return "ExistUserAccountValidator userAccountId is null";
    }
    Optional<UserAccount> user = userAccountRepository.findById(userAccountId);
    if (user.isEmpty()) {
      return "User with id=" + userAccountId + " isn't exist";
    }
    return null;
  }
}
