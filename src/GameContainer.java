import java.io.IOException;
import java.util.ArrayList;

public class GameContainer{
    private static ArrayList<Game> games = new ArrayList<>();
    private static DataLogger dataLogger;
    static {
        try {
            dataLogger = new DataLogger();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static DataLogger getDataLogger()
    {
        return dataLogger;
    }
    public static int numGames()
    {
        return games.size();
    }
    public static String newGame(String gameName, String description, Game.CardSequence sequence)
    {
        String gameId = Integer.toString(games.size());
        games.add(new Game(gameId, gameName, description, sequence, dataLogger));
        dataLogger.newSession();
        return gameId;
    }
    public static Game getGame(String gameId) //Returns game based on id
    {
        for(Game game : games)
            if(game.getGameId().equals(gameId)) return game;
        return null;
    }
    public static Game getGameFromName(String gameName) //Returns game based on name
    {
        for(Game game : games)
            if(game.getName().equals(gameName)) return game;
        return null;
    }
    public static void deleteGame(String gameId)
    {
        Game game = getGame(gameId);
        for(int player = 0; player < game.getPlayers().size(); player ++) dataLogger.deleteActivePlayer();
        games.remove(game);
        dataLogger.deleteSession();
    }
    public static Player getPlayer(String username, String gameId)
    {
        return(getGame(gameId).getPlayer(username));
    }
    public static
}
