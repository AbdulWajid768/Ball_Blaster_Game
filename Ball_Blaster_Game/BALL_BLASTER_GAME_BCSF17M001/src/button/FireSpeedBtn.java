package button;

import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import popups.FireSpeedPopUp;

public class FireSpeedBtn extends AbstractBtn {

  
    public FireSpeedBtn() {
        init();
    }

    void init() {
        try {
            img = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//firespeed.jpg"));
            setIcon(new ImageIcon(img));
            setMargin(new Insets(0, 0, 0, 0));
            addActionListener();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addActionListener() {
        this.addActionListener((e) -> {
            JFrame frame = new JFrame();
            frame.setResizable(false);
            frame.add(new FireSpeedPopUp(frame));
            frame.pack();
            frame.setVisible(true);
        });
    }
}
