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
import javax.swing.JPanel;

/**
 * @author andrelucax
 */
public class CirclePanela extends JPanel {
    private int value;
    private int type;
    public CirclePanela(int value) {
        this.value = value;
        type = 0;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(type != 0){
                    type = 0;
                }
                else if(e.getButton() == MouseEvent.BUTTON1){ //left
                    type = 1;
                }
                else if(e.getButton() == MouseEvent.BUTTON3){ //right
                    type = 2;
                }
                repaint();
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        System.out.println(type);
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
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
