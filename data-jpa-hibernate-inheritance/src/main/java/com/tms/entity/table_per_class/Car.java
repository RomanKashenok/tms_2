package com.tms.entity.table_per_class;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class Car extends Vehicle {

    private String model;

}
