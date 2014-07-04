import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserUI {

  public UserUI() {
    startGame();
  }

  private void startGame() {

    JFrame startingFrame = GuiUtil.createFrame(700, 400, false);
    startingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    startingFrame.setVisible(true);

    final JFrame userGuiFrame = GuiUtil.createFrame(700, 400, false);
    final JFrame pcGuiFrame = GuiUtil.createFrame(400, 400, true);
    final JFrame resultGuiFrame = GuiUtil.createFrame(400, 400, true);

    JButton playUserVSComputer = GuiUtil.createElementButton(20, 100, "Start new game You vs Computer");
    JButton playPCvsPC = GuiUtil.createElementButton(350, 100, "Start new game Computer vs Computer");

    playUserVSComputer.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        userGuiFrame.setVisible(true);
      }
    });

    playPCvsPC.addActionListener(new PCBattleActionListener(pcGuiFrame));

    Container startingContentContainer = startingFrame.getContentPane();
    startingContentContainer.setLayout(null);
    startingContentContainer.add(playPCvsPC);
    startingContentContainer.add(playUserVSComputer);

    Container contentContainer = userGuiFrame.getContentPane();
    contentContainer.setLayout(null);

    JLabel countOfGames = GuiUtil.createLabel(400, 150, GameSettings.getGamesCount());
    JLabel countOfUserWins = GuiUtil.createLabel(400, 200, GameSettings.getUserWins());
    for (int i = 0; i < GameSettings.getElementsCount(); i++) {
      JButton elementButton = GuiUtil.createElementButton(40, (40 + 100 * i), GameSettings.getElementName(i));
      elementButton.addActionListener(new ElementActionListener(countOfGames, countOfUserWins, resultGuiFrame, GameSettings.getElementName(i)));
      contentContainer.add(elementButton);
    }
    contentContainer.add(countOfGames);
    contentContainer.add(countOfUserWins);
    contentContainer.setVisible(true);

  }
}