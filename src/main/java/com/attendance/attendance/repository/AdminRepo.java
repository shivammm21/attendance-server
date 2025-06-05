package com.attendance.attendance.repository;

import com.attendance.attendance.entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepo extends MongoRepository<Admin,String> {

    Admin findByEmailId(String emailId);

}
