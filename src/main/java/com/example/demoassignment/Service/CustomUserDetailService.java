package com.example.demoassignment.Service;

import com.example.demoassignment.Entity.UserEntity;
import com.example.demoassignment.Responsitory.UserResponsitory;
import com.example.demoassignment.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserResponsitory userResponsitory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userResponsitory.findByEmail(username).orElseThrow(()->new BadCredentialsException("Không tìm thấy user!!"));
        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setId(userEntity.getId());
        userPrincipal.setUsername(username);
        userPrincipal.setPassword(userEntity.getPassword());
        userPrincipal.setAuthorities(List.of(new SimpleGrantedAuthority(userEntity.getRole())));
        return userPrincipal;
    }
}
