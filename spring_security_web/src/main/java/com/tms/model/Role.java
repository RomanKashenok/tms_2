package com.tms.model;

import lombok.*;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Student> students;
}
