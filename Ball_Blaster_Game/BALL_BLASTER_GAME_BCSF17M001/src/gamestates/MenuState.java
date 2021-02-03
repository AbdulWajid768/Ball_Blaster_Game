package gamestates;

import button.*;
import handler.DBHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class MenuState extends JPanel {

    static public JLabel currentCoins;
    public Graphics2D graphics2D;
    public int width;
    public int height;
    public int coins = 0;
    private int stage;
    private int highestScore;
    private BufferedImage image;
    private BufferedImage bgImg;
    private FireSpeedBtn fireSpeedBtn;
    private FirePowerBtn firePowerBtn;
    private CannonBtn cannonBtn;
    private FrameBtn frameBtn;
    private PlayBtn playBtn;
    private JLabel scoreLabel;
    private JLabel stageLabel;

    public MenuState(int width, int height) {
        setLayout(new AbsoluteLayout());
        setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
        init();
        setFocusable(true);
        requestFocus();

    }

    private void init() {
        try {
            bgImg = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//menubg.jpg"));
            ResultSet temp = DBHandler.stmt.executeQuery("select * from playerstats");
            temp.next();
            coins = temp.getInt("coins");
            highestScore = temp.getInt("highestscore");
            stage = temp.getInt("stage");
        } catch (Exception e) {
            e.printStackTrace();
        }
        addContent();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics2D = (Graphics2D) image.getGraphics();

    }

    private void render() {
        graphics2D.drawImage(bgImg, 0, 0, width, height, null);

    }

    public void addContent() {
        fireSpeedBtn = new FireSpeedBtn();
        firePowerBtn = new FirePowerBtn();
        cannonBtn = new CannonBtn();
        frameBtn = new FrameBtn();
        playBtn = new PlayBtn(this);
        currentCoins = new JLabel("Current Coins: " + coins);
        scoreLabel = new JLabel("Highest Score: " + highestScore);
        stageLabel = new JLabel("Current Stage: " + stage);
        add(fireSpeedBtn, new AbsoluteConstraints(10, 10, -1, -1));
        add(firePowerBtn, new AbsoluteConstraints(130, 10, -1, -1));
        add(frameBtn, new AbsoluteConstraints(250, 10, -1, -1));
        add(cannonBtn, new AbsoluteConstraints(370, 10, -1, -1));
        currentCoins.setFont(new Font("Serif", Font.BOLD, 30));
        currentCoins.setForeground(Color.DARK_GRAY);
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 30));
        scoreLabel.setForeground(Color.DARK_GRAY);
        stageLabel.setFont(new Font("Serif", Font.BOLD, 30));
        stageLabel.setForeground(Color.DARK_GRAY);
        add(scoreLabel, new AbsoluteConstraints(width - 300, 10, -1, -1));
        add(stageLabel, new AbsoluteConstraints(width - 300, 40, -1, -1));
        add(currentCoins, new AbsoluteConstraints(width - 300, 70, -1, -1));
        add(playBtn, new AbsoluteConstraints(600, 300, -1, -1));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            render();
            g.drawImage(image, 0, 0, width, height, null);
        }
    }
}
