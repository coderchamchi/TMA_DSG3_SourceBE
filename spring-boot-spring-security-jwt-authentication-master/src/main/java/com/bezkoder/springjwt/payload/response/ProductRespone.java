package com.bezkoder.springjwt.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRespone {
    private String productname;

    private int price;

    private String material;

    private String brand;

    private String madein;

    private int warehouse;

    private String descriptionproduct;

    private LocalDate createdate;

    private LocalDate updatedate;

    private int discount;

    private int size;

    private String base64;

    private String category;

}
