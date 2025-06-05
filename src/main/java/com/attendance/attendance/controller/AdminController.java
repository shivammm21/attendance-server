package com.attendance.attendance.controller;

import com.attendance.attendance.dto.AdminLogin;
import com.attendance.attendance.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/admin")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminLogin adminLogin){

        try {
            HashMap<String,Object> response = new HashMap<>();
            System.out.println(adminLogin.getEmailId());
            if(adminService.checkAdmin(adminLogin)){
                response.put("message","Login Successful");
                response.put("User",adminLogin.getEmailId());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else {
                response.put("message","Login Failed");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }


        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping("/create")
//    public ResponseEntity<?> create(){
//        adminService.createAdmin();
//         return new ResponseEntity<>("Admin Created Successfully",HttpStatus.OK);
//    }



}
