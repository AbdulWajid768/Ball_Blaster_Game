package popups;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class AbstractPopUp extends JPanel {

    JButton cancelBtn;
    JLabel header;
    JLabel levelUp;
    JButton upBtn;
    int level;
    int levelUpCost;
    int coins;
    int maxLevel;
    JFrame frame;
    boolean action = true;

    abstract void initComponents();

    abstract void upBtnActionPerformed(java.awt.event.ActionEvent evt);

    abstract void checkLevelLimit();

    abstract void cancelBtnActionPerformed(java.awt.event.ActionEvent evt);
}
