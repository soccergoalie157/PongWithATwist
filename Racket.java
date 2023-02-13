/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Bibek Singh Kahlon
 */
public class Racket {
    
    // Y coordinate for racket
    int y;
    // Distance in y direction for when key is pressed
    int move;
    // For player identification
    int player;
    
    public Racket(int y, int player) {
        
        // Sets the y coordinate and player number according to the arguments
        this.y = y;
        this.player = player;
        
    }
    
    public void paint(Graphics g) {
        
        // Draws the player in white according to the player number
        g.setColor(Color.WHITE);
        switch (player) {
            case 1: 
                g.fillRect(0, y, 20, 100);
                break;
            case 2:
                g.fillRect(980, y, 20, 100);
                break;
        }
    }
    
    public void keyPressed(KeyEvent e) {
        
        // Keypresses actions
        int key = e.getKeyCode();
        if (player == 1) {
            switch (key) { 
                // Moves player 1 up if w key is pressed
                case KeyEvent.VK_W:
                    move = -10;
                    break;
                // Moves player 1 down if s key is pressed
                case KeyEvent.VK_S:
                    move = 10;
                    break;
            }
        } else {
            switch (key) {
                // Moves player 2 up if up arrow key is pressed
                case KeyEvent.VK_UP:
                    move = -10;
                    break;
                    // Moves player 2 down if down arrow key is pressed
                case KeyEvent.VK_DOWN:
                    move = 10;
                    break;
            }
        }  
        
    }
    
    public void keyReleased(KeyEvent e) {
        
        // Stops moving players when key is released
        int key = e.getKeyCode();
        if (player == 1) {
            switch (key) {   
                case KeyEvent.VK_W:
                    move = 0;
                    break;
                case KeyEvent.VK_S:
                    move = 0;
                    break;
            }
        } else {
            switch (key) {
                case KeyEvent.VK_UP:
                    move = 0;
                    break;
                case KeyEvent.VK_DOWN:
                    move = 0;
                    break;
            }
        }
        
    }
    
    public void direction() {
        
        // Moves racket in direction depending on key pressed / released
        y += move;
        
    }
    
}
