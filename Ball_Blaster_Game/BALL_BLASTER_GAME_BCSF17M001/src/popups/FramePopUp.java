package popups;

import gamestates.MenuState;
import handler.DBHandler;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FramePopUp extends javax.swing.JPanel {

    private JButton[] btns;
    private JButton cancelBtn;
    private JLabel header;
    private JLabel select;
    private JFrame frame;
    private ResultSet rs;
    private int own[];
    private int price[];
    private int coins;

    public FramePopUp(JFrame frame) {
        initComponents();
        this.frame = frame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        header = new JLabel();
        select = new JLabel();
        cancelBtn = new JButton();
        btns = new JButton[10];
        own = new int[10];
        price = new int[10];
        try {
            ResultSet temp = DBHandler.stmt.executeQuery("select * from playerstats");
            temp.next();
            coins = temp.getInt("coins");
            rs = DBHandler.stmt.executeQuery("select * from backgrounds");
        } catch (SQLException ex) {
            Logger.getLogger(CannonPopUp.class.getName()).log(Level.SEVERE, null, ex);
        }

        setBackground(new java.awt.Color(204, 255, 102));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setForeground(new java.awt.Color(255, 102, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(500, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 102, 102));
        header.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        header.setForeground(new java.awt.Color(255, 153, 0));
        header.setText("BackGround");
        add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 150, 30));

        select.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        select.setForeground(new java.awt.Color(255, 153, 0));
        select.setText("Select");
        add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 60, 30));

        cancelBtn.setBackground(new java.awt.Color(0, 204, 153));
        cancelBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener((e) -> {
            frame.dispose();
        });
        add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 160, -1));

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
        btns[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performActionOnBtn5(e);
                MenuState.currentCoins.setText("Current Coins: " + coins);
            }
        });
        btns[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performActionOnBtn6(e);
                MenuState.currentCoins.setText("Current Coins: " + coins);
            }
        });
        btns[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performActionOnBtn7(e);
                MenuState.currentCoins.setText("Current Coins: " + coins);
            }
        });
        btns[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performActionOnBtn8(e);
                MenuState.currentCoins.setText("Current Coins: " + coins);
            }
        });
        btns[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performActionOnBtn9(e);
                MenuState.currentCoins.setText("Current Coins: " + coins);
            }
        });
        btns[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performActionOnBtn10(e);
                MenuState.currentCoins.setText("Current Coins: " + coins);
            }
        });
        add(btns[2], new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 80, -1));
        add(btns[1], new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 80, -1));
        add(btns[0], new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 80, -1));
        add(btns[4], new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 80, -1));
        add(btns[3], new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 80, -1));
        add(btns[7], new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 80, -1));
        add(btns[6], new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 80, -1));
        add(btns[5], new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 80, -1));
        add(btns[9], new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 80, -1));
        add(btns[8], new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 80, -1));

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
                    DBHandler.stmt.execute("update  playerstats set currentbg = 'bg1'");
                    DBHandler.stmt.execute("update  backgrounds set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  backgrounds set own = 2 where id = 1");
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
                        DBHandler.stmt.execute("update  backgrounds set own = 1 where id = 1");
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
                    DBHandler.stmt.execute("update  playerstats set currentbg = 'bg2'");
                    DBHandler.stmt.execute("update  backgrounds set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  backgrounds set own = 2 where id = 2");
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
                        DBHandler.stmt.execute("update  backgrounds set own = 1 where id = 2");
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
                    DBHandler.stmt.execute("update  playerstats set currentbg = 'bg3'");
                    DBHandler.stmt.execute("update  backgrounds set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  backgrounds set own = 2 where id = 3");
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
                        DBHandler.stmt.execute("update  backgrounds set own = 1 where id = 3");
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
                    DBHandler.stmt.execute("update  playerstats set currentbg = 'bg4'");
                    DBHandler.stmt.execute("update  backgrounds set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  backgrounds set own = 2 where id = 4");
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
                        DBHandler.stmt.execute("update  backgrounds set own = 1 where id = 4");
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

    public void performActionOnBtn5(ActionEvent e) {
        int index;
        switch (own[4]) {
            case 2:
                break;
            case 1:
                index = indexOf(own, 2);
                own[index] = 1;
                btns[index].setText("Use");
                btns[4].setText("Using");
                own[4] = 2;
                try {
                    DBHandler.stmt.execute("update  playerstats set currentbg = 'bg5'");
                    DBHandler.stmt.execute("update  backgrounds set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  backgrounds set own = 2 where id = 5");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                try {
                    if (coins - price[4] >= 0) {
                        coins = coins - price[4];
                        own[4] = 1;
                        DBHandler.stmt.execute("update  playerstats set coins = coins - " + price[4]);
                        DBHandler.stmt.execute("update  backgrounds set own = 1 where id = 5");
                        btns[4].setText("Use");
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

    public void performActionOnBtn6(ActionEvent e) {
        int index;
        switch (own[5]) {
            case 2:
                break;
            case 1:
                index = indexOf(own, 2);
                own[index] = 1;
                btns[index].setText("Use");
                btns[5].setText("Using");
                own[5] = 2;
                try {
                    DBHandler.stmt.execute("update  playerstats set currentbg = 'bg6'");
                    DBHandler.stmt.execute("update  backgrounds set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  backgrounds set own = 2 where id = 6");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                try {
                    if (coins - price[5] >= 0) {
                        coins = coins - price[5];
                        own[5] = 1;
                        DBHandler.stmt.execute("update  playerstats set coins = coins - " + price[5]);
                        DBHandler.stmt.execute("update  backgrounds set own = 1 where id = 6");
                        btns[5].setText("Use");
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

    public void performActionOnBtn7(ActionEvent e) {
        int index;
        switch (own[6]) {
            case 2:
                break;
            case 1:
                index = indexOf(own, 2);
                own[index] = 1;
                btns[index].setText("Use");
                btns[6].setText("Using");
                own[6] = 2;
                try {
                    DBHandler.stmt.execute("update  playerstats set currentbg = 'bg7'");
                    DBHandler.stmt.execute("update  backgrounds set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  backgrounds set own = 2 where id = 7");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                try {
                    if (coins - price[6] >= 0) {
                        coins = coins - price[6];
                        own[6] = 1;
                        DBHandler.stmt.execute("update  playerstats set coins = coins - " + price[6]);
                        DBHandler.stmt.execute("update  backgrounds set own = 1 where id = 1");
                        btns[6].setText("Use");
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

    public void performActionOnBtn8(ActionEvent e) {
        int index;
        switch (own[7]) {
            case 2:
                break;
            case 1:
                index = indexOf(own, 2);
                own[index] = 1;
                btns[index].setText("Use");
                btns[7].setText("Using");
                own[7] = 2;
                try {
                    DBHandler.stmt.execute("update  playerstats set currentbg = 'bg8'");
                    DBHandler.stmt.execute("update  backgrounds set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  backgrounds set own = 2 where id = 8");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                try {
                    if (coins - price[7] >= 0) {
                        coins = coins - price[7];
                        own[7] = 1;
                        DBHandler.stmt.execute("update  playerstats set coins = coins - " + price[7]);
                        DBHandler.stmt.execute("update  backgrounds set own = 1 where id = 8");
                        btns[7].setText("Use");
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

    public void performActionOnBtn9(ActionEvent e) {
        int index;
        switch (own[8]) {
            case 2:
                break;
            case 1:
                index = indexOf(own, 2);
                own[index] = 1;
                btns[index].setText("Use");
                btns[8].setText("Using");
                own[8] = 2;
                try {
                    DBHandler.stmt.execute("update  playerstats set currentbg = 'bg9'");
                    DBHandler.stmt.execute("update  backgrounds set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  backgrounds set own = 2 where id = 9");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                try {
                    if (coins - price[8] >= 0) {
                        coins = coins - price[8];
                        own[8] = 1;
                        DBHandler.stmt.execute("update  playerstats set coins = coins - " + price[8]);
                        DBHandler.stmt.execute("update  backgrounds set own = 1 where id = 9");
                        btns[8].setText("Use");
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

    public void performActionOnBtn10(ActionEvent e) {
        int index;
        switch (own[9]) {
            case 2:
                break;
            case 1:
                index = indexOf(own, 2);
                own[index] = 1;
                btns[index].setText("Use");
                btns[9].setText("Using");
                own[9] = 2;
                try {
                    DBHandler.stmt.execute("update  playerstats set currentbg = 'bg10'");
                    DBHandler.stmt.execute("update  backgrounds set own = 1 where own = 2");
                    DBHandler.stmt.execute("update  backgrounds set own = 2 where id = 10");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                try {
                    if (coins - price[9] >= 0) {
                        coins = coins - price[9];
                        own[9] = 1;
                        DBHandler.stmt.execute("update  playerstats set coins = coins - " + price[9]);
                        DBHandler.stmt.execute("update  backgrounds set own = 1 where id = 10");
                        btns[9].setText("Use");
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
        BufferedImage bg1 = null;
        BufferedImage bg2 = null;
        BufferedImage bg3 = null;
        BufferedImage bg4 = null;
        BufferedImage bg5 = null;
        BufferedImage bg6 = null;
        BufferedImage bg7 = null;
        BufferedImage bg8 = null;
        BufferedImage bg9 = null;
        BufferedImage bg10 = null;

        try {
            bg1 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//bg1.jpg"));
            bg2 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//bg2.jpg"));
            bg3 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//bg3.jpg"));
            bg4 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//bg4.jpg"));
            bg5 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//bg5.jpg"));
            bg6 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//bg6.jpg"));
            bg7 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//bg7.jpg"));
            bg8 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//bg8.jpg"));
            bg9 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//bg9.jpg"));
            bg10 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//bg10.jpg"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(bg1, 55, 120, 70, 70, null);
        g.drawImage(bg2, 135, 120, 70, 70, null);
        g.drawImage(bg3, 215, 120, 70, 70, null);
        g.drawImage(bg4, 295, 120, 70, 70, null);
        g.drawImage(bg5, 375, 120, 70, 70, null);
        g.drawImage(bg6, 55, 240, 70, 70, null);
        g.drawImage(bg7, 135, 240, 70, 70, null);
        g.drawImage(bg8, 215, 240, 70, 70, null);
        g.drawImage(bg9, 295, 240, 70, 70, null);
        g.drawImage(bg10, 375, 240, 70, 70, null);

    }

}
