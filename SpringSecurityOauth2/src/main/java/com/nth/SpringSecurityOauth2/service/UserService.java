package com.nth.SpringSecurityOauth2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = getPasswordOfUser(username);
        if (password == null || password.isEmpty()) {
            throw new UsernameNotFoundException("Username: " + username + " not found");
        }

        return new User(username, password, getAuthority());

    }

    //get default username/password in case without database
    private String getPasswordOfUser(String username) {
        Map<String, String> users = new HashMap<String, String>() {{
            put("user1", passwordEncoder.encode("123")); //encode default password
            put("user2", passwordEncoder.encode("123"));
            put("user3", passwordEncoder.encode("123"));
        }};
        return users.get(username);
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Collections.emptyList();
    }
}
