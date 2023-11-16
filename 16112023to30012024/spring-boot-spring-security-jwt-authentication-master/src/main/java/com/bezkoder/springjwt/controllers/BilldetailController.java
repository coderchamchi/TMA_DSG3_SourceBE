//package com.bezkoder.springjwt.controllers;
//
//import com.bezkoder.springjwt.Service.BillDetailService;
//
//import com.bezkoder.springjwt.entities.BillDetail;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("ProjectSJ/Billdetai")
//public class BilldetailController {
//    @Autowired
//    BillDetailService billService;
//    @GetMapping("/all")
//
//    public ResponseEntity<List<BillDetail>> findallBill() {
//        List<BillDetail> listBill = billService.Getallbill();
//        return new ResponseEntity<List<BillDetail>>(listBill, HttpStatus.OK);
//    }
//
//}
