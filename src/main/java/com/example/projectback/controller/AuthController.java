package com.example.projectback.controller;
import com.example.projectback.model.User;
import com.example.projectback.repository.UserRepository;
import com.example.projectback.service.CustomerService;
import com.example.projectback.service.JwtProvider;
import com.example.projectback.service.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.projectback.controller.LoginRequest;
@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserRepository userRepository;
    private JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder;
    private CustomerService customer=new CustomerService();

    public AuthController(UserRepository userRepository,CustomerService customer,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.customer=customer;
        this.passwordEncoder=passwordEncoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
        String email = user.getEmail();
        String password = user.getPassword();
        String firstString = user.getFirstName();
        String lastString = user.getLastName();

        User isEmailExist = userRepository.findByEmail(email);
        if (isEmailExist != null) {
            throw new UserException("Email is already used with another account");
        }


        User createdUser = new User();
        createdUser.setEmail(email);
        createdUser.setPassword(passwordEncoder.encode(password));
        createdUser.setFirstName(firstString);
        createdUser.setLastName(lastString);
        User savedUser = userRepository.save(createdUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse(token, "Signup Successful");
        return new ResponseEntity<AuthResponse>(authResponse.HttpStatus.CREATED);
    }

    @PostMapping("/signin")


        public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest){
            String username = loginRequest.getEmail();
            String password = loginRequest.getPassword();

            Authentication authentication = authenticate(username, password);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtProvider.generateToken(authentication);

            AuthResponse authResponse = new AuthResponse(token, "Signin Successful");

            return new ResponseEntity<AuthResponse>(authResponse.HttpStatus.CREATED);

        }


    private Authentication authenticate(String username, String password) {
    UserDetails userDetails = customer.loadUserByUsername(username);

    if(userDetails==null){
        throw new BadCredentialsException("Invalid username");
    }
    if(!passwordEncoder.matches(password,userDetails.getPassword())){
        throw new BadCredentialsException("invalid password");
    }
    return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }

}