package edu.infosys.FarmVerseApplication.service;

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

    private String role;
    private FarmUser user;
    private String userId;

    public String getRole() {
        return role;
    }
    public FarmUser getUser() {
        return user;
    }

    public String getUserId() {
        return userId;
    }
    // To save a new user in database
    public void saveUser(FarmUser user) {
        repository.save(user);
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
