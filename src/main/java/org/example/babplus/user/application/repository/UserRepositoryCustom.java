package org.example.babplus.user.application.repository;

import org.example.babplus.user.infrastructure.persistence.projection.UserInfo;

import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<UserInfo> getUser(String userName);
}
