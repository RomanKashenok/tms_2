package com.tms.entity.single_table;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
public class MyProduct {
    @Id
    private Long productId;
    private String name;
}
