package org.example.babplus.user.service;

import lombok.RequiredArgsConstructor;
import org.example.babplus.auth.vo.JoinVO;
import org.example.babplus.user.projection.UserInfo;
import org.example.babplus.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void joinUser(JoinVO request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        userExists(request.getId());

        userRepository.save(request.toEntity(encodedPassword));
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
