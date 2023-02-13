/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Bibek Singh Kahlon
 */
public class Panel extends JPanel implements ActionListener{
    
    boolean running = false;
    Timer timer;
    Random random;
    Ball newBall;
    Score score;
    RandomLines lines;
    public static Racket player1;
    public static Racket player2;
    public static int player1Score;
    public static int player2Score;
    public static Dimension size = new Dimension(1000, 700);
    public static ArrayList p1Score = new ArrayList();
    public static ArrayList p2Score = new ArrayList();
    
    public Panel() {
        
        // Sets characteristics for the JPanel, creates objects for all of the components
        this.setFocusable(true);
        this.addKeyListener(new KeyPressed());
        this.setPreferredSize(size);
        this.setBackground(Color.BLACK);
        random = new Random();
        player1 = new Racket(350, 1);
        player2 = new Racket(350, 2);
        newBall = new Ball();
        score = new Score();
        lines = new RandomLines();
        // New timer is created for the JPanel, starts the timer
        running = true;
        timer = new Timer(35, this);
        timer.start();
        
    }

    @Override
    public void paintComponent(Graphics g) {

        // The JPanel is the component that the program is painting on, uses graphics to draw
        super.paintComponent(g);
        draw(g);
        
	}

    
    public void draw(Graphics g) {
      
        // Draws all of the components
        player1.paint(g);
        player2.paint(g);
        newBall.paint(g);
        lines.paint(g);
        score.paint(g);
        
    }
    
    public void move() {
        
        // Calls the move methods for all of the moving components
        player1.direction();
        player2.direction();
        newBall.direction(); 
        
    }
    
    public void collision() {
        
        // If ball hits top, go down
        if (newBall.yCoor <= 100) {
            newBall.moveY *= -1;
        }
        // If ball hits bottom, go up
        if (newBall.yCoor >= 685) {
            newBall.moveY *= -1;
        }
        
        // If left player hits top, stay at that position
        if (player1.y <= 100) {
            player1.y = 100;
        } 
        // If left player hits bottom, stay at that position
        if (player1.y >= 600) {
            player1.y = 600;
        } 
        // If right player hits top, stay at that position
        if (player2.y <= 100) {
            player2.y = 100;
        } 
        // If right player hits bottom, stay at that position
        if (player2.y >= 600) {
            player2.y = 600;
        }
        
        // If ball hits left side, give right player a point, ball spawns again
        if (newBall.xCoor <= 0) {
            player2Score++;
            newBall = new Ball();
        }
        // If ball hits right side, give left player a point, ball spawns again
        if (newBall.xCoor >= 985) {
            player1Score++;
            newBall = new Ball();
        }
        
        // If player hits left racktet, ball goes right and speeds up and wall spawns in random location
        if ((newBall.xCoor < 20) && (newBall.xCoor > 0) && (newBall.yCoor < player1.y + 100) && (newBall.yCoor + 15 > player1.y)) {
            lines.randX = random.nextInt(600);
            lines.randY = random.nextInt(400);
            lines.xPos = lines.randX + 120;
            lines.yPos = lines.randY + 100;
            newBall.xCoor = 20;
            newBall.moveX--;
            newBall.moveX *= -1;
        }
        // If player hits right racktet, ball goes left and speeds up and wall spawns in random location
        if ((newBall.xCoor < 1000) && (newBall.xCoor > 965) && (newBall.yCoor < player2.y + 100) && (newBall.yCoor + 15 > player2.y)) {
            lines.randX = random.nextInt(600);
            lines.randY = random.nextInt(400);
            lines.xPos = lines.randX + 120;
            lines.yPos = lines.randY + 100;
            newBall.xCoor = 965;
            newBall.moveX++;
            newBall.moveX *= -1;
        }
        
        // If ball hits random wall, go in opposite direction
        if ((newBall.xCoor < lines.xPos + 15) && (newBall.xCoor > lines.xPos - 15) && (newBall.yCoor < lines.yPos + 150) && (newBall.yCoor + 15 > lines.yPos)) {
            newBall.moveX *= -1;
        }
        
        // If left player has a score of 7, game ends, player 1 is winner
        if (player1Score > 6) {
            EndScreen.winner = "Player 1 Wins!";
            p1Score.add(player1Score);
            p2Score.add(player2Score);
            running = false;
            EndScreen frame = new EndScreen();
            Frame.frame.setVisible(false);
        }
        // If right player has a score of 7, game ends, player 2 is the winner
        if (player2Score > 6) {
            EndScreen.winner = "Player 2 Wins!";
            p1Score.add(player1Score);
            p2Score.add(player2Score);
            running = false;
            EndScreen frame = new EndScreen();
            Frame.frame.setVisible(false);
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            
        // Calls move and collision methods and repaints component after movements
            if (running) {
                move();
                collision();
            }    
            repaint();
       
    }
    
}
