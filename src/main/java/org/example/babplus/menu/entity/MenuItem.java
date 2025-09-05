package org.example.babplus.menu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.babplus.common.entity.BaseTimeEntity;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="menu_item")
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MenuItem extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Menu menu;

    @Column(name = "name", nullable = false)
    private String name;

    public MenuItem(String name){
        this.name = name;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }

    public Long getMenuId(){
        return this.menu.getId();
    }
}
