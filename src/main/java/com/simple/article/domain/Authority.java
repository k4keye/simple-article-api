package com.simple.article.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
@NoArgsConstructor
@Getter
public class Authority {
    @Id
    @Column(name = "authority_name", length = 50)
    private String authorityName;
}