package org.example.babplus.user.entity;

import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.babplus.common.entity.BaseTimeEntity;
import org.example.babplus.ticketWallet.entity.TicketWallet;
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

    @Column(name = "customer_key ", unique = true, nullable = false, updatable = false, length = 26)
    private String customerKey ;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private TicketWallet ticketWallet;

    @Column(name = "enable", nullable = false)
    private boolean enable;

    @PrePersist
    public void generateCustomerKey() {
        if (this.customerKey == null) {
            this.customerKey = UlidCreator.getUlid().toString();
        }
    }

    public void assignWallet(TicketWallet wallet) {
        this.ticketWallet = wallet;
    }

}
