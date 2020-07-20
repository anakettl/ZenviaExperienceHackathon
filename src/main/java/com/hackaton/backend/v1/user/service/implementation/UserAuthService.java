package com.hackaton.backend.v1.user.service.implementation;

import com.hackaton.backend.v1.user.model.User;
import com.hackaton.backend.v1.user.repository.UserRepository;
import com.hackaton.backend.v1.user.service.interfaces.IUserAuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.hackaton.backend.v1.core.validation.GenericMessagesValidationEnum.USER_NOT_FOUND;
import static com.hackaton.backend.v1.core.validation.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class UserAuthService implements IUserAuthService, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(() -> new UsernameNotFoundException(getMessage(USER_NOT_FOUND)));
    }
}
