package org.example.babplus.user.application.service;

import lombok.RequiredArgsConstructor;
import org.example.babplus.user.application.factory.UserFactory;
import org.example.babplus.user.infrastructure.persistence.projection.UserInfo;
import org.example.babplus.user.application.repository.UserRepository;
import org.example.babplus.user.application.dto.command.JoinCommand;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void joinUser(JoinCommand request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        userExists(request.getId());

        userRepository.save(UserFactory.create(request, encodedPassword));
    }

    public UserInfo getUser(String userId){
        return userRepository.getUser(userId).orElseThrow();
    }

    public void userExists(String userId) {
        if(userRepository.existsById(userId)){
            throw new IllegalArgumentException();
        }
    }
}
