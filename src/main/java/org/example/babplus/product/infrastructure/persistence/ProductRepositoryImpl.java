package org.example.babplus.product.infrastructure.persistence;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.babplus.product.application.repository.ProductRepositoryCustom;
import org.example.babplus.product.infrastructure.persistence.projection.ProductInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Supplier;

import static org.example.babplus.product.domain.QProduct.product;


@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ProductInfo> getProducts() {
        return jpaQueryFactory.select(Projections.fields(ProductInfo.class,
                        product.id,
                        product.name,
                        product.ticketAmount,
                        product.price
                        ))
                .from(product).stream().toList();
    }

    private BooleanBuilder nullSafeBooleanBuilder(Supplier<BooleanExpression> supplier) {
        try {
            return new BooleanBuilder(supplier.get());
        } catch (Exception e) {
            return new BooleanBuilder();
        }
    }
}
