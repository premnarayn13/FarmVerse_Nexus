package edu.infosys.FarmVerseApplication.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.infosys.FarmVerseApplication.entity.FarmUser;
import edu.infosys.FarmVerseApplication.repository.FarmUserRepository;
@Service
public class FarmUserService implements UserDetailsService{
    @Autowired
    private FarmUserRepository repository;

    @Getter
    private String role;
    @Getter
    private FarmUser user;
    @Getter
    private String userId;

    // To save a new user in database
// To save a new user in database
    public void saveUser(FarmUser user) {

        System.out.println("========== Before Save ==========");

        repository.save(user);

        System.out.println("========== After Save ==========");
    }
    // Validate an existing user
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        this.user=repository.findById(username).get();
        this.userId=user.getUsername();
        this.role=user.getRole();
        return this.user;
    }

}
