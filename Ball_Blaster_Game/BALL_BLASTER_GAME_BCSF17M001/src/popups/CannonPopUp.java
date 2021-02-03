package popups;

import gamestates.MenuState;
import handler.DBHandler;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CannonPopUp extends javax.swing.JPanel {

    private JFrame frame;
    private JButton[] btns;
    private JButton cancelBtn;
    private JLabel header;
    private JLabel select;
    private ResultSet rs;
    private int own[];
    private int price[];
    private int coins;

    public CannonPopUp(JFrame frame) {
        initComponents();
        this.frame = frame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        header = new JLabel();
        select = new JLabel();
        cancelBtn = new JButton();
        btns = new JButton[4];
        own = new int[4];
        price = new int[4];

        try {
            ResultSet temp = DBHandler.stmt.executeQuery("select * from playerstats");
            temp.next();
            coins = temp.getInt("coins");
            rs = DBHandler.stmt.executeQuery("select * from cannons");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setBackground(new java.awt.Color(204, 255, 102));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setForeground(new java.awt.Color(255, 102, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(400, 350));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 102, 102));
        header.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        header.setForeground(new java.awt.Color(255, 153, 0));
        header.setText("Cannon");
        add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 100, 30));

        select.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        select.setForeground(new java.awt.Color(255, 153, 0));
        select.setText("Select");
        add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 60, 30));

        cancelBtn.setBackground(new java.awt.Color(0, 204, 153));
        cancelBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame.dispose();
            }
        });
        add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 160, -1));

        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton();
            btns[i].setBackground(new java.awt.Color(0, 204, 153));
            btns[i].setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
            try {
                rs.next();
                own[i] = rs.getInt("own");
                price[i] = rs.getInt("price");
                switch (own[i]) {
                    case 2:
                        btns[i].setText("Using");
                        break;
                    case 1:
                        btns[i].setText("Use");
                        break;
                    default:

                        btns[i].setText(Integer.toString(price[i]));
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        btns[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performActionOnBtn1(e);
                MenuState.currentCoins.setText("Current Coins: " + coins);
            }
        });
        btns[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performActionOnBtn2(e);
                MenuState.currentCoins.setText("Current Coins: " + coins);
            }
        });
        btns[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performActionOnBtn3(e);
                MenuState.currentCoins.setText("Current Coins: " + coins);
            }
        });
        btns[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performActionOnBtn4(e);
                MenuState.currentCoins.setText("Current Coins: " + coins);
            }
        });
        add(btns[3], new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 80, -1));
        add(btns[2], new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 80, -1));
        add(btns[1], new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 80, -1));
        add(btns[0], new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 80, -1));

    }// </editor-fold>                        

    public void performActionOnBtn1(ActionEvent e) {
        int index;
        switch (own[0]) {
            case 2:
                break;
            case 1:
                index = indexOf(own, 2);
                own[index] = 1;
                btns[index].setText("Use");
                btns[0].setText("Using");
                own[0] = 2;
                try {
                    DBHandler.stmt.execute("update  playerstats set currentcannon = 'cannon1'");
                    DBHandler.stmt.execute("update  cannons set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  cannons set own = 2 where id = 1");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                try {
                    if (coins - price[0] >= 0) {
                        coins = coins - price[0];
                        own[0] = 1;
                        DBHandler.stmt.execute("update  playerstats set coins = coins - " + price[0]);
                        DBHandler.stmt.execute("update  cannons set own = 1 where id = 1");
                        btns[0].setText("Use");
                    } else {
                        JFrame frame = new JFrame();
                        frame.setResizable(false);
                        frame.add(new Warning(frame));
                        frame.pack();
                        frame.setVisible(true);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }

    public void performActionOnBtn2(ActionEvent e) {
        int index;
        switch (own[1]) {
            case 2:
                break;
            case 1:
                index = indexOf(own, 2);
                own[index] = 1;
                btns[index].setText("Use");
                btns[1].setText("Using");
                own[1] = 2;
                try {
                    DBHandler.stmt.execute("update  playerstats set currentcannon = 'cannon2'");
                    DBHandler.stmt.execute("update  cannons set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  cannons set own = 2 where id = 2");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                try {
                    if (coins - price[1] >= 0) {
                        coins = coins - price[1];
                        own[1] = 1;
                        DBHandler.stmt.execute("update  playerstats set coins = coins - " + price[1]);
                        DBHandler.stmt.execute("update  cannons set own = 1 where id = 2");
                        btns[1].setText("Use");
                    } else {
                        JFrame frame = new JFrame();
                        frame.setResizable(false);
                        frame.add(new Warning(frame));
                        frame.pack();
                        frame.setVisible(true);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }

    public void performActionOnBtn3(ActionEvent e) {
        int index;
        switch (own[2]) {
            case 2:
                break;
            case 1:
                index = indexOf(own, 2);
                own[index] = 1;
                btns[index].setText("Use");
                btns[2].setText("Using");
                own[2] = 2;
                try {
                    DBHandler.stmt.execute("update  playerstats set currentcannon = 'cannon3'");
                    DBHandler.stmt.execute("update  cannons set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  cannons set own = 2 where id = 3");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                try {
                    if (coins - price[2] >= 0) {
                        coins = coins - price[2];
                        own[2] = 1;
                        DBHandler.stmt.execute("update  playerstats set coins = coins - " + price[2]);
                        DBHandler.stmt.execute("update  cannons set own = 1 where id = 3");
                        btns[2].setText("Use");
                    } else {
                        JFrame frame = new JFrame();
                        frame.setResizable(false);
                        frame.add(new Warning(frame));
                        frame.pack();
                        frame.setVisible(true);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }

    public void performActionOnBtn4(ActionEvent e) {
        int index;
        switch (own[3]) {
            case 2:
                break;
            case 1:
                index = indexOf(own, 2);
                own[index] = 1;
                btns[index].setText("Use");
                btns[3].setText("Using");
                own[3] = 2;
                try {
                    DBHandler.stmt.execute("update  playerstats set currentcannon = 'cannon4'");
                    DBHandler.stmt.execute("update  cannons set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  cannons set own = 2 where id = 4");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                try {
                    if (coins - price[3] >= 0) {
                        coins = coins - price[3];

                        own[3] = 1;
                        DBHandler.stmt.execute("update  playerstats set coins = coins - " + price[3]);
                        DBHandler.stmt.execute("update  cannons set own = 1 where id = 4");
                        btns[3].setText("Use");
                    } else {
                        JFrame frame = new JFrame();
                        frame.setResizable(false);
                        frame.add(new Warning(frame));
                        frame.pack();
                        frame.setVisible(true);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }

    public int indexOf(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage can1 = null;
        BufferedImage can2 = null;
        BufferedImage can3 = null;
        BufferedImage can4 = null;
        try {
            can1 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//cannon1.jpg"));
            can2 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//cannon2.jpg"));
            can3 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//cannon3.jpg"));
            can4 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//cannon4.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(can1, 45, 120, 70, 70, null);
        g.drawImage(can2, 125, 120, 70, 70, null);
        g.drawImage(can3, 205, 120, 70, 70, null);
        g.drawImage(can4, 285, 120, 70, 70, null);

    }
}
