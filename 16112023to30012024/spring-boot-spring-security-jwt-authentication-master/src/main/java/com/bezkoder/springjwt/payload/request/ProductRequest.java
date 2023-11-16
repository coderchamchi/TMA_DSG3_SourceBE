package com.bezkoder.springjwt.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String productname;

    private int price;

    private String material;

    private String brand;

    private String madein;

    private int warehouse;

    private String descriptionproduct;

    private String createdate;

    private String updatedate;

    private int discount;

    private int size;

    private String base64;

    private long categoryid;
}

