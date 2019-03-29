import java.io.IOException;
import java.util.ArrayList;

public class GameContainer{
    private ArrayList<Game> games = new ArrayList<>();
    private int maxGames; //The maximum number of concurrent games (leave as null or zero infinite games)
    private DataLogger dataLogger;

    public GameContainer(int maxGames, DataLogger dataLogger) throws IOException //sets max games
    {
        if(maxGames > 0) this.maxGames = maxGames;
        this.dataLogger = dataLogger;
    }
    public DataLogger getDataLogger()
    {
        return dataLogger;
    }
    public int numGames() 
    {
        return games.size();
    }
    public int getMaxGames() //gets the max games
    {
        return maxGames;
    }
    public void setMaxGames(int maxGames) //sets max games
    {
        this.maxGames = maxGames;
    }
    public String newGame(String gameName, String description, Game.CardSequence sequence)
    {
        // Creates new game if not at capacity
        if(numGames() < maxGames)
        {
            String gameId = Integer.toString(games.size());
            games.add(new Game(gameId, gameName, description, sequence, dataLogger));
            dataLogger.newSession();
            return gameId;
        } else return "";
    }
    public Game getGame(String gameId) //Returns game based on id
    {
        for(Game game : games)
            if(game.getGameId().equals(gameId)) return game;
        return null;
    }
    public Game getGameFromName(String gameName) //Returns game based on name
    {
        for(Game game : games)
            if(game.getName().equals(gameName)) return game;
        return null;
    }
    public void deleteGame(String gameId)
    {
        Game game = getGame(gameId);
        for(int player = 0; player < game.getPlayers().size(); player ++) dataLogger.deleteActivePlayer();
        games.remove(game);
        dataLogger.deleteSession();
    }
}
