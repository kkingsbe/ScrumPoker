import java.util.ArrayList;

public class testDriver {
    public static void main(String[] args)
    {
        GameContainer container = new GameContainer(1000);
        boolean success = container.newGame("Test Game", "Test game to verify shit works", Game.CardSequence.FIBONACHI);
        System.out.println("Game Create Success?: " + success);

        Player player1 = new Player("Kyle");
        Player player2 = new Player("Johnny");
        container.getGame("0").addPlayer(player1);
        container.getGame("0").addPlayer(player2);

        player1.setDesiredTime("5");
        player2.setDesiredTime("5");

        ArrayList<String> times = container.getGame("0").getTimes();

        System.out.println("done bitch");
    }
}
