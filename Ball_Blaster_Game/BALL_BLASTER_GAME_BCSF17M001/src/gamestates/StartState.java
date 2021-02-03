package gamestates;

import driver.GameLauncher;
import gamestates.PlayState;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class StartState extends JPanel implements Runnable {

    public int width;
    public int height;
    private Thread thread;
    private BufferedImage image;
    public Graphics2D graphics2D;
    private BufferedImage bgImg;

    public StartState(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
        this.width = width;
        this.height = height;

    }

    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    private void init() {
        try {
            bgImg = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//start.jpg"));
        } catch (Exception e) {
            e.printStackTrace();

        }
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics2D = (Graphics2D) image.getGraphics();
    }

    @Override
    public void run() {
        init();
        render();
        draw();
        int oldTFBall = (int) (System.nanoTime() / 1000000000);
        int newTFBall;
        while (true) {
            newTFBall = (int) (System.nanoTime() / 1000000000);
            if (newTFBall - oldTFBall > 1) {
                break;
            }

        }

        GameLauncher.window.remove(this);
        GameLauncher.window.add(new PlayState(width, height));
        GameLauncher.window.validate();
    }

    private void render() {
        graphics2D.drawImage(bgImg, 0, 0, width, height, null);

    }

    private void draw() {
        Graphics graphics = (Graphics) this.getGraphics();
        System.out.println(graphics.drawImage(image, 0, 0, width, height, null));
    }

}
