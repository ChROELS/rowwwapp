package be.intecbrussel.views;

import be.intecbrussel.models.competition.Competition;
import be.intecbrussel.models.competition.Race;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Map;

public class ExcelViewCompetition extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // change the file name
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"rowwwapp_competition_data.xls\"");

        List<Competition> competitions = (List<Competition>) map.get("competitions");
        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Competitions Detail");
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
        header.createCell(2).setCellValue("Description");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Lieu");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Date");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("Inscription");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("Contacts pour les inscriptions");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Coût par personne");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("Date Limite des inscriptions");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("Date du tirage au sort");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("Infos sur le tirage au sort");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("Lieu du tirage au sort");
        header.getCell(11).setCellStyle(style);
        header.createCell(12).setCellValue("Date limite pour les forfaits");
        header.getCell(12).setCellStyle(style);
        header.createCell(13).setCellValue("Infos sur les forfaits");
        header.getCell(13).setCellStyle(style);
        header.createCell(14).setCellValue("Adresse de contact pour les forfaits");
        header.getCell(14).setCellStyle(style);
        header.createCell(15).setCellValue("Règles complémentaires");
        header.getCell(15).setCellStyle(style);
        header.createCell(16).setCellValue("Compensation par genre: homme");
        header.getCell(16).setCellStyle(style);
        header.createCell(17).setCellValue("Compensation par genre: femme");
        header.getCell(17).setCellStyle(style);
        header.createCell(18).setCellValue("Compensation par catégorie");
        header.getCell(18).setCellStyle(style);

        int rowCount = 1;
        if(competitions!=null) {
            for (Competition c : competitions) {
                Row cRow = sheet.createRow(rowCount++);
                cRow.createCell(0).setCellValue(c.getId());
                cRow.createCell(1).setCellValue(c.getName());
                cRow.createCell(2).setCellValue(c.getDescription());
                cRow.createCell(3).setCellValue(c.getPlaceOfEvent());
                cRow.createCell(4).setCellValue(c.getDate());
                cRow.createCell(5).setCellValue(c.getRegistrationRules());
                cRow.createCell(6).setCellValue(c.getRegistrationContact());
                cRow.createCell(7).setCellValue(c.getRegistrationCost().floatValue());
                cRow.createCell(8).setCellValue(c.getRegistrationLimit());
                cRow.createCell(9).setCellValue(c.getLotteryDate());
                cRow.createCell(10).setCellValue(c.getLotteryRules());
                cRow.createCell(11).setCellValue(c.getLotteryDate());
                cRow.createCell(12).setCellValue(c.getForfeitLimit());
                cRow.createCell(13).setCellValue(c.getForfeitRules());
                cRow.createCell(14).setCellValue(c.getForfeitContact());
                cRow.createCell(15).setCellValue(c.getComplementaryRules());
                cRow.createCell(16).setCellValue(c.getCompensationMale());
                cRow.createCell(17).setCellValue(c.getCompensationFemale());
                cRow.createCell(18).setCellValue(c.listCompensationsCategories(c.getCompensationCategories()));
            }
        }
        //////////////////////////////////////////////////////RACE SHEET////////////////////////////////////////////////////////////
        List<Race> races = (List<Race>) map.get("races");
        // create excel xls sheet
        Sheet sheetRace = workbook.createSheet("Races Detail");
        sheet.setDefaultColumnWidth(30);
        // create style for header cells
        CellStyle styleRace = workbook.createCellStyle();
        Font fontRace = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        style.setFont(font);
        // create header row
        Row headerRace = sheet.createRow(0);
        header.createCell(0).setCellValue("Id");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Numéro");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Heure de départ");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Nom");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Distance");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("Temps maximal");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("Type de course");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Course sur-mesure");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("Expérience admise");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("Envergure");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("Catégories admises");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("Bateaux admis");
        header.getCell(11).setCellStyle(style);
        header.createCell(12).setCellValue("Description");
        header.getCell(12).setCellStyle(style);

        int rowCountRace = 1;
        if(races!=null) {
            for (Race r : races) {
                Row cRace = sheet.createRow(rowCountRace++);
                cRace.createCell(0).setCellValue(r.getId());
                cRace.createCell(1).setCellValue(r.getNumber());
                cRace.createCell(2).setCellValue(r.getStartingTime().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
                cRace.createCell(3).setCellValue(r.getName());
                cRace.createCell(4).setCellValue(r.getDistance());
                cRace.createCell(5).setCellValue(r.getMaxTime());
                cRace.createCell(6).setCellValue(r.getRacetype().name());
                cRace.createCell(7).setCellValue(r.getCustomedRace());
                cRace.createCell(8).setCellValue(r.getRaceExperience().name());
                cRace.createCell(9).setCellValue(r.getRaceImpact().name());
                cRace.createCell(10).setCellValue(r.getAdmissCategory().name());
                cRace.createCell(11).setCellValue(r.getAdmissRowingBoat().name());
                cRace.createCell(12).setCellValue(r.getDescription());
            }
        }
    }
}
