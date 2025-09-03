package org.example.babplus.menu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.babplus.common.entity.BaseTimeEntity;
import org.example.babplus.menu.enums.MealType;
import org.example.babplus.menu.vo.PatchVO;
import org.example.babplus.store.entity.Store;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="menu")
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Menu extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Store store;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<MenuItem> menuItems = new ArrayList<>();

    @Column(name = "menu_date", nullable = false)
    private LocalDate menuDate;

    @Column(name = "meal_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    public void patch(PatchVO patchVO){
        if(patchVO.getMenuDate() != null) this.menuDate = patchVO.getMenuDate();
        if(patchVO.getMealType() != null) this.mealType = patchVO.getMealType();
        if(patchVO.getMenuItemNames() != null){
            this.menuItems.clear();
            patchVO.getMenuItemNames().stream()
                    .map(MenuItem::new)
                    .forEach(this::addItem);
        }
    }

    public void addItem(MenuItem item){
        item.setMenu(this);
        menuItems.add(item);
    }
}
