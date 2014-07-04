import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class GameSettings {
  static int tie = 0;
  protected static int userWon = 0;
  protected static int total = 0;
  final protected static String ROCK = "Rock";
  final protected static String PAPER = "Paper";
  final protected static String SCISSORS = "Scissors";
  final private static Random random = new Random();
  private static List<String> elements = Arrays.asList(ROCK, PAPER, SCISSORS);

  public static int getElementsCount() {
    return elements.size();
  }

  public static String getElementName(int index) {
    return elements.get(index);
  }

  public static String getPCChoise() {
    return GameSettings.getElementName(random.nextInt(3));
  }

  public static String getWinner(String player1Choice, String player2Choice) {
    String result = "";
    if (!elements.contains(player1Choice) || !elements.contains(player2Choice)) {
      throw new RuntimeException("Invalid value");
    }

    if (player1Choice.equals(player2Choice)) {
      result = "It is a tie!";
      tie++;
      total++;
    } else if (player2Choice == ROCK && player1Choice != PAPER) {
      result = "Rock wins!";
      userWon++;
      total++;
    } else if (player2Choice == PAPER && player1Choice != SCISSORS) {
      result = "Paper wins!";
      userWon++;
      total++;
    } else if (player2Choice == SCISSORS && player1Choice != ROCK) {
      result = "Scissors wins!";
      userWon++;
      total++;
    } else {
      result = player1Choice + " wins!";
      total++;
    }

    return result;

  }

  public static String getGamesCount() {
    return "Games total count: " + total;
  }

  public static String getUserWins() {
    return "Count of you wins: " + userWon;
  }
}
