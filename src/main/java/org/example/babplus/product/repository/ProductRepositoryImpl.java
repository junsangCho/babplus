package org.example.babplus.product.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.babplus.product.projection.ProductInfo;

import java.util.List;
import java.util.function.Supplier;

import static org.example.babplus.product.entity.QProduct.product;

@RequiredArgsConstructor
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
