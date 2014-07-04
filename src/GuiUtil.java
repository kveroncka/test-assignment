import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GuiUtil {
  public static JFrame createFrame(int frameWidth, int frameHeight,
      boolean alwaysOnTop) {
    JFrame frame = new JFrame();
    frame.setTitle("Rock - Paper - Scissors");
    frame.setSize(frameWidth, frameHeight);
    frame.setAlwaysOnTop(alwaysOnTop);
    frame.setLocationRelativeTo(null);

    return frame;
}

  public static JLabel createLabel(int x, int y, String text) {
    JLabel label = new JLabel(text);
    label.setBounds(x, y, 200, 35);
    return label;
  }

  public static JButton createElementButton(int x, int y, String text) {
    JButton button = new JButton(text);
    button.setBackground(Color.white);
    button.setBounds(x, y, 300, 80);
    return button;
  }
}
