package org.example.babplus.user.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.babplus.ticketWallet.projection.TicketWalletInfo;
import org.example.babplus.user.projection.UserInfo;

import java.util.Optional;
import java.util.function.Supplier;

import static org.example.babplus.user.entity.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<UserInfo> getUser(String userName) {
        return Optional.ofNullable(jpaQueryFactory.select(Projections.fields(UserInfo.class,
                        user.id,
                        user.password,
                        user.customerKey,
                        user.role,
                        Projections.fields(TicketWalletInfo.class,
                            user.ticketWallet.id,
                            user.ticketWallet.balance
                        ).as("ticketWallet"),
                        user.enable
                        ))
                .from(user)
                .join(user.ticketWallet)
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
