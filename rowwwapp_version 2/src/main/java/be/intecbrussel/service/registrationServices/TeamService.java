package be.intecbrussel.service.registrationServices;

import be.intecbrussel.models.registration.Team;
import be.intecbrussel.repositories.CRUDOperationsTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JpaQueryLookupStrategy;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @PersistenceContext
    private EntityManager em;
    private final CRUDOperationsTeam teamRepository;

    @Autowired
    public TeamService(CRUDOperationsTeam teamRepository) {

        this.teamRepository = teamRepository;
    }

    public Team getTeamByName(String name){
        List<Team> allTeams = (List<Team>) teamRepository.findAll();
        for (Team t: allTeams
             ) {
            if(t.getName().equals(name)){
                return t;
            }
        }
        return null;
    }
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
    public boolean deleteTeam(String name){
        Query q = em.createNamedQuery("Team.findByName");
        q.setParameter(1, name);
        Team teamByName = (Team) q.getSingleResult();
        teamRepository.delete(teamByName);
        return teamRepository.findById(teamByName.getId()).isPresent();
    }
    public List<Team> getAllTeams(){
        return (List<Team>) (teamRepository.findAll());
    }
}
