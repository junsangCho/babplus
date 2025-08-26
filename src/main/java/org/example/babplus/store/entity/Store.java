package org.example.babplus.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.babplus.User.Entity.User;
import org.example.babplus.common.entity.BaseTimeEntity;
import org.example.babplus.store.vo.PatchVO;
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

    public void patch(PatchVO patchVO){
        if(patchVO.getName() != null) this.name = patchVO.getName();
        if(patchVO.getAddress() != null) this.address = patchVO.getAddress();
        if(patchVO.getHotline() != null) this.hotline = patchVO.getHotline();
        if(patchVO.getEnable() != null) this.enable = patchVO.getEnable();
    }
}
