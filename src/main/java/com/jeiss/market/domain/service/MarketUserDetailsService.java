package com.jeiss.market.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MarketUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("jeisson","{noop}market", new ArrayList<>());
    }


    /**
     * private static List<User> users = new ArrayList();
     *
     *     public MarketUserDetailsService() {
     *         users.add(new User("jeisson", "{noop}market", new ArrayList<>()));
     *     }
     *
     *     @Override
     *     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     *         // TODO ir a BD por usuarios o sistemas AUTH0
     *         Optional<User> user = users.stream().filter(u -> u.getUsername().equals(username)).findAny();
     *         if (!user.isPresent()) {
     *             thrownew UsernameNotFoundException("User not found by name: " + username);
     *         }
     *         returnnew User(user.get().getUsername(), user.get().getPassword(), user.get().getAuthorities());
     *     }
     *
     *
     * **/
}
