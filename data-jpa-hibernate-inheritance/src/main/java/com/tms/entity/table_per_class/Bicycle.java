package com.tms.entity.table_per_class;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class Bicycle extends Vehicle {

    @Column(name = "wheels")
    private Integer wheels;

}
