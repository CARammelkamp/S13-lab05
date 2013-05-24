package edu.ucsb.cs56.S13.drawings.wmateer.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing Pokeballs and Masterballs
 * 
 * @author Will Mateer
 * @version for CS56, lab05, Spring 2013
 */


public class AllMyDrawings
{
    /** 
	 Draw a different picture with 3 Pokeballs
	 @param g2 Graphics2D input which draws the object
     */
     

    public static void drawPicture1(Graphics2D g2) {

	Stroke thick = new BasicStroke (6.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	
	// Draw some Pokeballs.
		
	Pokeball middleBall = new Pokeball(200,200,400,400);
	g2.setColor(Color.GREEN);
	g2.draw(middleBall);
		
	Shape testBallTwo = ShapeTransforms.scaledCopyOfLL(middleBall,0.5,0.5);
	testBallTwo = ShapeTransforms.translatedCopyOf(testBallTwo,150,0);
	g2.setColor(Color.MAGENTA); 
	g2.draw(testBallTwo);
		
	testBallTwo = ShapeTransforms.scaledCopyOfLL(testBallTwo,4,4);
	testBallTwo = ShapeTransforms.translatedCopyOf(testBallTwo,150,0);
	g2.setColor(Color.PINK); 
	g2.draw(testBallTwo); 
		
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
		
	g2.drawString("A bunch of Pokeballs:Drawing Choice 1", 20,20);
    
	}

	/** 
	 Draw a different picture with 4 Pokeballs and 2 Masterballs
	 @param g2 Graphics2D input which draws the object
	 */
   public static void drawPicture2(Graphics2D g2) {

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       

	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	
	// Draw some Masterballs and Pokeballs
	
	Masterball middleBall = new Masterball(200,200,400,400);
	g2.setColor(Color.ORANGE);
	g2.draw(middleBall);
	   
	Pokeball smallBall = new Pokeball(200,200,50,50);
	g2.setColor(Color.CYAN);
	g2.draw(smallBall);
		
	Shape testBallOne = ShapeTransforms.scaledCopyOfLL(smallBall,3,2);
	testBallOne = ShapeTransforms.translatedCopyOf(testBallOne,50,300);
	g2.setColor(Color.MAGENTA); 
	g2.draw(testBallOne);
	
	Shape testBallTwo = ShapeTransforms.scaledCopyOfLL(middleBall,1.2,1.2);
	testBallTwo = ShapeTransforms.translatedCopyOf(testBallTwo,-50,50);
	testBallTwo = ShapeTransforms.rotatedCopyOf(testBallTwo,Math.PI);
	g2.setColor(Color.RED); 
	g2.draw(testBallTwo);
	   
	Shape testBallThree = ShapeTransforms.rotatedCopyOf(testBallOne, Math.PI/4.0);
	testBallThree = ShapeTransforms.translatedCopyOf(testBallOne,300,-300);
	g2.setColor(Color.PINK);
	g2.draw(testBallThree);
	   
	testBallThree = ShapeTransforms.rotatedCopyOf(testBallOne, Math.PI/4.0);
	testBallThree = ShapeTransforms.translatedCopyOf(testBallThree,-250,-250);
	g2.setColor(Color.YELLOW);
	g2.draw(testBallThree);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
		
	g2.drawString("A bunch of Pokeballs and Masterballs:Drawing Choice 2", 20,20);
	   
	}
  
    /** 
	 Draw a different picture with 4 Masterballs
	 @param g2 Graphics2D input which draws the object
     */

    public static void drawPicture3(Graphics2D g2) {
	
	Stroke orig=g2.getStroke();
	Stroke thick = new BasicStroke (6.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	g2.setStroke(thick);
		
	// Draw some Masterballs.
		
	Masterball largeBall = new Masterball(0,0,600,600);
	Masterball middleBall = new Masterball(450,200,300,300);
	Masterball smallBall = new Masterball(300,300,85,170);
		
	Masterball testBall = new Masterball(60,60,240,240);
		
	g2.setColor(Color.MAGENTA);
	g2.draw(testBall);
		
	thick = new BasicStroke (3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	g2.setStroke(thick);
	g2.setColor(Color.GREEN);
	g2.draw(middleBall);
	g2.setColor(Color.RED);
	
	thick = new BasicStroke (12.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	g2.setStroke(thick);
	g2.draw(largeBall);
	
	g2.setColor(Color.BLUE);
	g2.draw(smallBall);
		
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of MasterBalls:Drawing Choice 3", 20,20);
		
	}	
}
