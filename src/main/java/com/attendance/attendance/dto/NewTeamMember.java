package com.attendance.attendance.dto;

import lombok.Data;

@Data
public class NewTeamMember {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String role;
}
