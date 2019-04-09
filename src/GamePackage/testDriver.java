package GamePackage;

public class testDriver {
    public static void main(String[] args) {
        GameDriver.setupDb();
        GameDriver.newGame("Test_game", "Description for test game", "powerstwo");
        GameDriver.newGame("Test_game_two", "Description for test game", "powerstwo");
        GameDriver.newGame("Test_game_three", "Description for test game", "powerstwo");
        System.out.println(GameDriver.getGameNameFromId("0"));
        System.out.println(GameDriver.getGameNameFromId("1"));
        System.out.println(GameDriver.getGameNameFromId("2"));
        GameDriver.resetVotes("0");
        GameDriver.addPlayer("0", "Kyle");
        GameDriver.placeVote("0","kyle","10");
        System.out.println(GameDriver.getPlayers("0"));
        GameDriver.deleteGame("0");
    }
}
