package com.tms.sbsecurity.app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private boolean active = true;
    @Column(name = "updated")
    private Date updatedAt;
    @Column(name = "created")
    private Date createdAt;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;

    @PrePersist
    public void onSave() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = new Date();
    }
}
