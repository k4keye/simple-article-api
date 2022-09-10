package com.simple.article.domain.base;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
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

    enum STATE{
        INACTIVE(0),
        ACTIVE(1);

        int code;

        STATE(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    @Column(name = "state", nullable = false)
    @ColumnDefault("1")
    private int state;

    public void inActive(){
        this.state = STATE.INACTIVE.getCode();
    }
    public void active(){
        this.state =  STATE.ACTIVE.getCode();
    }

    public boolean isActive(){
        return this.state == STATE.ACTIVE.getCode();
    }
}
