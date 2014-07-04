import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PCBattleActionListener implements ActionListener {
  JFrame pcGuiFrame;

  public PCBattleActionListener(JFrame pcGuiFrame) {
    this.pcGuiFrame = pcGuiFrame;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String pc1Choice = GameSettings.getPCChoise();
    String pc2Choice = GameSettings.getPCChoise();

    JLabel pc1ChoiceLabel = GuiUtil.createLabel(20, 40, "Computer 1 chose: " + pc1Choice);
    JLabel pc2ChoiceLabel = GuiUtil.createLabel(200, 40, "Computer 2 chose: " + pc2Choice);
    JLabel winner2Label = GuiUtil.createLabel(200, 80, GameSettings.getWinner(pc1Choice, pc2Choice));

    Container pcResultPanel = pcGuiFrame.getContentPane();
    pcResultPanel.removeAll();
    pcResultPanel.add(pc1ChoiceLabel);
    pcResultPanel.add(pc2ChoiceLabel);
    pcResultPanel.add(winner2Label);
    pcResultPanel.add(new Label()); // quick fix for layout bug (JLabel magic)
    pcResultPanel.repaint();
    pcGuiFrame.setVisible(true);
  }

}
