package be.intecbrussel.views;

import be.intecbrussel.models.registration.Team;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PDFView extends AbstractPDFView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"rowwwapp_data.pdf\"");
        //document generalities
        document.addCreationDate();
        document.addAuthor("Royal 1865");
        document.addTitle("Liste des équipes participantes");
        //datas
        List<Team> teams = (List<Team>) model.get("teams");
        StringBuilder subject= new StringBuilder();
        for (Team t: teams
             ) {
            subject.append(String.format("Id: %s",t.getId()))
                    .append("\n").append(String.format("Nom: %s",t.getName()))
                    .append("\n").append(String.format("Taille de l'équipe: %s",t.getSizeOfCrew()))
                    .append("\n").append(String.format("Membres: %s",t.getListCrewMembers(t.getCrew())))
                    .append("\n").append(String.format("Barreur: %s %s", t.getCox().getFirstName(), t.getCox().getLastName()))
                    .append("\n").append(String.format("Nage: %s %s", t.getStroke().getFirstName(), t.getStroke().getLastName()))
                    .append("\n").append(String.format("Handicap: %s",t.getTeamHandicap()))
                    .append("\n").append("_".repeat(10));
        }
        document.addSubject(subject.toString());
    }
}
