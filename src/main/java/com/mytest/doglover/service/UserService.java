package com.mytest.doglover.service;

import com.mytest.doglover.model.user.User;
import com.mytest.doglover.repository.UserRepository;
import com.mytest.doglover.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

  @Service
  public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider){
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Transactional
  public User join(User user){
    return userRepository.save(user);
  }

  @Transactional
  public String login(String email, String password){
    User user = userRepository.findByEmail(email)
            .orElseThrow(()-> new IllegalArgumentException("가입되지 않은 email입니다."));

    if(!passwordEncoder.matches(password, user.getPassword())){
      throw new IllegalArgumentException("잘못된 비밀번호 입니다.");
    }

    return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
  }

  @Transactional
  public Optional<User> findByEmail(String email){
    return userRepository.findByEmail(email);
  }
}
