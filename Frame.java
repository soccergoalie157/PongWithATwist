/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javax.swing.*;

/**
 *
 * @author Bibek Singh Kahlon
 */
public class Frame {
    
    Panel newPanel;
    public static JFrame frame;
    
    public Frame() {
        
        // Sets the characteristics for the JFrame
        newPanel = new Panel();
        frame = new JFrame();
        frame.add(newPanel);
        frame.setTitle("Pong Game Project - Bibek and Chirag");
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       
    }
    
}
