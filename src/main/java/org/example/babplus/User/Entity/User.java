package org.example.babplus.User.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.babplus.common.entity.BaseTimeEntity;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="users")
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User extends BaseTimeEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "enable", nullable = false)
    private boolean enable;
}
