package com.alterra.submission.service;

import com.alterra.submission.repository.UserRepository;
import com.alterra.submission.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.getDistinctTopByUsername(username);
        if (user == null) throw new UsernameNotFoundException("Username not found");
        return user;
    }

}
