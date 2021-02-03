package popups;

import gamestates.MenuState;
import handler.DBHandler;
import java.sql.ResultSet;
import javax.swing.JFrame;

public class FirePowerPopUp extends AbstractPopUp {


    public FirePowerPopUp(JFrame frame) {
        this.frame = frame;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    void initComponents() {

        header = new javax.swing.JLabel();
        levelUp = new javax.swing.JLabel();
        upBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 102));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setForeground(new java.awt.Color(255, 102, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(400, 350));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 102, 102));
        header.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        header.setForeground(new java.awt.Color(255, 153, 0));
        header.setText("Fire Power");
        add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 140, 30));

        levelUp.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        levelUp.setForeground(new java.awt.Color(255, 153, 0));
        levelUp.setText("Level UP");
        add(levelUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        upBtn.setBackground(new java.awt.Color(0, 204, 153));
        upBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        upBtn.setText("Up");
        upBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upBtnActionPerformed(evt);
            }
        });
        add(upBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 70, -1));

        cancelBtn.setBackground(new java.awt.Color(0, 204, 153));
        cancelBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 110, -1));

        try {
            ResultSet rs = DBHandler.stmt.executeQuery("select * from playerstats");
            rs.next();
            level = rs.getInt("fpl");
            coins = rs.getInt("coins");
            levelUpCost = rs.getInt("coinstonextfpl");
            maxLevel = rs.getInt("maxfpl");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (level >= maxLevel) {
            action = false;
            upBtn.setText("max");
        } else {
            upBtn.setText(Integer.toString(levelUpCost));
        }
        checkLevelLimit();
    }// </editor-fold>                        

    @Override
    void upBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (action == false) {
            return;
        }
        if (coins - levelUpCost < 0) {
            JFrame fr = new JFrame();
            fr.setResizable(false);
            fr.add(new Warning(fr));
            fr.pack();
            fr.setVisible(true);
            return;
        }
        try {
            level++;
            coins = coins - levelUpCost;
            MenuState.currentCoins.setText("Current Coins: " + coins);
            DBHandler.stmt.execute("update playerstats set fpl = " + level + " where id = 1");
            DBHandler.stmt.execute("update playerstats set coins = " + coins + " where id = 1");
            levelUpCost = level * level * 10 + 10;
            DBHandler.stmt.execute("update playerstats set coinstonextfpl = " + levelUpCost + " where id = 1");
            upBtn.setText(Integer.toString(levelUpCost));
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkLevelLimit();
    }
    
    @Override
     void checkLevelLimit() {
        if (level >= maxLevel) {
            action = false;
            upBtn.setText("max");
        } else {
            upBtn.setText(Integer.toString(levelUpCost));
        }
    }

    @Override
    void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        frame.dispose();
    }
}
