package com.attendance.attendance.service;

import com.attendance.attendance.dto.NewTeamMember;
import com.attendance.attendance.entity.TeamMember;
import com.attendance.attendance.repository.TeamMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberRepo teamMemberRepo;

    public void save(TeamMember teamMember) {
        teamMemberRepo.save(teamMember);
    }

    public boolean saveTeamMember(NewTeamMember newTeamMember) {
        if(newTeamMember != null) {
            TeamMember teamMember = new TeamMember();
            teamMember.setEmailId(newTeamMember.getEmail());
            teamMember.setFullName(newTeamMember.getFullName());
            teamMember.setRole(newTeamMember.getRole());
            teamMemberRepo.save(teamMember);
            return true;
        }
        return false;
    }
}
