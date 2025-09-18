package org.example.babplus.menu.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.babplus.common.entity.BaseTimeEntity;
import org.example.babplus.menu.application.dto.command.PatchCommand;
import org.example.babplus.store.domain.Store;
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

    public void patch(PatchCommand patchCommand){
        if(patchCommand.getMenuDate() != null) this.menuDate = patchCommand.getMenuDate();
        if(patchCommand.getMealType() != null) this.mealType = patchCommand.getMealType();
        if(patchCommand.getMenuItemNames() != null){
            this.menuItems.clear();
            patchCommand.getMenuItemNames().stream()
                    .map(MenuItem::new)
                    .forEach(this::addItem);
        }
    }

    public void addItem(MenuItem item){
        item.setMenu(this);
        menuItems.add(item);
    }
}
