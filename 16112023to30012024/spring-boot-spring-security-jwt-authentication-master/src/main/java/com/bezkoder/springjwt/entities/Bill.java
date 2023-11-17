//package com.bezkoder.springjwt.entities;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import java.time.LocalDate;
//import javax.persistence.*;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "bill")
//public class Bill {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Billid")
//    private long billid;
//
//    @Column(name = "Createdate")
//    private LocalDate createdate;
//
//    @Column(name = "Updatedate")
//    private LocalDate updatedate;
//
//    @Column(name="Total")
//    private int total;
//
////    @OneToMany(mappedBy = "bill")
////    @JsonIgnore
////    private List<BillDetail> listBillDetail = new ArrayList<>();
//
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="Userid")
//    @JsonIgnore
//    private User user;
//}
//
