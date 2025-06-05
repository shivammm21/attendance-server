package com.attendance.attendance.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "teamMember")
public class TeamMember {
    @Id
    private String id;
    private String fullName;
    private String emailId;
    private String phoneNumber;
    private String role;
    private String password;
}
