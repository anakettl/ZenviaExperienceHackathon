package com.hackaton.backend.v1.user.service.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUserAuthService {
    UserDetails loadUserByUsername(String user);
}
