
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameSettingsTest {

  @Before
  public void setup() {
    GameSettings.total = 0;
    GameSettings.tie = 0;
    GameSettings.userWon = 0;
  }

  @Test
  public void testIncorrectValue() throws Exception {
    try {
      GameSettings.getWinner("Invalid value", "");
    } catch (Exception ex) {
      Assert.assertEquals(ex.getMessage(), "Invalid value");
      return;
    }
    Assert.fail();
  }

  @Test
  public void testTieCombination() throws Exception {
    Assert.assertEquals("It is a tie!", GameSettings.getWinner(GameSettings.ROCK, GameSettings.ROCK));
  }

  @Test
  public void testRockWinsCombination() throws Exception {
    Assert.assertEquals("Rock wins!", GameSettings.getWinner(GameSettings.ROCK, GameSettings.SCISSORS));
  }

  @Test
  public void testPaperWinsCombination() throws Exception {
    Assert.assertEquals("Paper wins!", GameSettings.getWinner(GameSettings.PAPER, GameSettings.ROCK));
  }

  @Test
  public void testScissorsWinsCombination() throws Exception {
    Assert.assertEquals("Scissors wins!", GameSettings.getWinner(GameSettings.SCISSORS, GameSettings.PAPER));
  }

  @Test
  public void testScissorsLoseCombination() throws Exception {
    Assert.assertEquals("Rock wins!", GameSettings.getWinner(GameSettings.SCISSORS, GameSettings.ROCK));
  }

  @Test
  public void testRockLoseCombination() throws Exception {
    Assert.assertEquals("Paper wins!", GameSettings.getWinner(GameSettings.ROCK, GameSettings.PAPER));
  }

  @Test
  public void testPaperLoseCombination() throws Exception {
    Assert.assertEquals("Scissors wins!", GameSettings.getWinner(GameSettings.PAPER, GameSettings.SCISSORS));
  }

  @Test
  public void testElementsCount() throws Exception {
    Assert.assertEquals(3, GameSettings.getElementsCount());
  }

  @Test
  public void testFirstElementNameIsRock() throws Exception {
    Assert.assertEquals("Rock", GameSettings.getElementName(0));
  }

  @Test
  public void testSecontElementNameIsRock() throws Exception {
    Assert.assertEquals("Paper", GameSettings.getElementName(1));
  }

  @Test
  public void testThirdElementNameIsRock() throws Exception {
    Assert.assertEquals("Scissors", GameSettings.getElementName(2));
  }

  @Test
  public void testCountOfGames() throws Exception {
    GameSettings.getWinner(GameSettings.PAPER, GameSettings.ROCK);
    Assert.assertEquals(1, GameSettings.total);
  }

  @Test
  public void testCountOfUserWins() throws Exception {
    GameSettings.getWinner(GameSettings.SCISSORS, GameSettings.ROCK);
    Assert.assertEquals(1, GameSettings.userWon);
  }
}
