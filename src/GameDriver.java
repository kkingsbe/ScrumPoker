import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class GameDriver {

    // JDBC driver name and database URL
    //static final String DB_URL = "jdbc:sqlite:home/databases/";
    static final String DB_URL = "jdbc:sqlite:C:\\users\\sking\\documents\\games.db";

    public static void setupDb() throws ClassNotFoundException {
        createIfDoesntExist();
    }
    public static void createIfDoesntExist()
    {
        System.out.println("Checking to see if games.db exists at the target location...");
        createDb();
        System.out.println("games.db successfully created!");
    }
    public static void createDb() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Creating games lookup table...");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static boolean newGame(String name, String description, String sequenceType)
    {
        //None of the fields can contain spaces, underscores, hyphens, or any special characters
        System.out.println("Checking if game name exists...");
        ArrayList<String> games = getGames();
        boolean success = true;

        if(games.contains(name))
        {
            success = false;
            System.out.println("Game name already exists");
        }

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS " + name + "(\n"
                + "	playerName text PRIMARY KEY,\n"
                + "	vote text NOT NULL,\n"
                + "	capacity real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return success;
    }
    public static ArrayList<String> getGames()
    {
        ArrayList<String> games = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                //System.out.println(rs.getString(3));
                games.add(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }
    /*
    public static int newGame(String name, String description)
    {

    }
    public static void deleteGame(int id)
    {

    }
    */
}