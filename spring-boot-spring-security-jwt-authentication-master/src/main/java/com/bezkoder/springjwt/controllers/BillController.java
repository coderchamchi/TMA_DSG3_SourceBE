package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Service.BillService;
import com.bezkoder.springjwt.Service.UserService;
import com.bezkoder.springjwt.dto.ResponseJson;
import com.bezkoder.springjwt.entities.Bill;
import com.bezkoder.springjwt.payload.request.BillRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ProjectSJ/Bill")
public class BillController {
    @Autowired
    private BillService billService;

    private UserService userService;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Bill>> findallBill() {
        List<Bill> listbill = billService.getallBill();
        return new ResponseEntity<List<Bill>>(listbill, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseJson<Boolean>> saveBill(@RequestBody BillRequest billRequest)
    {
        if(ObjectUtils.isEmpty(billRequest)){
            System.out.println(billRequest);
            return ResponseEntity.ok().body(new ResponseJson<>(Boolean.FALSE, HttpStatus.BAD_REQUEST, "Error: Null"));
        }
        else
        {
        boolean check = billService.saveBill(billRequest);
            if (!check) {
                return ResponseEntity.ok().body(new ResponseJson<>(Boolean.FALSE, HttpStatus.NOT_FOUND, "Error: User Not Found"));
                }
            return ResponseEntity.ok().body(new ResponseJson<>(Boolean.TRUE, HttpStatus.OK, "Add Successed"));
        }
    }
}
