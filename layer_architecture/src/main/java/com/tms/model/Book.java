package com.tms.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book {

    private Long id;

    private String genre;

    private String title;

}
