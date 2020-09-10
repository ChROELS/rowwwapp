package be.intecbrussel.views;

import be.intecbrussel.models.competition.Competition;
import be.intecbrussel.models.competition.Race;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class CsvViewCompetition extends AbstractCsvView {
    @Override
    protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"rowwwapp_competition_data.csv\"");
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        List<Competition> competitionsList = (List<Competition>) model.get("competition");
        String[] header = {"Id","Nom","Description","Lieu","Inscription","Contacts pour l'inscription","Coût",
        "Date limite d'inscription","Date du tirage au sort", "Lieu du tirage au sort", "Adresse du tirage au sort",
        "Date limite des forfaits", "Infos sur les forfaits","Contacts pour les forfaits", "Règles complémentaires",
        "Compensation par genre: homme", "Compensation par genre: femme", "Compensations par catégories"};
        csvWriter.writeHeader(header);
        if(competitionsList!=null) {
            for (Competition c : competitionsList) {
                if (c != null)
                    csvWriter.write(c, header);
            }
        }
        //////////////////////////////////////////////////////RACE SHEET////////////////////////////////////////////////////////////
        List<Race> racesList = (List<Race>) model.get("races");
        String[] headerRace = {"Id","Numéro","Heure de départ","Nom","Distance","Temps maximal","Type de course",
                "Type de course sur-mesure","Expérience admise","Envergure","Catégorie admise","Bateau admis","Description"};
        csvWriter.writeHeader(header);
        if(racesList!=null) {
            for (Race r : racesList) {
                if (r != null)
                    csvWriter.write(r, header);
            }
        }
        //Closing writer
        csvWriter.close();
    }
}
