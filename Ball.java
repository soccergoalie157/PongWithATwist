
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.*;
import java.util.*;

/**
 *
 * @author Bibek Singh Kahlon
 */
public class Ball {
    
    // Starting coordinates for the ball
    int xCoor = 500;
    int yCoor = 400;
    // Ball movement
    int moveX;
    int moveY;
    // Ball speed
    int speed = 4;
    // For random number
    Random random;
    
    public Ball() {
        
        random = new Random();
        // Chooses a number between 0 and 2
        this.moveX = (random.nextInt(2) * speed);
        // If number is 0, go in opposite direction
        if (moveX == 0) {
            moveX = -1 * speed;
        } 
        
        // Chooses a number between 0 and 1
        this.moveY = (random.nextInt(2) * speed);
        // If number is 0, go in opposite direction
        if (moveY == 0) {
            moveY = -1 * speed;
        } 
        
    }
    
    public void paint(Graphics g) {
        
        // Ball color is white and draws ball at 500, 400 on the panel
        g.setColor(Color.WHITE);
        g.fillOval(xCoor, yCoor, 15, 15);
        
    }
    
    public void direction() {
        
        // Moves the ball in the desired direction
        xCoor += moveX;
        yCoor += moveY;
        
    }
    
}
