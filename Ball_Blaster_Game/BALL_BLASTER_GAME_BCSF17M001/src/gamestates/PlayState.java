package gamestates;

import entities.Firing;
import entities.Cannon;
import entities.Balls;
import collision.BallWithBullet;
import collision.BallWithCannon;
import handler.DBHandler;
import handler.KeyHandler;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayState extends JPanel implements Runnable {

    public int width;
    public int height;
    public int border;
    int ballCount;
    public int score = 0;
    public int stage;
    public Thread thread;
    public boolean running = false;
    public boolean stageCleared = false;
    private BufferedImage image;
    public Graphics2D graphics2D;
    private KeyHandler key;
    public Cannon player;
    public Firing firing;
    public Balls balls;
    public BallWithBullet bbCollision;
    public BallWithCannon bpCollision;
    private BufferedImage bgImg;
    private BufferedImage borderImg;
    public boolean pause = false;

    public PlayState(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
        this.border = height - 150;
        init();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    private void init() {

        try {
            ResultSet temp = DBHandler.stmt.executeQuery("select * from playerstats");
            temp.next();
            bgImg = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//" + temp.getString("currentbg") + ".jpg"));
            borderImg = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//border.jpg"));
            stage = temp.getInt("stage");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        running = true;
        key = new KeyHandler(this);
        player = new Cannon(this);
        firing = new Firing(this);
        balls = new Balls(this);
        bbCollision = new BallWithBullet(this);
        bpCollision = new BallWithCannon(this);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics2D = (Graphics2D) image.getGraphics();
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void run() {
        setFocusable(true);
        requestFocus();
        ballCount = stage;
        Random rand = new Random();
        int oldTFBall = (int) (System.nanoTime() / 1000000000);
        int newTFBall;
        int secTWFBall = rand.nextInt(4) + 3;
        boolean wait = true;
        final double GAME_HERTZ = 64.0;
        final double TBU = 1000000000 / GAME_HERTZ; // Time Before Update

        final int MUBR = 3; // Must Update before render

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 1000;
        final double TTBR = 1000000000 / TARGET_FPS; // Total time before render

        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);
        int oldFrameCount = 0;
        balls.addBall(0, 0, balls.maxSize, rand.nextInt(4) + 1);
        ballCount--;
        while (running) {
            if (pause == true) {
                continue;
            }
            newTFBall = (int) (System.nanoTime() / 1000000000);
            if (newTFBall - oldTFBall > secTWFBall && ballCount > 0) {
                oldTFBall = newTFBall;
                balls.addBall(rand.nextInt(width - balls.maxSize), 0, balls.maxSize, rand.nextInt(4) + 1);
                ballCount--;
                secTWFBall = rand.nextInt(4) + 3;
            }

            double now = System.nanoTime();
            int updateCount = 0;
            while (((now - lastUpdateTime) > TBU) && (updateCount < MUBR)) {
                update();
                lastUpdateTime += TBU;
                updateCount++;
            }

            if ((now - lastUpdateTime) > TBU) {
                lastUpdateTime = now - TBU;
            }
            render();
            draw();
            collision();
            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if (thisSecond > lastSecondTime) {
                if (frameCount != oldFrameCount) {
                    oldFrameCount = frameCount;
                }

                frameCount = 0;
                lastSecondTime = thisSecond;
            }

            while (now - lastRenderTime < TTBR && now - lastUpdateTime < TBU) {
                Thread.yield();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    System.out.println("ERROR: yielding thread");
                }
                now = System.nanoTime();
            }
            if (ballCount == 0 && balls.balls.isEmpty()) {
                if (wait == false) {
                    stageCleared = true;
                    running = false;
                } else {
                    wait = false;
                }
            }
            try {
                synchronized (this) {
                    while (pause == true) {
                        wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JFrame frame = new JFrame("Game Over");
        frame.setResizable(false);
        frame.add(new GameOver(frame, this));
        frame.pack();
        frame.setVisible(true);
    }

    private void update() {
        balls.update();                    //call update of balls array;
        firing.update();

    }

    private void render() {
        renderBackground();                // BACKGROUND
        renderBorder();                    //BORDER
        firing.render(graphics2D);         //FIRING
        balls.render(graphics2D);          //BALLS
        player.render(graphics2D);         //PLAYER
    }

    private void draw() {
        Graphics graphics = (Graphics) this.getGraphics();
        graphics.drawImage(image, 0, 0, width, height, null);
    }

    public void collision() {
        bbCollision.isBallCollidesWithBullet();
        bpCollision.isBallCollidesWithPlayer();
    }

    private void renderBackground() {
        if (graphics2D != null) {
            graphics2D.drawImage(bgImg, 0, 0, width, height, null);
        }
    }

    private void renderBorder() {
        if (graphics2D != null) {
            graphics2D.drawImage(borderImg, 0, border, width, height - border, null);
        }
    }

    synchronized public void pause() {
        pause = true;
    }

    synchronized public void resume() {
        pause = false;
        notify();
    }

}
