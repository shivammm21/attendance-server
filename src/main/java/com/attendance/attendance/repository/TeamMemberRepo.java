package com.attendance.attendance.repository;

import com.attendance.attendance.entity.TeamMember;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamMemberRepo extends MongoRepository<TeamMember, String> {
}
