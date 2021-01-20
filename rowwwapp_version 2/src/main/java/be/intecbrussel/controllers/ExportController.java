package be.intecbrussel.controllers;

import be.intecbrussel.excelFilesExporters.ExcelFileExporterRegistration;
import be.intecbrussel.models.competition.Compensation;
import be.intecbrussel.models.competition.Competition;
import be.intecbrussel.models.competition.Race;
import be.intecbrussel.models.registration.Rower;
import be.intecbrussel.models.registration.ScheduledRace;
import be.intecbrussel.models.registration.Team;
import be.intecbrussel.service.competitionServices.ExportServiceCompetition;
import be.intecbrussel.service.registrationServices.ExportServiceRegistration;
import be.intecbrussel.excelFilesExporters.ExcelFileExporterCompetition;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
public class ExportController {
    private final ExportServiceCompetition serviceCompetition;
    private final ExportServiceRegistration serviceRegistration;

    @Autowired
    public ExportController(ExportServiceCompetition serviceCompetition,
                            ExportServiceRegistration serviceRegistration  ) {
        this.serviceCompetition = serviceCompetition;
        this.serviceRegistration = serviceRegistration;
    }
    ////////////////////////////Competition Part/////////////////////////////////////////
    @GetMapping("/rowwwapp/competition/results/rowwwapp_competition_data.csv")
    public void exportCSVCompetition(HttpServletResponse response) throws Exception{
        String filename = "rowwwapp_competition_data.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename +"\"");

        StatefulBeanToCsv<Competition> writer = new StatefulBeanToCsvBuilder<Competition>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

            writer.write(serviceCompetition.getCompetitionList());

    }
    @GetMapping("/rowwwapp/competition/results/rowwwapp_competition_data.xlsx")
    public void exportXLSCompetition(HttpServletResponse response) throws Exception{
        String filename = "rowwwapp_competition_data.xlsx";
        List<Competition> allCompetitions =
        serviceCompetition.getCompetitionList();
        response.setContentType("application/octet-stream");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename +"\"");
        ByteArrayInputStream stream = ExcelFileExporterCompetition.competitionsToExcelFile(
                allCompetitions);
        IOUtils.copy(stream,response.getOutputStream());

    }
    @GetMapping("/rowwwapp/competition/results/rowwwapp_race_data.csv")
    public void exportCSVRace(HttpServletResponse response) throws Exception{
        String filename = "rowwwapp_race_data.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename +"\"");

        StatefulBeanToCsv<Race> writer = new StatefulBeanToCsvBuilder<Race>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        writer.write(serviceCompetition.getRacesList());
    }
    @GetMapping("/rowwwapp/competition/results/rowwwapp_race_data.xlsx")
    public void exportXLSRace(HttpServletResponse response) throws Exception{
        String filename = "rowwwapp_race_data.xlsx";

        response.setContentType("application/octet-stream");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename +"\"");

        ByteArrayInputStream stream = ExcelFileExporterCompetition.racesToExcelFile(
                serviceCompetition.getRacesList());
        IOUtils.copy(stream,response.getOutputStream());

    }
    @GetMapping("/rowwwapp/competition/results/rowwwapp_compensation_data.csv")
    public void exportCSVCompensation(HttpServletResponse response) throws Exception{
        String filename = "rowwwapp_compensation_data.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename +"\"");

        StatefulBeanToCsv<Compensation> writer = new StatefulBeanToCsvBuilder<Compensation>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        writer.write(serviceCompetition.getCompensationsList());
    }
    @GetMapping("/rowwwapp/competition/results/rowwwapp_compensation_data.xlsx")
    public void exportXLSCompensation(HttpServletResponse response) throws Exception{
        String filename = "rowwwapp_compensation_data.xlsx";

        response.setContentType("application/octet-stream");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename +"\"");

        ByteArrayInputStream stream = ExcelFileExporterCompetition.compensationsToExcelFile(
                serviceCompetition.getCompensationsList());
        IOUtils.copy(stream,response.getOutputStream());

    }
    ////////////////////////////Registration Part/////////////////////////////////////////
    @GetMapping("/rowwwapp/registration/results/rowwwapp_rower_data.csv")
    public void exportCSVRower(HttpServletResponse response) throws Exception {
        String filename = "rowwwapp_rower_data.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename +"\"");
        StatefulBeanToCsv<Rower> writer = new StatefulBeanToCsvBuilder<Rower>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();
        writer.write(serviceRegistration.getRowersList());

    }
    @GetMapping("/rowwwapp/registration/results/rowwwapp_rower_data.xlsx")
    public void exportXLSRower(HttpServletResponse response) throws Exception {
        String filename = "rowwwapp_rower_data.xlsx";

        response.setContentType("application/octet-stream");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename +"\"");

        ByteArrayInputStream stream = ExcelFileExporterRegistration.rowersToExcelFile(
                serviceRegistration.getRowersList());
        IOUtils.copy(stream,response.getOutputStream());
    }
    @GetMapping("/rowwwapp/registration/results/rowwwapp_team_data.csv")
    public void exportCSVTeam(HttpServletResponse response) throws Exception {
        String filename = "rowwwapp_team_data.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename +"\"");
        StatefulBeanToCsv<Team> writer = new StatefulBeanToCsvBuilder<Team>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();
        writer.write(serviceRegistration.getTeamsList());
    }
    @GetMapping("/rowwwapp/registration/results/rowwwapp_team_data.xlsx")
    public void exportXLSTeam(HttpServletResponse response) throws Exception {
        String filename = "rowwwapp_team_data.xlsx";

        response.setContentType("application/octet-stream");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename +"\"");

        ByteArrayInputStream stream = ExcelFileExporterRegistration.teamsToExcelFile(
                serviceRegistration.getTeamsList());
        IOUtils.copy(stream,response.getOutputStream());
    }
    @GetMapping("/rowwwapp/registration/results/rowwwapp_scheduledRace_data.csv")
    public void exportCSVScheduledRace(HttpServletResponse response) throws Exception {
        String filename = "rowwwapp_scheduledRace_data.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename +"\"");
        StatefulBeanToCsv<ScheduledRace> writer = new StatefulBeanToCsvBuilder<ScheduledRace>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();
        writer.write(serviceRegistration.getScheduledRacesList());
    }
    @GetMapping("/rowwwapp/registration/results/rowwwapp_scheduledRace_data.xlsx")
    public void exportXLSScheduledRace(HttpServletResponse response) throws Exception {
        String filename = "rowwwapp_scheduledRace_data.xlsx";

        response.setContentType("application/octet-stream");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename +"\"");

        ByteArrayInputStream stream = ExcelFileExporterRegistration.scheduledRaceToExcelFile(
                serviceRegistration.getScheduledRacesList());
        IOUtils.copy(stream,response.getOutputStream());
    }
}
