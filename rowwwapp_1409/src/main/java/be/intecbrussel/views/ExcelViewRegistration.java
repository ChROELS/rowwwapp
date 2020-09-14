package be.intecbrussel.views;

import be.intecbrussel.models.registration.Rower;
import be.intecbrussel.models.registration.Team;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ExcelViewRegistration extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // change the file name
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"rowwwapp_registration_data.xls\"");

        List<Team> teams = (List<Team>) map.get("teams");
        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Teams Detail");
        sheet.setDefaultColumnWidth(30);
        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_40_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        style.setFont(font);
        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Id");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Nom");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Type de bateau");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Taille de l'équipe");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Course sélectionnée");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("Membres de l'équipe");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("Barreur");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Nage");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("Handicap");
        header.getCell(8).setCellStyle(style);

        int rowCount = 1;
        if(teams!=null) {
            for (Team t : teams) {
                Row teamRow = sheet.createRow(rowCount++);
                teamRow.createCell(0).setCellValue(t.getId());
                teamRow.createCell(1).setCellValue(t.getName());
                teamRow.createCell(2).setCellValue(t.getType().name());
                teamRow.createCell(3).setCellValue(t.getSizeOfCrew());
                teamRow.createCell(4).setCellValue(t.getSizeOfCrew());
                teamRow.createCell(5).setCellValue(t.getListCrewMembers(t.getCrew()));
                teamRow.createCell(6).setCellValue(String.format("%s %s", t.getCox().getFirstName(), t.getCox().getLastName()));
                teamRow.createCell(7).setCellValue(String.format("%s %s", t.getStroke().getFirstName(), t.getStroke().getLastName()));
                teamRow.createCell(8).setCellValue(t.getTeamHandicap());
            }
        }
        //////////////////////////////////////////////////////ROWER SHEET////////////////////////////////////////////////////////////
        List<Rower> rowers = (List<Rower>) map.get("rowers");
        // create excel xls sheet
        Sheet sheetRower = workbook.createSheet("Rowers Detail");
        sheet.setDefaultColumnWidth(30);
        // create style for header cells
        CellStyle styleRower = workbook.createCellStyle();
        Font fontRower = workbook.createFont();
        fontRower.setFontName("Arial");
        styleRower.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        styleRower.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        fontRower.setBold(true);
        fontRower.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        styleRower.setFont(font);
        // create header row
        Row headerRower = sheetRower.createRow(0);
        headerRower.createCell(0).setCellValue("Id");
        headerRower.getCell(0).setCellStyle(style);
        headerRower.createCell(1).setCellValue("Nom");
        headerRower.getCell(1).setCellStyle(style);
        headerRower.createCell(2).setCellValue("Prénom");
        headerRower.getCell(2).setCellStyle(style);
        headerRower.createCell(3).setCellValue("Nationalité");
        headerRower.getCell(3).setCellStyle(style);
        headerRower.createCell(4).setCellValue("Genre");
        headerRower.getCell(4).setCellStyle(style);
        headerRower.createCell(5).setCellValue("Date de naissance");
        headerRower.getCell(5).setCellStyle(style);
        headerRower.createCell(6).setCellValue("Club");
        headerRower.getCell(6).setCellStyle(style);
        headerRower.createCell(7).setCellValue("Numéro de license");
        headerRower.getCell(7).setCellStyle(style);
        headerRower.createCell(8).setCellValue("Handicap physique");
        headerRower.getCell(8).setCellStyle(style);
        headerRower.createCell(9).setCellValue("Expérience");
        headerRower.getCell(9).setCellStyle(style);
        headerRower.createCell(10).setCellValue("Catégorie");
        headerRower.getCell(10).setCellStyle(style);
        headerRower.createCell(11).setCellValue("Age");
        headerRower.getCell(11).setCellStyle(style);
        headerRower.createCell(12).setCellValue("Handicap");
        headerRower.getCell(12).setCellStyle(style);

        int rowCountRower = 1;
        if(rowers!=null) {
            for (Rower r : rowers) {
                Row teamRow = sheetRower.createRow(rowCount++);
                teamRow.createCell(0).setCellValue(r.getId());
                teamRow.createCell(1).setCellValue(r.getLastName());
                teamRow.createCell(2).setCellValue(r.getFirstName());
                teamRow.createCell(3).setCellValue(r.getNationality());
                teamRow.createCell(4).setCellValue(r.getGender().name());
                teamRow.createCell(5).setCellValue(r.getBirthDate());
                teamRow.createCell(6).setCellValue(r.getClub());
                teamRow.createCell(7).setCellValue(r.getLicenceNumber());
                teamRow.createCell(8).setCellValue(r.getDisability().name());
                teamRow.createCell(9).setCellValue(r.getRaceExperience().name());
                teamRow.createCell(10).setCellValue(r.getCategory().name());
                teamRow.createCell(11).setCellValue(r.getAge());
                teamRow.createCell(12).setCellValue(r.getRowerHandicap());
            }
        }
    }
}
