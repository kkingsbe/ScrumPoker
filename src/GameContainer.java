import java.util.ArrayList;

public class GameContainer{
    private ArrayList<Game> games = new ArrayList<>();
    private int maxGames; //The maximum number of concurrent games (leave as null or zero infinite games)

    public GameContainer(int maxGames)
    {
        if(maxGames > 0) this.maxGames = maxGames;
    }
    public int numGames()
    {
        return games.size();
    }
    public int getMaxGames()
    {
        return maxGames;
    }
    public void setMaxGames(int maxGames)
    {
        this.maxGames = maxGames;
    }
    public boolean newGame(String gameName, String description, Game.CardSequence sequence)
    {
        // Creates new game if not at capacity
        if(numGames() < maxGames)
        {
            String gameId = Integer.toString(games.size());
            games.add(new Game(gameId, gameName, description, sequence));
            return true;
        } else return false;
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
}
