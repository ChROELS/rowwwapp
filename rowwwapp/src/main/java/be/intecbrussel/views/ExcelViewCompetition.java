package be.intecbrussel.views;

import be.intecbrussel.models.competition.Compensation;
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
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
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
        //Tell what values to place under each header on each rows
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
                cRow.createCell(7).setCellValue(c.getRegistrationCost());
                cRow.createCell(8).setCellValue(c.getRegistrationLimit());
                cRow.createCell(9).setCellValue(c.getLotteryDate());
                cRow.createCell(10).setCellValue(c.getLotteryRules());
                cRow.createCell(11).setCellValue(c.getLotteryDate());
                cRow.createCell(12).setCellValue(c.getForfeitLimit());
                cRow.createCell(13).setCellValue(c.getForfeitRules());
                cRow.createCell(14).setCellValue(c.getForfeitContact());
                cRow.createCell(15).setCellValue(c.getComplementaryRules());
            }
        }
        //////////////////////////////////////////////////////RACE SHEET////////////////////////////////////////////////////////////
        List<Race> races = (List<Race>) map.get("races");
        // create excel xls sheet
        Sheet sheetRace = workbook.createSheet("Races Detail");
        sheetRace.setDefaultColumnWidth(30);
        // create style for header cells
        CellStyle styleRace = workbook.createCellStyle();
        Font fontRace = workbook.createFont();
        fontRace.setFontName("Arial");
        styleRace.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        styleRace.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        fontRace.setBold(true);
        fontRace.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        styleRace.setFont(font);
        // create header row
        Row headerRace = sheetRace.createRow(0);
        headerRace.createCell(0).setCellValue("Id");
        headerRace.getCell(0).setCellStyle(style);
        headerRace.createCell(1).setCellValue("Numéro");
        headerRace.getCell(1).setCellStyle(style);
        headerRace.createCell(2).setCellValue("Heure de départ");
        headerRace.getCell(2).setCellStyle(style);
        headerRace.createCell(3).setCellValue("Nom");
        headerRace.getCell(3).setCellStyle(style);
        headerRace.createCell(4).setCellValue("Distance");
        headerRace.getCell(4).setCellStyle(style);
        headerRace.createCell(5).setCellValue("Temps maximal");
        headerRace.getCell(5).setCellStyle(style);
        headerRace.createCell(6).setCellValue("Type de course");
        headerRace.getCell(6).setCellStyle(style);
        headerRace.createCell(7).setCellValue("Course sur-mesure");
        headerRace.getCell(7).setCellStyle(style);
        headerRace.createCell(8).setCellValue("Expérience admise");
        headerRace.getCell(8).setCellStyle(style);
        headerRace.createCell(9).setCellValue("Envergure");
        headerRace.getCell(9).setCellStyle(style);
        headerRace.createCell(10).setCellValue("Catégories admises");
        headerRace.getCell(10).setCellStyle(style);
        headerRace.createCell(11).setCellValue("Bateaux admis");
        headerRace.getCell(11).setCellStyle(style);
        headerRace.createCell(12).setCellValue("Description");
        headerRace.getCell(12).setCellStyle(style);

        int rowCountRace = 1;
        if(races!=null) {
            for (Race r : races) {
                Row cRace = sheetRace.createRow(rowCountRace++);
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
        //////////////////////////////////////////////////////RACE SHEET////////////////////////////////////////////////////////////
        List<Compensation> compensations = (List<Compensation>) map.get("compensations");
        // create excel xls sheet
        Sheet sheetComp = workbook.createSheet("Compensations Detail");
        sheetComp.setDefaultColumnWidth(30);
        // create style for header cells
        CellStyle styleComp = workbook.createCellStyle();
        Font fontComp = workbook.createFont();
        fontComp.setFontName("Arial");
        styleComp.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        styleComp.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        fontComp.setBold(true);
        fontComp.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        styleComp.setFont(font);
        // create header row
        Row headerComp = sheetComp.createRow(0);
        headerComp.createCell(0).setCellValue("Id");
        headerComp.getCell(0).setCellStyle(style);
        headerComp.createCell(1).setCellValue("Numéro");
        headerComp.getCell(1).setCellStyle(style);
        headerComp.createCell(2).setCellValue("Heure de départ");
        headerComp.getCell(2).setCellStyle(style);
        headerComp.createCell(3).setCellValue("Nom");
        headerComp.getCell(3).setCellStyle(style);
        headerComp.createCell(4).setCellValue("Distance");
        headerComp.getCell(4).setCellStyle(style);
        headerComp.createCell(5).setCellValue("Temps maximal");
        headerComp.getCell(5).setCellStyle(style);
        headerComp.createCell(6).setCellValue("Type de course");
        headerComp.getCell(6).setCellStyle(style);
        headerComp.createCell(7).setCellValue("Course sur-mesure");
        headerComp.getCell(7).setCellStyle(style);
        headerComp.createCell(8).setCellValue("Expérience admise");
        headerComp.getCell(8).setCellStyle(style);
        headerComp.createCell(9).setCellValue("Envergure");
        headerComp.getCell(9).setCellStyle(style);
        headerComp.createCell(10).setCellValue("Catégories admises");
        headerComp.getCell(10).setCellStyle(style);
        headerComp.createCell(11).setCellValue("Bateaux admis");
        headerComp.getCell(11).setCellStyle(style);
        headerComp.createCell(12).setCellValue("Description");
        headerComp.getCell(12).setCellStyle(style);

        int rowCountComp = 1;
        if(compensations!=null) {
            for (Compensation comp : compensations) {
                Row rowComp = sheetComp.createRow(rowCountComp++);
                rowComp.createCell(0).setCellValue(comp.getId());
                rowComp.createCell(1).setCellValue(comp.getCompensationMale());
                rowComp.createCell(2).setCellValue(comp.getCompensationFemale());
                rowComp.createCell(3).setCellValue(comp.getPR3());
                rowComp.createCell(4).setCellValue(comp.getPR2());
                rowComp.createCell(5).setCellValue(comp.getPR1());
                rowComp.createCell(6).setCellValue(comp.getJ10());
                rowComp.createCell(7).setCellValue(comp.getJ12());
                rowComp.createCell(8).setCellValue(comp.getJ14());
                rowComp.createCell(9).setCellValue(comp.getJ16());
                rowComp.createCell(10).setCellValue(comp.getJ18());
                rowComp.createCell(11).setCellValue(comp.getU23());
                rowComp.createCell(12).setCellValue(comp.getS_A());
                rowComp.createCell(13).setCellValue(comp.getS_B());
                rowComp.createCell(14).setCellValue(comp.getA());
                rowComp.createCell(15).setCellValue(comp.getB());
                rowComp.createCell(16).setCellValue(comp.getC());
                rowComp.createCell(17).setCellValue(comp.getD());
                rowComp.createCell(18).setCellValue(comp.getE());
                rowComp.createCell(19).setCellValue(comp.getF());
                rowComp.createCell(20).setCellValue(comp.getG());
                rowComp.createCell(21).setCellValue(comp.getH());
                rowComp.createCell(22).setCellValue(comp.getI());
                rowComp.createCell(23).setCellValue(comp.getJ());
                rowComp.createCell(24).setCellValue(comp.getK());
                rowComp.createCell(25).setCellValue(comp.getL());
                rowComp.createCell(26).setCellValue(comp.getM());
                rowComp.createCell(27).setCellValue(comp.getCompetition().getName());
            }
        }
    }
}
