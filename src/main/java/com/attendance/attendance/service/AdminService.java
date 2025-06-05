package com.attendance.attendance.service;

import com.attendance.attendance.dto.AdminLogin;
import com.attendance.attendance.dto.NewTeamMember;
import com.attendance.attendance.entity.Admin;
import com.attendance.attendance.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private TeamMemberService teamMemberService;

    public void createAdmin(){
        Admin admin = new Admin();
        adminRepo.save(admin);
    }

    private Admin getAdmin(AdminLogin adminLogin){
        System.out.println(adminRepo.findByEmailId(adminLogin.getEmailId()));
        return adminRepo.findByEmailId(adminLogin.getEmailId());
    }

    public boolean checkAdmin(AdminLogin adminLogin){
        Admin admin = getAdmin(adminLogin);
        if(admin != null){
            return admin.getPassword().equals(adminLogin.getPassword());
        }
        return false;
    }

    public boolean addTeamMember(NewTeamMember newTeamMember){
        return teamMemberService.saveTeamMember(newTeamMember);
    }
}
