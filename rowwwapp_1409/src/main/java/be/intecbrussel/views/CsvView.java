package be.intecbrussel.views;

import be.intecbrussel.models.registration.Rower;
import be.intecbrussel.models.registration.Team;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class CsvView extends AbstractCsvView {
    @Override
    protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"rowwwapp_registration_data.csv\"");
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        List<Team> teams = (List<Team>) model.get("team");
        String[] header = {"Id","Nom","Taille de l'équipe","Membres","Barreur","Nage","Handicap"};
        csvWriter.writeHeader(header);
        if(teams!= null) {
            for (Team t : teams) {
                if (t != null) {
                    csvWriter.write(t, header);
                }
            }
        }
        //////////////////////////////////////////////////////ROWER SHEET////////////////////////////////////////////////////////////
        List<Rower> rowers = (List<Rower>) model.get("rowers");
        String[] headerRower = {"Id","Nom","Prénom","Nationalité","Genre","Date de naissance","Club",
        "Numéro de license","Handicap physique","Expérience","Catégorie","Age","Handicap"};
        csvWriter.writeHeader(header);
        if(rowers!=null) {
            for (Rower r : rowers) {
                if (r != null)
                    csvWriter.write(r, header);
            }
        }
        //Closing writer
        csvWriter.close();
    }
}
