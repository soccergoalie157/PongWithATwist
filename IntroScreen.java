package pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author chiragkarki15
 */
public class IntroScreen implements ActionListener{
 
    // All of the components
    JFrame frame;
    JButton button;
    JButton button2;
    JLabel title;
    JLabel subtitle;
 
    // For the game frame
    Frame gameFrame;
    // For the intro screen
    InfoScreen infoscreen;
    
public IntroScreen(){
    
    // Sets characteristics for title of intro page
    title = new JLabel("PONG");
    title.setBounds(350,15,500,100);
    title.setFont(new Font("Comic sans",Font.BOLD,48));
    title.setForeground(Color.WHITE);
    
    // Sets characteristics for name label
    subtitle = new JLabel("By: Chirag and Bibek");
    subtitle.setBounds(250,75,500,100);
    subtitle.setFont(new Font("Comic sans",Font.ITALIC,36));
    subtitle.setForeground(Color.WHITE);
    
    // Sets characteristics for start game button
    button = new JButton("Start Game");
    button.setBounds(150,250,200,100);
    button.addActionListener(this);
    button.setFont(new Font("Verdana", Font.BOLD, 20));
    button.setBackground(Color.GREEN);
    button.setForeground(Color.BLACK);
    button.setFocusable(false);
    
    // Sets characteristics for information screen button
    button2 = new JButton("Information");
    button2.setBounds(500,250,200,100);
    button2.addActionListener(this);
    button2.setFont(new Font("Verdana", Font.BOLD, 20));
    button2.setBackground(Color.GREEN);
    button2.setForeground(Color.BLACK);
    button2.setFocusable(false);
    
    // Sets characteristics for frame
    frame = new JFrame("Intro Screen");
    frame.setSize(new Dimension (900,600));
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.BLACK);
    frame.add(title);
    frame.add(subtitle);
    frame.add(button);
    frame.add(button2);
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

    // Actions for information screen
    if (e.getSource() == button2){
        // Opens a information screen and closes this frame
        infoscreen = new InfoScreen();
        frame.setVisible(false);
    }
    

} 

}

