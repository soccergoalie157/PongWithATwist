package pong;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
/**
 *
 * @author chiragkarki15
 */
public class EndScreen implements ActionListener {
    
    // All of the JFrame components
    JFrame frame;
    JButton button;
    JButton button2;
    JButton button3;
    JLabel title;
    // Folder and score file directory
    File folder = new File("C:\\Score");
    File score = new File("C:\\Score\\ScoreSheet.txt");
    // For winner of the game
    public static String winner;
    // For game frame
    Frame gameFrame;
 
    public EndScreen(){

        // Sets characteristics for winner label
        title = new JLabel(winner);
        title.setBounds(260,50,900,100);
        title.setForeground(Color.GREEN);
        title.setFont(new Font("Verdana",Font.BOLD,48));

        // Sets characteristics for play again button
        button = new JButton("Play Again?");
        button.setBounds(175,200,200,100);
        button.addActionListener(this);
        button.setBackground(Color.GREEN);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Verdana", Font.BOLD, 20));
        button.setFocusable(false);

        // Sets characteristics for exit button
        button2 = new JButton("Exit");
        button2.setBounds(525,200,200,100);
        button2.addActionListener(this);
        button2.setBackground(Color.GREEN);
        button2.setForeground(Color.BLACK);
        button2.setFont(new Font("Verdana", Font.BOLD, 20));
        button2.setFocusable(false);

        // Sets characteristics for scoresheet button
        button3 = new JButton("Scoresheet");
        button3.setBounds(350, 350, 200, 100);
        button3.addActionListener(this);
        button3.setBackground(Color.GREEN);
        button3.setForeground(Color.BLACK);
        button3.setFont(new Font("Verdana", Font.BOLD, 20));
        button3.setFocusable(false);
        
        // Sets characteristics for the frame
        frame = new JFrame("End Screen");
        frame.setSize(new Dimension (900,600));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(title);
        frame.add(button);
        frame.add(button2);
        frame.add(button3);
        frame.setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e){

        // Actions for play again button
        if (e.getSource() == button){
            // Resets score variables, game frame pops up and endscreen disappears
            Panel.player1Score = 0;
            Panel.player2Score = 0;
            gameFrame = new Frame();
            frame.setVisible(false);
        }    

        // Actions for exit button
        if (e.getSource() == button2){
            // Ends program
            System.exit(0);
        }

        // Actions for scoresheet button
        if (e.getSource() == button3) {
            // Creates folder if it does not exist
            if (!folder.exists()) {
                folder.mkdir();
            }
            
            try {
                // Creates file for scoresheet if not already made
                if (!score.exists()) {
                    score.createNewFile();
                }
                
                FileWriter fw = new FileWriter(score.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                
                // Writes all the games scores
                for (int i = 0; i <= Panel.p1Score.size() - 1; i++) {
                    bw.write("Game " + (i + 1) + "\n");
                    bw.write("Player 1: " + Panel.p1Score.get(i) + "\n");
                    bw.write("Player 2: " + Panel.p2Score.get(i) + "\n");
                    bw.write("\n");
                }
                
                bw.close();
            
            } catch (IOException ez) {
                System.out.println(e);
            }
            
            try {      
                // Opens text flie
                Desktop desktop = Desktop.getDesktop();  
                if(score.exists()) {          
                    desktop.open(score);
                }
            } catch(IOException ez) {  
                ez.printStackTrace();  
            }
            
        }
        
    } 

}