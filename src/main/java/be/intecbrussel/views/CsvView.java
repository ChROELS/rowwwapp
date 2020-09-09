package be.intecbrussel.views;

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
        response.setHeader("Content-Disposition", "attachment; filename=\"rowwwapp_data.csv\"");

        List<Team> teams = (List<Team>) model.get("teams");
        String[] header = {"Id","Nom","Taille de l'équipe","Membres","Barreur","Nage","Handicap"};
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        csvWriter.writeHeader(header);

        for(Team t : teams){
            csvWriter.write(t, header);
        }


        csvWriter.close();
    }
}
