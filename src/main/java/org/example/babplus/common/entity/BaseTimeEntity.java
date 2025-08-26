package org.example.babplus.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
@Getter
public class BaseTimeEntity {
    @CreatedDate
    @Column(name = "created_date", columnDefinition = "DATETIME(0)", updatable = false, nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date", columnDefinition = "DATETIME(0)")
    private LocalDateTime updatedDate;

}
