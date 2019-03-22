import java.util.ArrayList;

public class Game {
    private String gameName;
    private ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player)
    {
        players.add(player);
    }

    public ArrayList<String> getTimes()
    {
        ArrayList<String> times = new ArrayList<>();
        for(Player player : players) //Iterates over the players, and checks to see if the time they chose is in the arraylist
        {
            if(!times.contains(player.getDesiredTime()))
                times.add(player.getDesiredTime());
        }
    }
}
