package com.maxnerva.service;


import com.maxnerva.user.CustomUserDetails;
import com.maxnerva.user.User1;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("===================获取到token已进入自定义验证："+username);
        // 可以进行数据库请求，这里进行模拟
        User1 user = new User1();
        user.setUsername("1101");
        user.setPassword("110119");
        if (user == null) {
            System.out.println("==================="+username);
            throw new UsernameNotFoundException("Could not find the user ‘" + username + "‘");
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new CustomUserDetails(user, true, true, true, true, authorities);
    }
}