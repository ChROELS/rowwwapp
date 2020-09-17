package be.intecbrussel.service;

import be.intecbrussel.models.registration.Team;
import be.intecbrussel.repositories.CRUDOperationsTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {
    private final CRUDOperationsTeam teamRepository;

    @Autowired
    public TeamService(CRUDOperationsTeam teamRepository) {
        this.teamRepository = teamRepository;
    }

    //Competition
    public void createTeam(Team team){
        teamRepository.save(team);
    }
    public boolean updateTeam(Team team, Team newTeam){
        Optional<Team> team1 = teamRepository.findById(team.getId());
        if(team1.isPresent()){
            teamRepository.delete(team1.get());
            teamRepository.save(newTeam);
            return true;
        }else{
            return false;
        }
    }
    public boolean deleteTeam(Team team){
        boolean idExists = teamRepository.existsById(team.getId());
        if(idExists) {
            teamRepository.delete(team);
            return true;
        }else{
            return false;
        }
    }
}
