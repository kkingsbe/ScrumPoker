import java.io.IOException;
import java.util.ArrayList;

public class testDriver {
    public static void main(String[] args) throws IOException {
        DataLogger dataLogger = new DataLogger();
        GameContainer container = new GameContainer(1000, dataLogger);
        String gameId = container.newGame("Test Game", "Test game to verify shit works", Game.CardSequence.FIBONACCI);
        System.out.println("Game created with id: " + gameId);

        Player player1 = new Player("Kyle"); //creates players
        Player player2 = new Player("Johnny");

        container.getGame(gameId).addPlayer(player1);
        container.getGame(gameId).addPlayer(player2);

        player1.setDesiredTime("5"); //adds the desired times
        player2.setDesiredTime("5");

        ArrayList<String> times = container.getGame("0").getTimes();

        System.out.println("done bitch");
    }
}
