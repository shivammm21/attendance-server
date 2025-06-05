package com.attendance.attendance.controller;

import com.attendance.attendance.dto.AdminLogin;
import com.attendance.attendance.dto.NewTeamMember;
import com.attendance.attendance.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/add-team-member")
    public ResponseEntity<?> addMember(@RequestBody NewTeamMember newTeamMember){
        try{
            HashMap<String,Object> response = new HashMap<>();

            if(adminService.addTeamMember(newTeamMember)){
                response.put("message","Team Member Added. "+newTeamMember.getFullName()+" have been added and send login details to "+newTeamMember.getEmail());
                return new ResponseEntity<>(response, HttpStatus.OK);

            }else {
                response.put("message","Team Member Added Failed");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/dashboard")
//    public ResponseEntity<?> getDashboard(){
//        try {
//            HashMap<String,Object> response = new HashMap<>();
//
//
//
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
}
