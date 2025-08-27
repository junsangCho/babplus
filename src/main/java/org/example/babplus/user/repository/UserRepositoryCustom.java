package org.example.babplus.user.repository;

import org.example.babplus.user.projection.UserInfo;

import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<UserInfo> getUser(String userName);
}
