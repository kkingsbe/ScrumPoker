import java.io.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DataLogger {
    private static final String fileLoc = "/media/ScrumPokerAnalytics/analytics.csv";
    Analytics analytics = new Analytics();

    public DataLogger() throws IOException {
        File file = new File(fileLoc);
        boolean exists = file.exists();

        if (!exists) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLoc));
            writer.write("Active sessions, Current players, Sessions this week, Players this week, Sessions this month, Players this month, Sessions this year, Players this year"); //Prints headers to the csv file
            writer.close();
        } else //Parses the csv file into an analytics object if it already exists
        {
            try (
                    Reader reader = Files.newBufferedReader(Paths.get(fileLoc));
                    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            ) {
                CSVRecord csvRecord = csvParser.getRecords().get(1);
                // Accessing Values by Column Index
                analytics.setActiveSessions(Integer.parseInt(csvRecord.get(1)));
                analytics.setCurrentPlayers(Integer.parseInt(csvRecord.get(1)));
                analytics.setWeeklySessions(Integer.parseInt(csvRecord.get(2)));
                analytics.setWeeklyPlayers(Integer.parseInt(csvRecord.get(3)));
                analytics.setMonthlySessions(Integer.parseInt(csvRecord.get(4)));
                analytics.setMonthlyPlayers(Integer.parseInt(csvRecord.get(5)));
                analytics.setYearlySessions(Integer.parseInt(csvRecord.get(6)));
                analytics.setYearlyPlayers(Integer.parseInt(csvRecord.get(7)));
            }
        }
    }
    public void newSession()
    {
        analytics.setActiveSessions(analytics.getActiveSessions() + 1);
        analytics.setWeeklySessions(analytics.getWeeklySessions() + 1);
        analytics.setMonthlySessions(analytics.getMonthlySessions() + 1);
        analytics.setYearlySessions(analytics.getYearlySessions() + 1);
        updateFile();
    }
    public void deleteSession()
    {
        analytics.setActiveSessions(analytics.getActiveSessions() - 1);
        updateFile();
    }
    public void newPlayer()
    {
        analytics.setCurrentPlayers(analytics.getCurrentPlayers() + 1);
        analytics.setWeeklyPlayers(analytics.getWeeklyPlayers() + 1);
        analytics.setMonthlyPlayers(analytics.getMonthlyPlayers() + 1);
        analytics.setYearlyPlayers(analytics.getYearlyPlayers() + 1);
        updateFile();
    }
    public void deleteActivePlayer()
    {
        analytics.setCurrentPlayers(analytics.getCurrentPlayers() - 1);
        updateFile();
    }
    public void updateFile()
    {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileLoc));
            writer.write("Active sessions, Current players, Sessions this week, Players this week, Sessions this month, Players this month, Sessions this year, Players this year\n");
            writer.write(analytics.getActiveSessions() + "," + analytics.getCurrentPlayers() + "," + analytics.getWeeklySessions() + "," + analytics.getWeeklyPlayers() + "," + analytics.getMonthlySessions() + "," + analytics.getMonthlyPlayers() + "," + analytics.getYearlySessions() + "," + analytics.getYearlyPlayers());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
