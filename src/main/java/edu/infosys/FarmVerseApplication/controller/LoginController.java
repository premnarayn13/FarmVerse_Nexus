package edu.infosys.FarmVerseApplication.controller;

import edu.infosys.FarmVerseApplication.config.Encoderconfig;
import edu.infosys.FarmVerseApplication.entity.FarmUser;
import edu.infosys.FarmVerseApplication.service.FarmUserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/farmverse")
@CrossOrigin(origins = "http://localhost:3636", allowCredentials = "true")

public class LoginController {

    @Autowired
    private FarmUserService service;

    @Autowired
    private Encoderconfig econfig;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody java.util.Map<String, String> request) {

        try {

            System.out.println("REGISTER API HIT");

            FarmUser user = new FarmUser();

            user.setUsername(request.get("username"));

            PasswordEncoder encoder = econfig.passwordEcoding();
            user.setPassword(encoder.encode(request.get("password")));

            user.setPersonalName(request.get("personalName"));
            user.setEmail(request.get("email"));
            user.setRole("USER");

            service.saveUser(user);

            System.out.println("USER SAVED");

            return ResponseEntity.ok("Registration Successful");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/login/{userId}/{password}")
    public String validateUser(@PathVariable String userId,@PathVariable String password) {
        Boolean flag=true;
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch(Exception ex) {
            flag=false;
        }
        return flag.toString();

    }

    @GetMapping("/login")
    public FarmUser getUserDetails() {
        return service.getUser();
    }


    @GetMapping("/user")
    public String getUserId() {
        return service.getUserId();
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        // Clear Spring Security Context
        SecurityContextHolder.clearContext();
        // Invalidate session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        // Delete cookie
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.ok("Logout successful");
    }
}



