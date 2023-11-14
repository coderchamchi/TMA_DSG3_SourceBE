package com.bezkoder.springjwt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Base64;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productid;

    @Column(name = "Productname")
    private String productname;

    @Column(name = "Price")
    private int price;

    @Column(name = "Material")
    private String material;

    @Column(name="Madein")
    private String madein;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Descriptionproduct")
    @Type(type = "text")
    private String descriptionproduct;

    @Column(name = "Createdate")
    private LocalDate createdate;

    @Column(name = "Updatedate")
    private LocalDate updatedate;

    @Column(name ="Warehouse")
    private int warehouse;

    @Column(name ="Discount")
    private int discount;

    @Column(name = "Size")
    private int size;

    @Column(name="Base64")
    @Type(type = "text")
    private String base64;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "Categoryid")
    @JsonIgnore
    private Category category;

//    @OneToMany(mappedBy = "product")
//    @JsonIgnore
//    private List<BillDetail> listbilldetail = new ArrayList<>();

}
