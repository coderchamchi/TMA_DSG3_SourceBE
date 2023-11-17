//package com.bezkoder.springjwt.Service.Impl;
//
//import com.bezkoder.springjwt.Service.BillService;
//import com.bezkoder.springjwt.Service.UserService;
//import com.bezkoder.springjwt.constant.WebUnit;
//import com.bezkoder.springjwt.entities.Bill;
//import com.bezkoder.springjwt.entities.User;
//import com.bezkoder.springjwt.payload.request.BillRequest;
//import com.bezkoder.springjwt.repository.BillRepository;
//import com.bezkoder.springjwt.repository.UserRepository;
//import org.apache.commons.lang3.ObjectUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Objects;
//
//
//@Service
//public class BillServiceImpl implements BillService {
//    @Autowired
//    private BillRepository billRepository;
//
//    @Autowired
//    UserDetailsService userDetailsService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public List<Bill> getallBill() {
//        return billRepository.findAll();
//    }
//    @Override
//    public boolean saveBill(BillRequest billRequest)
//    {
//        try {
//            String username = WebUnit.getUsername();
//            if (!Objects.equals(username, WebUnit.ANONYMOUS_USER))
//            {
//                User user = userRepository.findUserByUsername(username);
//                if(ObjectUtils.isEmpty(user)){
//                    return false;
//                }
//                Bill bill = new Bill();
//                bill.setTotal(billRequest.getTotal());
//                bill.setCreatedate(LocalDate.now());
//                bill.setUpdatedate(LocalDate.now());
//                bill.setUser(user);
//                billRepository.save(bill);
//                return true;
//                }
//            return false;
//        }
//        catch(Exception e)
//            {
//                return false;
//            }
//    }
//}
