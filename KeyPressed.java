/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.*;

/**
 *
 * @author Bibek Singh Kahlon
 */

public class KeyPressed implements KeyListener {
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    // Actions for when keys are pressed
    public void keyPressed(KeyEvent e) {
        
        Panel.player1.keyPressed(e);
        Panel.player2.keyPressed(e);
        
    }
    
    @Override
    // Actions for when keys are released
    public void keyReleased(KeyEvent e) {
        
        Panel.player1.keyReleased(e);
        Panel.player2.keyReleased(e);
        
    }
}
