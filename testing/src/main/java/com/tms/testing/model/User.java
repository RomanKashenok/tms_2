package com.tms.testing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User implements Cloneable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;


    @Override
    public User clone() {
        User clone = new User();
        clone.setId(this.id);
        clone.setName(this.name);
        return clone;
    }
}
