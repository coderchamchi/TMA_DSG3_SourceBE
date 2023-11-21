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
//@Table(name = "orders")
//public class Bill {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long orderId;
//
//    @Column(name = "order_date")
//    private LocalDate createdAt;
//
//    @Column(name = "address_id")
//    private LocalDate address;
//
//    @Column(name="total_money")
//    private int total;
//
//    @Column(name="status")
//    private boolean status;
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
