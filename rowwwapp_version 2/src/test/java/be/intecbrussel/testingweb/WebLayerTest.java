package be.intecbrussel.testingweb;

import be.intecbrussel.controllers.AccessController;
import be.intecbrussel.service.competitionServices.CompensationService;
import be.intecbrussel.service.competitionServices.CompetitionService;
import be.intecbrussel.service.competitionServices.ExportServiceCompetition;
import be.intecbrussel.service.competitionServices.RaceService;
import be.intecbrussel.service.registrationServices.ExportServiceRegistration;
import be.intecbrussel.service.registrationServices.RowerService;
import be.intecbrussel.service.registrationServices.ScheduledRaceService;
import be.intecbrussel.service.registrationServices.TeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//We still don't start the server but we narrow the tests to only the web layer
@WebMvcTest()
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    //My application contains several services that have to be mocked as well
    //in order to test the controllers (since their constructors take services as parameters)
    @MockBean
    private CompetitionService competitionService;
    @MockBean
    private RaceService raceService;
    @MockBean
    private CompensationService compensationService;
    @MockBean
    private RowerService rowerService;
    @MockBean
    private TeamService teamService;
    @MockBean
    private ScheduledRaceService scheduledRaceService;
    @MockBean
    private ExportServiceRegistration exportServiceRegistration;
    @MockBean
    private ExportServiceCompetition exportServiceCompetition;


    @Test
    public void homeShouldBeReturned() throws Exception{
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Bienvenue")));

    }
    @Test
    public void competitionServiceGetsAllAsList() throws Exception{
        when(competitionService.getAllCompetitionDay()).thenReturn(new ArrayList<>());
    }
    @Test
    public void raceServiceGetsAllAsList() throws Exception{
        when(raceService.getAllRace()).thenReturn(new ArrayList<>());
    }
    @Test
    public void compensationServiceGetsAllAsList() throws Exception{
        when(compensationService.getAllCompensations()).thenReturn(new ArrayList<>());
    }
    @Test
    public void rowerServiceGetsAllAsList() throws Exception{
        when(rowerService.getAllRowers()).thenReturn(new ArrayList<>());
    }
    @Test
    public void teamServiceGetsAllAsList() throws Exception{
        when(teamService.getAllTeams()).thenReturn(new ArrayList<>());
    }
    @Test
    public void scheduledRaceServiceGetsAllAsList() throws Exception{
        when(scheduledRaceService.getAllScheduledRaces()).thenReturn(new ArrayList<>());
    }
}
