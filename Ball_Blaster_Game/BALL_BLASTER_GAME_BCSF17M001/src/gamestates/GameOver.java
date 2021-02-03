package gamestates;

import driver.GameLauncher;
import gamestates.MenuState;
import gamestates.PlayState;
import javax.swing.JFrame;
import handler.DBHandler;


public class GameOver extends javax.swing.JPanel {

    private int level;
    private int levelUpCost;
    private JFrame frame;
    private PlayState game;

    public GameOver(JFrame frame, PlayState game) {
        this.frame = frame;
        this.game = game;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        stageLabel = new javax.swing.JLabel();
        coinsWon = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        againBtn = new javax.swing.JButton();
        quitBtn = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 102));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setForeground(new java.awt.Color(255, 102, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(400, 350));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scoreLabel.setBackground(new java.awt.Color(0, 102, 102));
        scoreLabel.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(255, 153, 0));
        scoreLabel.setText("Score: " + game.score);
        add(scoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 30));

        coinsWon.setBackground(new java.awt.Color(0, 102, 102));
        coinsWon.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        coinsWon.setForeground(new java.awt.Color(255, 153, 0));
        coinsWon.setText("Coins Won: " + game.score / 3);
        add(coinsWon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 400, 30));

        stageLabel.setBackground(new java.awt.Color(0, 102, 102));
        stageLabel.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        stageLabel.setForeground(new java.awt.Color(255, 153, 0));
        if (game.stageCleared == true) {
            stageLabel.setText("Stage " + game.stage + " Cleared");
        } else {
            stageLabel.setText("Stage " + game.stage + " Not Cleared");
        }
        add(stageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 400, 30));

        againBtn.setBackground(new java.awt.Color(0, 204, 153));
        againBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        againBtn.setText("Play Again");
        againBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                againBtnActionPerformed(evt);
            }
        });
        add(againBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 120, -1));

        quitBtn.setBackground(new java.awt.Color(0, 204, 153));
        quitBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        quitBtn.setText("Quit");
        quitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBtnActionPerformed(evt);
            }
        });
        add(quitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 120, -1));

        menuBtn.setBackground(new java.awt.Color(0, 204, 153));
        menuBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        menuBtn.setText("Menu");
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });
        add(menuBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 120, -1));
        updateDatabase();
    }// </editor-fold>                        

    private void againBtnActionPerformed(java.awt.event.ActionEvent evt) {
        frame.dispose();
        GameLauncher.window.remove(this);
        GameLauncher.window.add(new PlayState(game.width, game.height));
        GameLauncher.window.validate();

    }

    private void quitBtnActionPerformed(java.awt.event.ActionEvent evt) {
        frame.dispose();
        GameLauncher.window.dispose();

    }

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        frame.dispose();
        GameLauncher.window.remove(this);
        GameLauncher.window.add(new MenuState(game.width, game.height));
        GameLauncher.window.validate();

    }

    private void updateDatabase() {
        try {
            DBHandler.stmt.execute("update playerstats set coins = coins + " + game.score / 3);
            DBHandler.stmt.execute("update ballblaster.playerstats set highestscore = " + game.score + " where id = 1 AND highestscore < " + game.score);
            if (game.stageCleared == true) {
                DBHandler.stmt.execute("update playerstats set stage = stage + 1");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton againBtn;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel stageLabel;
    private javax.swing.JLabel coinsWon;
    private javax.swing.JButton menuBtn;
    private javax.swing.JButton quitBtn;
    // End of variables declaration                   
}
