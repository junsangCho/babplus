package org.example.babplus.user.infrastructure.persistence;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.babplus.user.application.repository.UserRepositoryCustom;
import org.example.babplus.user.infrastructure.persistence.projection.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Supplier;

import static org.example.babplus.user.domain.QUser.user;


@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<UserInfo> getUser(String userName) {
        return Optional.ofNullable(jpaQueryFactory.select(Projections.fields(UserInfo.class,
                        user.id,
                        user.password,
                        user.customerKey,
                        user.role,
                        user.enable
                        ))
                .from(user)
                .where(nullSafeBooleanBuilder(()->user.id.eq(userName)))
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
