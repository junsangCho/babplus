package org.example.babplus.User.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.babplus.User.projection.UserInfo;

import java.util.Optional;
import java.util.function.Supplier;

import static org.example.babplus.User.Entity.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<UserInfo> getUser(String userName) {
        return Optional.ofNullable(jpaQueryFactory.select(Projections.fields(UserInfo.class,
                        user.loginId,
                        user.password,
                        user.enable,
                        user.role
                        ))
                .from(user)
                .where(user.loginId.eq(userName))
                .fetchOne());
    }

    private BooleanBuilder nullSafeBooleanBuilder(Supplier<BooleanExpression> supplier) {
        try {
            return new BooleanBuilder(supplier.get());
        } catch (Exception e) {
            return new BooleanBuilder();
        }
    }
}
