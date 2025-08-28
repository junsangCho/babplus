package org.example.babplus.menu.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.babplus.menu.projection.MenuInfo;
import org.example.babplus.menuItem.projection.MenuItemInfo;
import org.example.babplus.store.projection.StoreInfo;

import java.util.Optional;
import java.util.function.Supplier;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static org.example.babplus.menu.entity.QMenu.menu;
import static org.example.babplus.menuItem.entity.QMenuItem.menuItem;


@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<MenuInfo> getMenu(Long menuId, Long storeId) {
        return Optional.ofNullable(jpaQueryFactory.from(menu)
                    .leftJoin(menu.menuItems, menuItem)
                    .where(menu.id.eq(menuId).and(menu.store.id.eq(storeId)))
                    .transform(
                        groupBy(menu.id).as(
                            Projections.fields(MenuInfo.class,
                                    menu.id,
                                    Projections.fields(StoreInfo.class, menu.store.id).as("store"),
                                    menu.menuDate,
                                    menu.mealType,
                                    menu.createdDate,
                                    menu.updatedDate,
                                    list(Projections.fields(MenuItemInfo.class,
                                            menuItem.name
                                    )).as("menuItems")
                            )
                        )
                    ).get(menuId));
    }

    private BooleanBuilder nullSafeBooleanBuilder(Supplier<BooleanExpression> supplier) {
        try {
            return new BooleanBuilder(supplier.get());
        } catch (Exception e) {
            return new BooleanBuilder();
        }
    }
}
