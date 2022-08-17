package com.simple.article.domain.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * author         : raon_jh
 * date           : 2022/08/08
 * description    :
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter @Setter
public class BaseStateEntity extends BaseTimeEntity{

    @Column(name = "state", nullable = false)
    private int state;
}
