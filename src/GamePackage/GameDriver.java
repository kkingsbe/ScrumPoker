package GamePackage;

import java.sql.*;
import java.util.ArrayList;

public class GameDriver {
    //----------------------------------------------------------------------------
    //MAKE SURE YOU HAVE INSTALLED THE JDBC DRIVER FROM https://bitbucket.org/xerial/sqlite-jdbc/downloads/
    //----------------------------------------------------------------------------
    //static final String DB_URL = "jdbc:sqlite:home/databases/";
    static final String DB_URL = "jdbc:sqlite:C:\\users\\sking\\documents\\games.db"; //Database location

    public static void setupDb() {
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
                System.out.println("Creating games lookup table if it doesn't already exist...");
                String sql = "CREATE TABLE IF NOT EXISTS games(\n"
                        + "	name text PRIMARY KEY,\n"
                        + " id text NOT NULL, \n"
                        + "	description text NOT NULL,\n"
                        + " sequenceType text NOT NULL"
                        + ");";

                try (Statement stmt = conn.createStatement()) {
                    // create a new table
                    stmt.execute(sql);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Successfully created games lookup table!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static String newGame(String name, String description, String sequenceType)
    {
        //None of the fields can contain spaces, underscores, hyphens, or any special characters
        System.out.println("Checking if game name exists...");
        ArrayList<String> games = getGameNames();
        boolean success = true;

        if(games.contains(name))
        {
            success = false;
            System.out.println("Game name already exists :(");
            return "None";
        }

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS " + name + "(\n"
                + "	playerName text PRIMARY KEY,\n"
                + "	vote text NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "INSERT INTO games(name,id,description,sequenceType) VALUES(?,?,?,?)";

        String id = getFreeGameId();

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, id);
            pstmt.setString(3, description);
            pstmt.setString(4, sequenceType);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(success) System.out.println("Successfully created game: " + name + "!");
        return id;
    }
    public static ArrayList<String> getGameIds()
    {
        ArrayList<String> ids = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            DatabaseMetaData md = conn.getMetaData();
            String sql = "SELECT name, id FROM games";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                ids.add(rs.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
    public static String getFreeGameId()
    {
        ArrayList<String> ids = getGameIds();
        System.out.println("Searching for free game id...");
        int id = 0;
        while(ids.contains(Integer.toString(id)))
            id ++;
        System.out.println("Found free game id! " + id);
        return Integer.toString(id);
    }
    public static ArrayList<String> getGameNames()
    {
        ArrayList<String> names = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            DatabaseMetaData md = conn.getMetaData();
            String sql = "SELECT name, id FROM games";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                names.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }
    public static String getGameNameFromId(String id)
    {
        ArrayList<String> names = new ArrayList<>();
        String name = "";
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            DatabaseMetaData md = conn.getMetaData();
            String sql = "SELECT name, id FROM games WHERE id = ?";
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            // set the value
            pstmt.setString(1,id);
            ResultSet idRs  = pstmt.executeQuery();
            name = idRs.getString("name");
        } catch (SQLException e) {
            System.out.println("Game id " + id + " not found :(");
        }
        return name;
    }
    public static void deleteGame(String name)
    {
        String sql = "DELETE FROM games WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(1, name);
            // execute the delete statement
            pstmt.executeUpdate();

            sql = "DROP TABLE " + name;
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void placeVote(String name, String playerName, String vote)
    {
        String sql = "INSERT INTO " + name + "(playerName,vote) VALUES(?,?)";
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            DatabaseMetaData md = conn.getMetaData();
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, playerName);
            psmt.setString(2, vote);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void resetVotes(String name)
    {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "DELETE FROM " + name;
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.executeUpdate();
            System.out.println("Reset the votes from the " + name + "game");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void addPlayer(String name, String playerName)
    {
        placeVote(name, playerName, "none");
    }
    public static ArrayList<String> getPlayers(String name)
    {
        ArrayList<String> names = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            DatabaseMetaData md = conn.getMetaData();
            String sql = "SELECT playerName FROM " + name;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                names.add(rs.getString("playerName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }
}
