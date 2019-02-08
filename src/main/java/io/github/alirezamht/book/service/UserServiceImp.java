package io.github.alirezamht.book.service;

import io.github.alirezamht.book.model.User;
import io.github.alirezamht.book.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("userService")
@Transactional
public class UserServiceImp implements UserService {

   // private final UserRepository userRepository;

   // public UserServiceImp(UserRepository userRepository) {
   //     this.userRepository = userRepository;
   //}

  //  @Override
  //  public Boolean check(String username, String password) {
  //      return userRepository.existsUserByUsernameAndPassword(username,password);

  //  }
}
