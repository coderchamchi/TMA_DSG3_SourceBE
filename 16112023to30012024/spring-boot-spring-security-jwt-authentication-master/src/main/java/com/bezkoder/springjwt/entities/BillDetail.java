//package com.bezkoder.springjwt.entities;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import javax.persistence.*;
//
//
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "billdetail")
//public class BillDetail {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long billdetailid;
//
//    @Column(name="Quantity")
//    private int quantity;
//
//    @Column(name="Price")
//    private Float price;
//
//    @Column(name="Shipping")
//    private Float shipping;
//
//    @Column(name="Discount")
//    private Float discount;
//
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "Billid")
//    private Bill bill;
//
//
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "Productid")
//    private Product product;
//
//}
