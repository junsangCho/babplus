package org.example.babplus.User.repository;

import org.example.babplus.User.projection.UserInfo;

import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<UserInfo> getUser(String userName);
}
