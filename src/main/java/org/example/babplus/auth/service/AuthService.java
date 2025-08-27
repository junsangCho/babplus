package org.example.babplus.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.babplus.auth.dto.LoginRequest;
import org.example.babplus.auth.vo.JoinVO;
import org.example.babplus.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserDetails authenticateUser(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getId(), request.getPassword()));

        return (UserDetails) authentication.getPrincipal();
    }

    public void joinUser(JoinVO request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        userRepository.save(request.toEntity(encodedPassword));
    }
}
