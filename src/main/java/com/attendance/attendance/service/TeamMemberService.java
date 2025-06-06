package com.attendance.attendance.service;

import com.attendance.attendance.dto.NewTeamMember;
import com.attendance.attendance.entity.TeamMember;
import com.attendance.attendance.repository.TeamMemberRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberRepo teamMemberRepo;

    public void save(TeamMember teamMember) {
        teamMemberRepo.save(teamMember);
    }

    public boolean allreadtUserExists(String emailId) {
        return teamMemberRepo.existsByEmailId(emailId);
    }

    public boolean saveTeamMember(NewTeamMember newTeamMember) {
        if(newTeamMember != null) {

            if(!allreadtUserExists(newTeamMember.getEmail())){
                TeamMember teamMember = new TeamMember();
                teamMember.setEmailId(newTeamMember.getEmail());
                teamMember.setFullName(newTeamMember.getFullName());
                teamMember.setRole(newTeamMember.getRole());
                teamMemberRepo.save(teamMember);
                log.info("Team member saved to database");
                return true;
            }
            log.info("Team member already exists");
        }
        return false;
    }
}
