package com.KNUTCLUB.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {

    @Id
    private String clubId;

    private String password;

    @Column(name = "club_name")
    private String clubName;

    private String name;

    private String email;

    private String phone;
}
