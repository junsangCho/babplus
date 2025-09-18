package org.example.babplus.ticketWallet.infrastructure.persistence;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.babplus.payment.infrastructure.persistence.projection.PaymentInfo;
import org.example.babplus.ticketWallet.application.repository.TicketWalletRepositoryCustom;
import org.example.babplus.ticketWallet.infrastructure.persistence.projection.TicketWalletInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Supplier;

import static org.example.babplus.ticketWallet.domain.QTicketWallet.ticketWallet;


@RequiredArgsConstructor
@Repository
public class TicketWalletRepositoryImpl implements TicketWalletRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public int getTicketAmount(String userId) {
        Integer result = jpaQueryFactory
                .select(ticketWallet.totalAmount.sum().subtract(ticketWallet.usedAmount.sum()))
                .from(ticketWallet)
                .where(ticketWallet.user.id.eq(userId))
                .fetchOne();

        return result != null ? result : 0;
    }

    @Override
    public List<TicketWalletInfo> getTicketWallets(String userId) {
        return jpaQueryFactory
                .select(Projections.fields(TicketWalletInfo.class,
                            ticketWallet.id,
                            Projections.fields(PaymentInfo.class,ticketWallet.payment.id).as("payment"),
                            ticketWallet.totalAmount,
                            ticketWallet.usedAmount,
                            ticketWallet.createdDate,
                            ticketWallet.updatedDate
                        ))
                .from(ticketWallet)
                .where(ticketWallet.user.id.eq(userId))
                .fetch();


    }

    private BooleanBuilder nullSafeBooleanBuilder(Supplier<BooleanExpression> supplier) {
        try {
            return new BooleanBuilder(supplier.get());
        } catch (Exception e) {
            return new BooleanBuilder();
        }
    }
}
