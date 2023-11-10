//package com.bezkoder.springjwt.Service.Impl;
//
//import com.bezkoder.springjwt.Service.BillDetailService;
//
//import com.bezkoder.springjwt.entities.Bill;
//import com.bezkoder.springjwt.entities.BillDetail;
//import com.bezkoder.springjwt.repository.BillDetailRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//@Service
//public class BillDetailServiceImpl implements BillDetailService {
//    @Autowired
//    BillDetailRepository billdetailRepository;
//
//    Map<Long, BillDetail> maps = new HashMap<>();
//    @Override
//    public List<BillDetail> Getallbill() {
//        return billdetailRepository.findAll();
//    }
//
//    @Override
//    public boolean Addbill(Bill item) {
//        return false;
//    }
//
//    @Override
//    public boolean Updatebill() {
//        return false;
//    }
//}
