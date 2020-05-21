package com.tms.entity.mapped_superclass;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class Barista extends Person {

    @Column(name = "age")
    private Integer age;

    @Column(name = "occ")
    private String occupation;
}
