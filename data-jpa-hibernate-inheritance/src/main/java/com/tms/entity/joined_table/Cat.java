package com.tms.entity.joined_table;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "petId")
public class Cat extends Animal {

    @Column(name = "name")
    private String name;

    @Column(name = "is_home_cat")
    private Boolean isHomeCat;
}
