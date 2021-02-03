package button;

import java.awt.Insets;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import popups.CannonPopUp;

public class CannonBtn extends AbstractBtn {
    public CannonBtn() {
        init();
    }

    void init() {
        try {
            img = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//cannon.jpg"));
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
            frame.add(new CannonPopUp(frame));
            frame.pack();
            frame.setVisible(true);
        });
    }
}
