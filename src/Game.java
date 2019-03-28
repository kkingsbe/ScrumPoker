import java.util.ArrayList;

public class Game {
    public enum CardSequence
    {
        FIBONACCI,
        POWERSTEN,
        NUMERICAL,
        POWERSTWO
    }
    private String gameName;
    private String gameId;
    private String description;
    private int maxPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private String[] values;
    private CardSequence cardSequence;

    public Game(String gameId, String gameName, String description, CardSequence sequence)
    {
        cardSequence = sequence;
        this.gameName = gameName;
        this.description = description;
        this.gameId = gameId;

        switch(sequence)
        {
            case FIBONACCI:
                values = CardSequenceVals.fibonacci;
                break;
            case POWERSTEN:
                values = CardSequenceVals.powersTen;
                break;
            case NUMERICAL:
                values = CardSequenceVals.numerical;
                break;
            case POWERSTWO:
                values = CardSequenceVals.powersTwo;
                break;
        }
    }
    public void addPlayer(Player player)
    {
        players.add(player);
    }
    public Player getPlayer(String username)
    {
        for(Player player : players)
        {
            if(player.getUserName().equals(username))
                return player;
        }
        return null;
    }
    public ArrayList<String> getTimes() //Returns the different times that were chosen by the players
    {
        ArrayList<String> times = new ArrayList<>();
        for(Player player : players) //Iterates over the players, and checks to see if the time they chose is in the arraylist
        {
            if(!times.contains(player.getDesiredTime()))
                times.add(player.getDesiredTime());
        }
        return times;
    }
    public String getDescription()
    {
        return description;
    }
    public String getGameId()
    {
        return gameId;
    }
    public String getName()
    {
        return gameName;
    }
    public int getMaxPlayers()
    {
        return maxPlayers;
    }
    public void setMaxPlayers(int maxPlayers)
    {
        this.maxPlayers = maxPlayers;
    }
    public boolean allVoted()
    {
        boolean allVoted = true;
        for(Player player : players)
            if(player.getDesiredTime().equals("none"))
                allVoted = false;
        return allVoted;
    }
    public void resetVotes()
    {
        for(Player player : players)
            player.resetVote();
    }
}
