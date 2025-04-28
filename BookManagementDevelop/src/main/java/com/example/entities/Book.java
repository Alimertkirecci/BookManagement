package com.example.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long bid;
    private Long cid;


    @NotEmpty
    @NotNull
    @Size(min = 2, max = 50)
    private String title;
    @NotEmpty
    @NotNull
    @Size(min = (3) , max = 75)
    private String description;
    @NotEmpty
    @NotNull
    @Size(min = 2, max = 50)
    private String writer;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date date;
    @NotNull
    @Min(1)
    @Max(3000)
    private BigDecimal price;
    @ManyToOne
    private Customer bookstore;


}
