package edu.infosys.FarmVerseApplication.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import edu.infosys.FarmVerseApplication.entity.FarmUser;
import edu.infosys.FarmVerseApplication.repository.FarmUserRepository;
@Service
public class FarmUserService implements UserDetailsService{
    @Autowired
    private FarmUserRepository repository;

    public void saveUser(FarmUser user) {

        System.out.println("========== Before Save ==========");

        repository.save(user);

        System.out.println("========== After Save ==========");
    }
    // Validate an existing user
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        FarmUser user = repository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return user;
    }

    public String getCurrentUserId() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }

    public FarmUser getCurrentUser() {

        String username = getCurrentUserId();

        return repository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
