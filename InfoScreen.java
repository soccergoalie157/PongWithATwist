package pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author chiragkarki15
 */
public class InfoScreen implements ActionListener{

    // All of the components
    JFrame frame;
    JButton button;
    JButton button2;
    JLabel label;
    JLabel line1;
    JLabel line2;
    JLabel line3;
    JLabel line4;

    // For game frame
    Frame gameFrame;
    // For intro screen
    IntroScreen introscreen;
    
public InfoScreen(){
    
    // Sets characteristics for start game button
    button = new JButton("Start Game");
    button.setBounds(150,400,200,100);
    button.setFont(new Font("Verdana", Font.BOLD, 20));
    button.addActionListener(this);
    button.setBackground(Color.GREEN);
    button.setForeground(Color.BLACK);
    button.setFocusable(false);
    
    // Sets characteristics for return to intro screen button
    button2 = new JButton("Return");
    button2.setBounds(500,400,200,100);
    button2.setFont(new Font("Verdana", Font.BOLD, 20));
    button2.addActionListener(this);
    button2.setBackground(Color.GREEN);
    button2.setForeground(Color.BLACK);
    button2.setFocusable(false);
    
    // Sets characteristics for title of info screen
    label = new JLabel("Information");
    label.setBounds(350,15,900,100);
    label.setFont(new Font("Verdana", Font.BOLD, 42));
    label.setForeground(Color.GREEN);
    
    // Sets characteristics for first line of instructions
    line1 = new JLabel("Pong is a 2 player arcade game where users control paddles with (W and S) and (up and down arrow keys) to try to hit the ball");
    line1.setBounds(20,100,900,100);
    line1.setFont(new Font("Verdana",Font.BOLD,12));
    line1.setForeground(Color.GREEN);
    
    // Sets characteristics for second line of instructions
    line2 = new JLabel(" on the opponent's side. It’s as simple as it sounds however be wary of the random walls that could spawn in at any moment! ");
    line2.setBounds(20,150,900,100);
    line2.setFont(new Font("Verdana",Font.BOLD,12));
    line2.setForeground(Color.GREEN);
    
    // Sets characteristics for third line of instructions
    line3 = new JLabel(" However once a player hits 4 points, ALL walls become invisible!!");
    line3.setBounds(20,200,900,100);
    line3.setFont(new Font("Verdana",Font.BOLD,12));
    line3.setForeground(Color.GREEN);
    
    // Sets characteristics for fourth line of instructions
    line4 = new JLabel(" PS: First one to score 7 points wins!!!");
    line4.setBounds(20,250,900,100);
    line4.setFont(new Font("Verdana",Font.BOLD,12));
    line4.setForeground(Color.GREEN);
    
    // Sets characteristics for frame
    frame = new JFrame("Info Screen");
    frame.setSize(new Dimension (900,600));
    frame.setLayout(null);
    frame.getContentPane().setBackground(Color.BLACK);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(button);
    frame.add(button2);
    frame.add(label);
    frame.add(line1);
    frame.add(line2);
    frame.add(line3);
    frame.add(line4);
    frame.setVisible(true);
    frame.setResizable(false);
}
@Override
public void actionPerformed(ActionEvent e){
    
    // Actions for start game button
    if (e.getSource() == button){
        // Opens a game frame and closes this frame
        gameFrame = new Frame();
        frame.setVisible(false);
    }    
 
    // Actions for return button
    if (e.getSource() == button2){
        // Opens a intro screen frame and closes this frame
        introscreen = new IntroScreen();
        frame.setVisible(false);
    }
    
    }
}    
   


