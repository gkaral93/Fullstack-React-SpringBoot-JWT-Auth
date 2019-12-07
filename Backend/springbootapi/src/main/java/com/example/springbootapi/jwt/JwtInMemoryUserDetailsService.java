package com.example.springbootapi.jwt;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "gkaral",
        "$2b$10$pZqsyvjfL1TkVzxILTtthOsK8KC67fYv36E2ja93HqEZHSQzzNYym", "ROLE_USER_2"));
    inMemoryUserList.add(new JwtUserDetails(1L, "carlos",
            "$2b$10$pZqsyvjfL1TkVzxILTtthOsK8KC67fYv36E2ja93HqEZHSQzzNYym", "ROLE_USER_2"));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}



