package button;

import java.awt.Image;
import javax.swing.JButton;

public abstract class AbstractBtn extends JButton{

    Image img;
    abstract void init();
    abstract void addActionListener();

}
