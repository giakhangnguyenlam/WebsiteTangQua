package com.swcat.giftapp.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accountInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class accountInfo {
    @Id
    @Column(name = "uname")
    private String uname;

    @Column(name = "disName")
    private String disName;

    @Column(name = "uaddress")
    private String uaddress;

    @Column(name = "phonenum")
    private Integer phonenum;
}
