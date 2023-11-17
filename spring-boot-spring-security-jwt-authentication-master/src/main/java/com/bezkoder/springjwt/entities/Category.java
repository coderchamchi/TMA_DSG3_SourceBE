package com.bezkoder.springjwt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryid;

    @Column(name = "Categoryname")
    private String categoryname;

    @Column(name = "Createdate")
    private LocalDate createdate;

    @Column(name = "Updatedate")
    private LocalDate updatedate;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> listProduct;
}
