package button;

import driver.GameLauncher;
import gamestates.MenuState;
import gamestates.StartState;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public final class PlayBtn extends JButton {

    private Image img;
    private MenuState panel;

    public PlayBtn(MenuState panel) {
        this.panel = panel;
        init();
    }

    void init() {
        try {

            img = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//play.jpg"));

        } catch (Exception e) {
            e.printStackTrace();
        }

      
        setIcon(new ImageIcon(img));
        setMargin(new Insets(0, 0, 0, 0));
        addActionListener();
    }

    void addActionListener() {
        addActionListener((ActionEvent e) -> {
            GameLauncher.window.remove(panel);
            GameLauncher.window.add(new StartState(panel.width, panel.height));
            GameLauncher.window.validate();
        });
    }

}
