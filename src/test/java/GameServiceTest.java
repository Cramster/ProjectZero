import org.example.Exception.GameException;
import org.example.Model.Game;
import org.example.Service.GameService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GameServiceTest {
    //arrange + act + assert
    GameService gameService;

    //     Reset game service to a newly-instantiated object.
    @Before
    public void setUp() {
        gameService = new GameService();
    }

    //    When the game service is first created, it should contain zero games
    @Test
    public void gameServiceEmptyAtStart() {
        List<Game> gameList = gameService.getAllGame();
//      Check at the start that there are no games listed
        Assert.assertTrue(gameList.size() == 0);
    }

    @Test
    public void gameServiceAddGame() {
        String testTitle = "title";
        int testReleaseYear = 2020;
        String testDescription = "description";
        boolean testFormatDigital = (true || false);
        try {
            gameService.addGame(testTitle, testReleaseYear, testDescription, testFormatDigital);
        } catch (GameException e) {
            Assert.fail();
        }
        List<Game> games = gameService.getAllGame();
        Game actual = games.get(0);
        Assert.assertEquals (testTitle, actual.getTitle());
        Assert.assertEquals (testReleaseYear, actual.getReleaseYear());
        Assert.assertEquals (testDescription, actual.getDescription());
        Assert.assertEquals (testFormatDigital, actual.getFormatDigital());
    }

    @Test
    public void addGameInvalidYear() {
        String title = "title";
        int releaseYear = 2025;
        String description = "description";
        boolean formatDigital = (true || false);
        try {
            gameService.addGame(title, releaseYear, description, formatDigital);
            Assert.fail(); }
        catch (GameException e) {
        }
    }
}
