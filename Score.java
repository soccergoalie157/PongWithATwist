/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Bibek Singh Kahlon
 */
public class Score {
    
    BasicStroke line;
    
    public Score() {
        
        // Creates a custom line design
        line = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, new float[]{9}, 0);
        
    }
    
    public void paint(Graphics g) {
        
        // Draws the lines, the score and the player number on the designated side
        Graphics2D g2 = (Graphics2D) g;
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", Font.BOLD, 55));
        
        g.drawLine(0, 100, 1000, 100);
        g.drawString(String.valueOf(Panel.player1Score), 400, 70);
        g.drawString(String.valueOf(Panel.player2Score), 560, 70);
        g.drawString("P1", 50, 70);
        g.drawString("P2", 875, 70);
        
        g2.setStroke(line);
        g2.drawLine(500, 0, 500, 700);
        g2.dispose();
        
    }
    
}
