package com.tms.fullstackbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "subscribers")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String desc;

    @Column
    private boolean active = true;

    @Column
    private Date updated;

    @PrePersist
    public void onSave() {
        this.active = true;
    }

    @PreUpdate
    public void onUpdate() {
        this.updated = new Date();
    }

}
