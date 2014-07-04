import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ElementActionListener implements ActionListener {
  private JFrame resultGuiFrame;
  private String userChoise;
  private JLabel gamesCount;
  private JLabel countOfUserWins;

  public ElementActionListener(JLabel gamesCount, JLabel countOfUserWins, JFrame resultGuiFrame, String userChoise) {
    this.resultGuiFrame = resultGuiFrame;
    this.userChoise = userChoise;
    this.gamesCount = gamesCount;
    this.countOfUserWins = countOfUserWins;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String pcChoice = GameSettings.getPCChoise();

    Container resultPanel = resultGuiFrame.getContentPane();
    resultPanel.setLayout(null);
    resultPanel.removeAll();
    JLabel winner1Label = GuiUtil.createLabel(100, 100, GameSettings.getWinner(pcChoice, userChoise));
    resultPanel.add(winner1Label);

    JLabel userChoiceLabel = GuiUtil.createLabel(40, 150, "Your choice: " + userChoise);
    resultPanel.add(userChoiceLabel);

    JLabel computerChoiceLabel = GuiUtil.createLabel(180, 150, "Computer's choice: " + pcChoice);
    resultPanel.add(computerChoiceLabel);
    resultPanel.repaint();
    resultGuiFrame.setVisible(true);
    gamesCount.setText(GameSettings.getGamesCount());
    countOfUserWins.setText(GameSettings.getUserWins());
  }

}
