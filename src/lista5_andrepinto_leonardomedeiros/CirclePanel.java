/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista5_andrepinto_leonardomedeiros;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author andrelucax
 */
public class CirclePanel extends JPanel {
    private String value;
    public CirclePanel(String value) {
        this.value = value;
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawString(value, getWidth()/2 - 6, getWidth()/2 + 6);
    }
}
