package driver;

import gamestates.MenuState;
import handler.DBHandler;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame {

    Toolkit screen = Toolkit.getDefaultToolkit();
    int width = screen.getScreenSize().width;
    int height = screen.getScreenSize().height;
    

    public Window() {

        DBHandler.makeConnectionWithDataBase();
        setTitle("Blaster");
        setLocationRelativeTo(null);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().add(new MenuState(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

   
}
