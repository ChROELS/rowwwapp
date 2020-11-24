package be.intecbrussel.excelFilesExporters;

import be.intecbrussel.models.competition.Compensation;
import be.intecbrussel.models.competition.Competition;
import be.intecbrussel.models.competition.Race;
import be.intecbrussel.models.registration.Rower;
import be.intecbrussel.models.registration.ScheduledRace;
import be.intecbrussel.models.registration.Team;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelFileExporterRegistration {
    //To export all data about teams
    public static ByteArrayInputStream teamsToExcelFile(List<Team> teams) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Teams Detail");
            for (int i = 0; i <= 8; i++) {
                sheet.autoSizeColumn(i);
            }
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
                    teamRow.createCell(4).setCellValue("non repris");
                    teamRow.createCell(5).setCellValue(t.getListCrewMembers(t.getCrew()));
                    if(t.getCox()!=null) {
                        teamRow.createCell(6).setCellValue(String.format("%s %s", t.getCox().getFirstName(), t.getCox().getLastName()));
                    }else {
                        teamRow.createCell(6).setCellValue("-");
                    }
                    if(t.getStroke()!=null) {
                        teamRow.createCell(7).setCellValue(String.format("%s %s", t.getStroke().getFirstName(), t.getStroke().getLastName()));
                    }else {
                        teamRow.createCell(7).setCellValue("-");
                    }
                    teamRow.createCell(8).setCellValue(t.getTeamHandicap());
                }
            }
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }

    //To export all data about rowers
    public static ByteArrayInputStream rowersToExcelFile(List<Rower> rowers) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheetRower = workbook.createSheet("Rowers Detail");
            for (int i = 0; i <= 12; i++) {
                sheetRower.autoSizeColumn(i);
            }
            // create style for header cells
            CellStyle styleRower = workbook.createCellStyle();
            Font fontRower = workbook.createFont();
            fontRower.setFontName("Arial");
            styleRower.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
            styleRower.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            fontRower.setBold(true);
            fontRower.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
            styleRower.setFont(fontRower);
            // create header row
            Row headerRower = sheetRower.createRow(0);
            headerRower.createCell(0).setCellValue("Id");
            headerRower.getCell(0).setCellStyle(styleRower);
            headerRower.createCell(1).setCellValue("Nom");
            headerRower.getCell(1).setCellStyle(styleRower);
            headerRower.createCell(2).setCellValue("Prénom");
            headerRower.getCell(2).setCellStyle(styleRower);
            headerRower.createCell(3).setCellValue("Nationalité");
            headerRower.getCell(3).setCellStyle(styleRower);
            headerRower.createCell(4).setCellValue("Genre");
            headerRower.getCell(4).setCellStyle(styleRower);
            headerRower.createCell(5).setCellValue("Date de naissance");
            headerRower.getCell(5).setCellStyle(styleRower);
            headerRower.createCell(6).setCellValue("Club");
            headerRower.getCell(6).setCellStyle(styleRower);
            headerRower.createCell(7).setCellValue("Numéro de license");
            headerRower.getCell(7).setCellStyle(styleRower);
            headerRower.createCell(8).setCellValue("Handicap physique");
            headerRower.getCell(8).setCellStyle(styleRower);
            headerRower.createCell(9).setCellValue("Expérience");
            headerRower.getCell(9).setCellStyle(styleRower);
            headerRower.createCell(10).setCellValue("Catégorie");
            headerRower.getCell(10).setCellStyle(styleRower);
            headerRower.createCell(11).setCellValue("Age");
            headerRower.getCell(11).setCellStyle(styleRower);
            headerRower.createCell(12).setCellValue("Handicap");
            headerRower.getCell(12).setCellStyle(styleRower);

            int rowCountRower = 1;
            if(rowers!=null) {
                for (Rower r : rowers) {
                    Row teamRow = sheetRower.createRow(rowCountRower++);
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
                    if(r.getCategory()!=null)
                        teamRow.createCell(10).setCellValue(r.getCategory().name());
                    else
                        teamRow.createCell(10).setCellValue("-");
                    teamRow.createCell(11).setCellValue(r.getAge());
                    teamRow.createCell(12).setCellValue(r.getRowerHandicap());
                }
            }
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }

    //To export all data about the scheduled race to register to
    public static ByteArrayInputStream scheduledRaceToExcelFile(List<ScheduledRace> scheduledRaces) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheetScheduledRace = workbook.createSheet("Scheduled Races Detail");
            for (int i = 0; i <= 7; i++) {
                sheetScheduledRace.autoSizeColumn(i);
            }
            // create style for header cells
            CellStyle styleRace = workbook.createCellStyle();
            Font fontRace = workbook.createFont();
            fontRace.setFontName("Arial");
            styleRace.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
            styleRace.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            fontRace.setBold(true);
            fontRace.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
            styleRace.setFont(fontRace);
            // create header row
            Row headerRace = sheetScheduledRace.createRow(0);
            headerRace.createCell(0).setCellValue("Id");
            headerRace.getCell(0).setCellStyle(styleRace);
            headerRace.createCell(1).setCellValue("Numéro");
            headerRace.getCell(1).setCellStyle(styleRace);
            headerRace.createCell(2).setCellValue("Lieu");
            headerRace.getCell(2).setCellStyle(styleRace);
            headerRace.createCell(3).setCellValue("Date");
            headerRace.getCell(3).setCellStyle(styleRace);
            headerRace.createCell(4).setCellValue("Type de course répertoriée");
            headerRace.getCell(4).setCellStyle(styleRace);
            headerRace.createCell(5).setCellValue("Course sur-mesure si non-répertoriée");
            headerRace.getCell(5).setCellStyle(styleRace);
            headerRace.createCell(6).setCellValue("Handicap (coefficient) selon la catégorie");
            headerRace.getCell(6).setCellStyle(styleRace);
            headerRace.createCell(7).setCellValue("Handicap (coefficient) selon le genre");
            headerRace.getCell(7).setCellStyle(styleRace);

            int rowCountRace = 1;
            if(scheduledRaces!=null) {
                for (ScheduledRace s : scheduledRaces) {
                    Row raceRow = sheetScheduledRace.createRow(rowCountRace++);
                    raceRow.createCell(0).setCellValue(s.getId());
                    raceRow.createCell(1).setCellValue(s.getNumber());
                    raceRow.createCell(2).setCellValue(s.getLocation());
                    raceRow.createCell(3).setCellValue(s.getDate());
                    raceRow.createCell(4).setCellValue(s.getRaceType().name());
                    raceRow.createCell(5).setCellValue(s.getCustomedRace());
                    raceRow.createCell(6).setCellValue(s.getCoefficientCategory());
                    raceRow.createCell(7).setCellValue(s.getCoefficientGender());
                }
            }
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }
}
