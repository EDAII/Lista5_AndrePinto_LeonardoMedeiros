/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista5_andrepinto_leonardomedeiros;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.exit;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author andrelucax
 */
public class TestInGameScreen extends javax.swing.JFrame {
    ImageIcon icon = new ImageIcon("images/youDied.jpg");
    JLabel image = new JLabel(icon);
    public int timeLimit = 20000;
    public int score = 0;
    public boolean isPlaying = true;
    public int lClick = 0;
    public int rClick = 0;
    public int lastLClick = -1;
    public int lastRClick = -1;
    public String username = "";
    public boolean increaseTime = false;
    AVLTree tree = new AVLTree();
    Thread timeThread = new Thread(){
        @Override
        public void run() {
            try {
                while(timeLimit>0 && isPlaying){
                    if(score >= 6669666){
                        youWin();
                    }
                    if(increaseTime){
                        increaseTime = false;
                        timeLimit+=timeLimit*0.1;
                    }
                    sleep(100);
                    timeLimit-=100;
                    String timeText = Integer.toString(timeLimit/1000)+'.'+Integer.toString((timeLimit/100)%10);
                    labelTime.setText(timeText);
                }
                if(isPlaying){
                    youDied();
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(TestInGameScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestInGameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    public class CirclePanel extends JPanel {
        private int value;
        private int type;
        public CirclePanel(int value) {
            this.value = value;
            type = 0;
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!isPlaying){
                        return;
                    }
                    if(type != 0){
                        if(type == 1){ //left
                            lClick--;
                            lastLClick = -1;
                        }
                        else if(type == 2){ //right
                            rClick--;
                            lastRClick = -1;
                        }
                        type = 0;
                    }
                    else if(e.getButton() == MouseEvent.BUTTON1 && lClick == 0 && getValue() != -1){ //left
                        type = 1;
                        lClick++;
                        lastLClick = getValue();
                    }
                    else if(e.getButton() == MouseEvent.BUTTON3 && rClick == 0 && getValue() != -1){ //right
                        type = 2;
                        rClick++;
                        lastRClick = getValue();
                    }
                    repaint();
                }
            });
        }
        @Override
        protected void paintComponent(Graphics g) {
            if(value == -1){
                g.setColor(Color.WHITE);
                g.fillOval(0, 0, getWidth(), getHeight());
                return;
            }
            if(type == 1){
                g.setColor(Color.PINK);
            }
            else if(type == 2){
                g.setColor(Color.CYAN);
            }
            else{
                g.setColor(Color.LIGHT_GRAY);
            }
            g.fillOval(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.drawString(Integer.toString(value), getWidth()/2 - 6, getWidth()/2 + 6);
        }
        public void setValue(int value){
            if(value == -1){
                this.type = 0;
            }
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    /*
     * Creates new form InGameScreen
     */
    public void initMyComponents(){
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 210, 1156, 142));
        image.setVisible(false);
        pack();
    }
    public TestInGameScreen(String username) {
        this.username = username;
        initMyComponents();
        initComponents();
        timeThread.start();
        panel_R.setBackground(Color.CYAN);
        panel_L.setBackground(Color.PINK);
        AVLTree.Node root = null;
        ArrayList randNumbers = new ArrayList();
        for(int i = 1; i <= 50; i++){
            randNumbers.add(i);
        }
        Collections.shuffle(randNumbers);
        int maxElements = getRandomIntegerBetweenRange(5,15);
        for(int i = 0; i < maxElements; i++){
            root = tree.insert(root, (int)randNumbers.get(i));
        }
        String nextInteraction = "";
        nextInteraction+="insert: ";
        nextInteraction+=(int)randNumbers.get(maxElements);
        answerLabel.setText(nextInteraction);
        ArrayList a = new ArrayList();
        a = tree.treeToArray(root);
//        tree.print(root);
        root = tree.fakeInsert(root, (int)randNumbers.get(maxElements));
        updateValues(a);
    }
    private void updateValues(ArrayList a){
        try{
            panel_1.setValue((int) a.get(0));
            panel_2.setValue((int) a.get(1));
            panel_3.setValue((int) a.get(2));
            panel_4.setValue((int) a.get(3));
            panel_5.setValue((int) a.get(4));
            panel_6.setValue((int) a.get(5));
            panel_7.setValue((int) a.get(6));
            panel_8.setValue((int) a.get(7));
            panel_9.setValue((int) a.get(8));
            panel_10.setValue((int) a.get(9));
            panel_11.setValue((int) a.get(10));
            panel_12.setValue((int) a.get(11));
            panel_13.setValue((int) a.get(12));
            panel_14.setValue((int) a.get(13));
            panel_15.setValue((int) a.get(14));
            panel_16.setValue((int) a.get(15));
            panel_17.setValue((int) a.get(16));
            panel_18.setValue((int) a.get(17));
            panel_19.setValue((int) a.get(18));
            panel_20.setValue((int) a.get(19));
            panel_21.setValue((int) a.get(20));
            panel_22.setValue((int) a.get(21));
            panel_23.setValue((int) a.get(22));
            panel_24.setValue((int) a.get(23));
            panel_25.setValue((int) a.get(24));
            panel_26.setValue((int) a.get(25));
            panel_27.setValue((int) a.get(26));
            panel_28.setValue((int) a.get(27));
            panel_29.setValue((int) a.get(28));
            panel_30.setValue((int) a.get(29));
            panel_31.setValue((int) a.get(30));
        }
        catch(Exception e){
                
        }
    }
    public static int getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panel_11 = new CirclePanel(-1);
        panel_30 = new CirclePanel(-1);
        panel_29 = new CirclePanel(-1);
        panel_28 = new CirclePanel(-1);
        panel_27 = new CirclePanel(-1);
        panel_26 = new CirclePanel(-1);
        panel_25 = new CirclePanel(-1);
        panel_24 = new CirclePanel(-1);
        panel_23 = new CirclePanel(-1);
        panel_22 = new CirclePanel(-1);
        panel_21 = new CirclePanel(-1);
        panel_20 = new CirclePanel(-1);
        panel_19 = new CirclePanel(-1);
        panel_18 = new CirclePanel(-1);
        panel_17 = new CirclePanel(-1);
        panel_16 = new CirclePanel(-1);
        panel_31 = new CirclePanel(-1);
        panel_14 = new CirclePanel(-1);
        panel_13 = new CirclePanel(-1);
        panel_12 = new CirclePanel(-1);
        panel_15 = new CirclePanel(-1);
        panel_10 = new CirclePanel(-1);
        panel_9 = new CirclePanel(-1);
        panel_8 = new CirclePanel(-1);
        panel_4 = new CirclePanel(-1);
        panel_5 = new CirclePanel(-1);
        panel_6 = new CirclePanel(-1);
        panel_7 = new CirclePanel(-1);
        panel_3 = new CirclePanel(-1);
        panel_2 = new CirclePanel(-1);
        panel_1 = new CirclePanel(-1);
        panel_L = new java.awt.Panel();
        panel_R = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        answerLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelTime = new javax.swing.JLabel();
        labelScore = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panel_11Layout = new javax.swing.GroupLayout(panel_11);
        panel_11.setLayout(panel_11Layout);
        panel_11Layout.setHorizontalGroup(
            panel_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_11Layout.setVerticalGroup(
            panel_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 40, 40));

        javax.swing.GroupLayout panel_30Layout = new javax.swing.GroupLayout(panel_30);
        panel_30.setLayout(panel_30Layout);
        panel_30Layout.setHorizontalGroup(
            panel_30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_30Layout.setVerticalGroup(
            panel_30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, -1, -1));

        javax.swing.GroupLayout panel_29Layout = new javax.swing.GroupLayout(panel_29);
        panel_29.setLayout(panel_29Layout);
        panel_29Layout.setHorizontalGroup(
            panel_29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_29Layout.setVerticalGroup(
            panel_29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));

        javax.swing.GroupLayout panel_28Layout = new javax.swing.GroupLayout(panel_28);
        panel_28.setLayout(panel_28Layout);
        panel_28Layout.setHorizontalGroup(
            panel_28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_28Layout.setVerticalGroup(
            panel_28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, -1, -1));

        javax.swing.GroupLayout panel_27Layout = new javax.swing.GroupLayout(panel_27);
        panel_27.setLayout(panel_27Layout);
        panel_27Layout.setHorizontalGroup(
            panel_27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_27Layout.setVerticalGroup(
            panel_27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, -1));

        javax.swing.GroupLayout panel_26Layout = new javax.swing.GroupLayout(panel_26);
        panel_26.setLayout(panel_26Layout);
        panel_26Layout.setHorizontalGroup(
            panel_26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_26Layout.setVerticalGroup(
            panel_26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, -1, -1));

        javax.swing.GroupLayout panel_25Layout = new javax.swing.GroupLayout(panel_25);
        panel_25.setLayout(panel_25Layout);
        panel_25Layout.setHorizontalGroup(
            panel_25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_25Layout.setVerticalGroup(
            panel_25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        javax.swing.GroupLayout panel_24Layout = new javax.swing.GroupLayout(panel_24);
        panel_24.setLayout(panel_24Layout);
        panel_24Layout.setHorizontalGroup(
            panel_24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_24Layout.setVerticalGroup(
            panel_24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, -1, -1));

        javax.swing.GroupLayout panel_23Layout = new javax.swing.GroupLayout(panel_23);
        panel_23.setLayout(panel_23Layout);
        panel_23Layout.setHorizontalGroup(
            panel_23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_23Layout.setVerticalGroup(
            panel_23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, -1));

        javax.swing.GroupLayout panel_22Layout = new javax.swing.GroupLayout(panel_22);
        panel_22.setLayout(panel_22Layout);
        panel_22Layout.setHorizontalGroup(
            panel_22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_22Layout.setVerticalGroup(
            panel_22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        javax.swing.GroupLayout panel_21Layout = new javax.swing.GroupLayout(panel_21);
        panel_21.setLayout(panel_21Layout);
        panel_21Layout.setHorizontalGroup(
            panel_21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_21Layout.setVerticalGroup(
            panel_21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        javax.swing.GroupLayout panel_20Layout = new javax.swing.GroupLayout(panel_20);
        panel_20.setLayout(panel_20Layout);
        panel_20Layout.setHorizontalGroup(
            panel_20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_20Layout.setVerticalGroup(
            panel_20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));

        javax.swing.GroupLayout panel_19Layout = new javax.swing.GroupLayout(panel_19);
        panel_19.setLayout(panel_19Layout);
        panel_19Layout.setHorizontalGroup(
            panel_19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_19Layout.setVerticalGroup(
            panel_19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        javax.swing.GroupLayout panel_18Layout = new javax.swing.GroupLayout(panel_18);
        panel_18.setLayout(panel_18Layout);
        panel_18Layout.setHorizontalGroup(
            panel_18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_18Layout.setVerticalGroup(
            panel_18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        javax.swing.GroupLayout panel_17Layout = new javax.swing.GroupLayout(panel_17);
        panel_17.setLayout(panel_17Layout);
        panel_17Layout.setHorizontalGroup(
            panel_17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_17Layout.setVerticalGroup(
            panel_17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        javax.swing.GroupLayout panel_16Layout = new javax.swing.GroupLayout(panel_16);
        panel_16.setLayout(panel_16Layout);
        panel_16Layout.setHorizontalGroup(
            panel_16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_16Layout.setVerticalGroup(
            panel_16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, -1));

        javax.swing.GroupLayout panel_31Layout = new javax.swing.GroupLayout(panel_31);
        panel_31.setLayout(panel_31Layout);
        panel_31Layout.setHorizontalGroup(
            panel_31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_31Layout.setVerticalGroup(
            panel_31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_31, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 40, 40));

        javax.swing.GroupLayout panel_14Layout = new javax.swing.GroupLayout(panel_14);
        panel_14.setLayout(panel_14Layout);
        panel_14Layout.setHorizontalGroup(
            panel_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_14Layout.setVerticalGroup(
            panel_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, -1, -1));

        javax.swing.GroupLayout panel_13Layout = new javax.swing.GroupLayout(panel_13);
        panel_13.setLayout(panel_13Layout);
        panel_13Layout.setHorizontalGroup(
            panel_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_13Layout.setVerticalGroup(
            panel_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, -1));

        javax.swing.GroupLayout panel_12Layout = new javax.swing.GroupLayout(panel_12);
        panel_12.setLayout(panel_12Layout);
        panel_12Layout.setHorizontalGroup(
            panel_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_12Layout.setVerticalGroup(
            panel_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        javax.swing.GroupLayout panel_15Layout = new javax.swing.GroupLayout(panel_15);
        panel_15.setLayout(panel_15Layout);
        panel_15Layout.setHorizontalGroup(
            panel_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_15Layout.setVerticalGroup(
            panel_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 40, 40));

        javax.swing.GroupLayout panel_10Layout = new javax.swing.GroupLayout(panel_10);
        panel_10.setLayout(panel_10Layout);
        panel_10Layout.setHorizontalGroup(
            panel_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_10Layout.setVerticalGroup(
            panel_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        javax.swing.GroupLayout panel_9Layout = new javax.swing.GroupLayout(panel_9);
        panel_9.setLayout(panel_9Layout);
        panel_9Layout.setHorizontalGroup(
            panel_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_9Layout.setVerticalGroup(
            panel_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        javax.swing.GroupLayout panel_8Layout = new javax.swing.GroupLayout(panel_8);
        panel_8.setLayout(panel_8Layout);
        panel_8Layout.setHorizontalGroup(
            panel_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_8Layout.setVerticalGroup(
            panel_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        javax.swing.GroupLayout panel_4Layout = new javax.swing.GroupLayout(panel_4);
        panel_4.setLayout(panel_4Layout);
        panel_4Layout.setHorizontalGroup(
            panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_4Layout.setVerticalGroup(
            panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        javax.swing.GroupLayout panel_5Layout = new javax.swing.GroupLayout(panel_5);
        panel_5.setLayout(panel_5Layout);
        panel_5Layout.setHorizontalGroup(
            panel_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_5Layout.setVerticalGroup(
            panel_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        javax.swing.GroupLayout panel_6Layout = new javax.swing.GroupLayout(panel_6);
        panel_6.setLayout(panel_6Layout);
        panel_6Layout.setHorizontalGroup(
            panel_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_6Layout.setVerticalGroup(
            panel_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));
        panel_6.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout panel_7Layout = new javax.swing.GroupLayout(panel_7);
        panel_7.setLayout(panel_7Layout);
        panel_7Layout.setHorizontalGroup(
            panel_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_7Layout.setVerticalGroup(
            panel_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, -1, -1));

        javax.swing.GroupLayout panel_3Layout = new javax.swing.GroupLayout(panel_3);
        panel_3.setLayout(panel_3Layout);
        panel_3Layout.setHorizontalGroup(
            panel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_3Layout.setVerticalGroup(
            panel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

        javax.swing.GroupLayout panel_2Layout = new javax.swing.GroupLayout(panel_2);
        panel_2.setLayout(panel_2Layout);
        panel_2Layout.setHorizontalGroup(
            panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_2Layout.setVerticalGroup(
            panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        javax.swing.GroupLayout panel_1Layout = new javax.swing.GroupLayout(panel_1);
        panel_1.setLayout(panel_1Layout);
        panel_1Layout.setHorizontalGroup(
            panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_1Layout.setVerticalGroup(
            panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));
        panel_1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout panel_32Layout = new javax.swing.GroupLayout(panel_L);
        panel_L.setLayout(panel_32Layout);
        panel_32Layout.setHorizontalGroup(
            panel_32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_32Layout.setVerticalGroup(
            panel_32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_L, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 40, 40));

        javax.swing.GroupLayout panel_33Layout = new javax.swing.GroupLayout(panel_R);
        panel_R.setLayout(panel_33Layout);
        panel_33Layout.setHorizontalGroup(
            panel_33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panel_33Layout.setVerticalGroup(
            panel_33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(panel_R, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 40, 40));

        jLabel1.setText("Right Rotation");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, -1, -1));

        jLabel2.setText("Left Rotation");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        jButton1.setText("ANSWER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(TestInGameScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 130, -1));

        jLabel3.setText("Next value to - > ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, -1));

        answerLabel.setText("insert/remove: value");
        getContentPane().add(answerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, -1, -1));
        
        jLabel5.setText("Time: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        labelTime.setText("20.0");
        getContentPane().add(labelTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        labelScore.setText("0");
        getContentPane().add(labelScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        jLabel8.setText("Score:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        pack();
    }// </editor-fold>   
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if(!isPlaying){
            exit(0);
        }
        if(tree.answer.getFirst() == lastLClick && tree.answer.getSecond() == lastRClick){
            nextRound();
            repaint();
        }
        else{
            youDied();
        }
    } 
    private void nextRound(){
        score+=timeLimit/100;
        increaseTime = true;
        labelScore.setText(Integer.toString(score));
        ArrayList aux = new ArrayList();
        for(int i = 1; i <= 50; i++){
            aux.add(-1);
        }
        lClick = 0;
        rClick = 0;
        lastLClick = -1;
        lastRClick = -1;
        updateValues(aux);
        tree = new AVLTree();
        AVLTree.Node root = null;
        ArrayList randNumbers = new ArrayList();
        for(int i = 1; i <= 50; i++){
            randNumbers.add(i);
        }
        Collections.shuffle(randNumbers);
        int maxElements = getRandomIntegerBetweenRange(5,15);
        for(int i = 0; i < maxElements; i++){
            root = tree.insert(root, (int)randNumbers.get(i));
        }
        String nextInteraction = "";
        nextInteraction+="insert: ";
        nextInteraction+=(int)randNumbers.get(maxElements);
        answerLabel.setText(nextInteraction);
        ArrayList a = new ArrayList();
        a = tree.treeToArray(root);
//        tree.print(root);
        root = tree.fakeInsert(root, (int)randNumbers.get(maxElements));
        updateValues(a);
//        tree.print(root);
//        System.out.printf("%d %d\n", (int)tree.answer.getFirst(), (int)tree.answer.getSecond());
    }
    private void youWin(){
        isPlaying = false;
        JOptionPane.showMessageDialog(null, "This is never meant to happen so we have never finished this function...");
        JOptionPane.showMessageDialog(null, "So...");
        JOptionPane.showMessageDialog(null, "That's embarrassing...");
        JOptionPane.showMessageDialog(null, "Please just hit OK and I will close the game for you...");
        JOptionPane.showMessageDialog(null, "Do not come back, you cheater!");
        for(int i = 0; i < 100; i++){
            JOptionPane.showMessageDialog(null, "");
        }
        exit(666);
    }
    private void youDied() throws IOException{
        updateScore();
        jButton1.setText("EXIT");
        isPlaying = false;
        image.setVisible(true);
//        ImageIcon icon = new ImageIcon("images/youDied.jpg");
//        JLabel image = new JLabel(icon);
//        getContentPane().add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 210, 1156, 142));
//        setComponentZOrder(image, 0);
        pack();
        repaint();
//        System.out.println("YOU DIED");
    }
    private void updateScore() throws IOException{
        String[] name = new String[10];
        int[] scores = new int[10];
        File arquivo = new File(".record");
        try{
            BufferedReader br = new BufferedReader(new FileReader(arquivo.getAbsolutePath()));
            for(int aux = 0; aux < 10; aux++){
                String auxS = br.readLine();
                name[aux] = auxS;
                auxS = br.readLine();
                scores[aux] = Integer.valueOf(auxS);
            }
        }
        catch(Exception e){
            
        }
        
        FileWriter arq = null;
        arq = new FileWriter(".record");
        PrintWriter printToFile = null;
//        for(int aux = 0; aux < 10; aux++){
//            System.out.print(name[aux]);
//            System.out.println("");
//            System.out.print(scores[aux]);
//            System.out.println("");
//        }
        boolean isAdded = false;
        int maxAdds = 10;
        for(int aux = 0; aux < maxAdds; aux++){
            if(score > scores[aux] && !isAdded){
                arq.write(username);
                arq.write("\n");
                arq.write(Integer.toString(score));
                arq.write("\n");
                isAdded = true;
                maxAdds--;
                aux--;
            }
            else{
                arq.write(name[aux]);
                arq.write("\n");
                arq.write(Integer.toString(scores[aux]));
                arq.write("\n");
            }
        }
        arq.close();
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(InGameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InGameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InGameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InGameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new InGameScreen().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify                     
    private CirclePanel panel_1;
    private CirclePanel panel_10;
    private CirclePanel panel_11;
    private CirclePanel panel_12;
    private CirclePanel panel_13;
    private CirclePanel panel_14;
    private CirclePanel panel_15;
    private CirclePanel panel_16;
    private CirclePanel panel_17;
    private CirclePanel panel_18;
    private CirclePanel panel_19;
    private CirclePanel panel_2;
    private CirclePanel panel_20;
    private CirclePanel panel_21;
    private CirclePanel panel_22;
    private CirclePanel panel_23;
    private CirclePanel panel_24;
    private CirclePanel panel_25;
    private CirclePanel panel_26;
    private CirclePanel panel_27;
    private CirclePanel panel_28;
    private CirclePanel panel_29;
    private CirclePanel panel_3;
    private CirclePanel panel_30;
    private CirclePanel panel_31;
    private CirclePanel panel_4;
    private CirclePanel panel_5;
    private CirclePanel panel_6;
    private CirclePanel panel_7;
    private CirclePanel panel_8;
    private CirclePanel panel_9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel answerLabel;
    private java.awt.Panel panel_L;
    private java.awt.Panel panel_R;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelScore;
    private javax.swing.JLabel labelTime;
    // End of variables declaration                   
}
