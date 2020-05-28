package com.tms.springbootdemo.com.tms.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private boolean active;

}
