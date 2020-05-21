package com.tms.entity.single_table;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("SHAMPOO")
public class Shampoo extends MyProduct {

    private String producer;
}
