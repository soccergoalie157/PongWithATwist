/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Bibek Singh Kahlon
 */
public class RandomLines {
    
    // Random y and x position for random wall
    int randX;
    int randY;
    // Y and x position for random wall
    int xPos;
    int yPos;
    // For random position
    Random rand;
    
    public RandomLines() {
        
        rand = new Random();
        // Genrates number for random position
        this.randX = rand.nextInt(600);
        this.randY = rand.nextInt(400);
        // Position for wall is set
        this.xPos = randX + 120;
        this.yPos = randY + 100;
        
    }
    
    public void paint(Graphics g) {
        
        // Paints wall black if one of the scores is more than 3
        if (Panel.player1Score > 3 || Panel.player2Score > 3) {
            g.setColor(Color.BLACK);
        } else {
            // Paints white before any score is more than 3
            g.setColor(Color.WHITE);
        }
        g.fillRect(xPos, yPos, 15, 150);
        
    }
    
}
