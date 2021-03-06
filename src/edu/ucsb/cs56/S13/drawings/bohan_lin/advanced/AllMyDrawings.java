package edu.ucsb.cs56.S13.drawings.bohan_lin.advanced;

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
 * A class with static methods for drawing various pictures
 * 
 * @author Phill Conrad 
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {
	HeadWithHair head1 = new HeadWithHair(100, 30, 50);
	g2.setColor(Color.RED);//draws a new red head
	g2.draw(head1);
	HeadWithHair head2 = new HeadWithHair(200, 200, 75);
	g2.setColor(Color.CYAN);//draws a new cyan head
	g2.draw(head2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING

	g2.drawString("A few heads by Bohan Lin", 20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	Head head1 = new Head(150, 150, 66);//draws a head
	g2.setColor(Color.BLUE);
	g2.draw(head1);
	
	//draws black head half size and 150 pixels in x direction
	Shape head2 = ShapeTransforms.scaledCopyOfLL(head1,0.5,0.5);
	head2 = ShapeTransforms.translatedCopyOf(head2,150,0);
	g2.setColor(Color.BLACK); g2.draw(head2);
	
	// Here's a head that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	head2 = ShapeTransforms.scaledCopyOfLL(head2,4,4);
	head2 = ShapeTransforms.translatedCopyOf(head2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(head2); 
	
    
	Shape head3 = ShapeTransforms.rotatedCopyOf(head1, Math.PI/4.0);

	g2.draw(head3);
	
	HeadWithHair head4 = new HeadWithHair(50, 50, 20);
	g2.setColor(Color.GREEN);
	g2.draw(head4);
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of different heads by Bohan Lin", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of heads by Bohan Lin", 20,20);

	
	// Draw some heads and heads with hair.
	
       Head largeHead = new Head(100,50,100);
       HeadWithHair smallHead = new HeadWithHair(50,50,50);
       
       g2.setColor(Color.RED);     g2.draw(largeHead);
       g2.setColor(Color.GREEN);   g2.draw(smallHead);
       
       
    }
    

}
