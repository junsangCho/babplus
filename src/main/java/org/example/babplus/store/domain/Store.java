package org.example.babplus.store.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.babplus.common.entity.BaseTimeEntity;
import org.example.babplus.store.application.dto.command.PatchCommand;
import org.example.babplus.user.domain.User;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="store")
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Store extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "hotline")
    private String hotline;

    @Column(name = "enable", nullable = false)
    private Boolean enable;

    public void patch(PatchCommand patchCommand){
        if(patchCommand.getName() != null) this.name = patchCommand.getName();
        if(patchCommand.getAddress() != null) this.address = patchCommand.getAddress();
        if(patchCommand.getHotline() != null) this.hotline = patchCommand.getHotline();
        if(patchCommand.getEnable() != null) this.enable = patchCommand.getEnable();
    }
}
