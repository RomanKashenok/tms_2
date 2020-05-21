package com.tms.entity.joined_table;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "petId2")
public class Dog extends Animal {

    @Column(name = "nick_name")
    private String nickName;
}
