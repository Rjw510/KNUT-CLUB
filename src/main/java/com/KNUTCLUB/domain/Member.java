package com.KNUTCLUB.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @Column(name = "student_id")
    private String studentId;

    private String password;

    private String name;

    private String department;

    private String birth;

    private String gender;

    private String phone;

    private String address;

    @Column(name = "detail_address")
    private String detailAddress;

//    private String club;
}
