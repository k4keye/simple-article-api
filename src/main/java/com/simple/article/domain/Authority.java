package com.simple.article.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_AUTHORITY")
@NoArgsConstructor
@Getter
@Setter
public class Authority {
    @Id
    @Column(name = "authority_name", length = 50)
    private String authorityName;
}