import java.util.ArrayList;

public class testDriver {
    public static void main(String[] args)
    {
        GameContainer container = new GameContainer(1000); //Creates a new game
        boolean success = container.newGame("0001","Test Game", "Test game to verify shit works", Game.CardSequence.FIBONACHI);
        System.out.println("Game Create Success?: " + String.valueOf(success)); //checks if game was created successfully

        Player player1 = new Player("Kyle"); //creates players
        Player player2 = new Player("Johnny");
        container.getGame("0001").addPlayer(player1); //adds players to game
        container.getGame("0001").addPlayer(player2);

        player1.setDesiredTime("5"); //adds the desired times
        player2.setDesiredTime("5");

        ArrayList<String> times = container.getGame("0001").getTimes();

        System.out.println("done bitch");
    }
}
