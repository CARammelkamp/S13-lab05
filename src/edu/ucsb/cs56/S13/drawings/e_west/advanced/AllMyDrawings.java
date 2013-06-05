package edu.ucsb.cs56.S13.drawings.e_west.advanced;

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
    /** Draw a picture with a few books, translated and scaled
     */

    public static void drawPicture1(Graphics2D g2) {
	Book b1 = new Book(100,250,50,75);
	g2.setColor(Color.RED);
	g2.draw(b1);

        // Make a black book that's half the size,
        // and moved over 150 pixels in x direction

        Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
        b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
        g2.setColor(Color.BLACK); g2.draw(b2);

        // Here's a house that's 4x as big (2x the original)
        // and moved over 150 more pixels to right.
        b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
        b2 = ShapeTransforms.translatedCopyOf(b2,150,0);

	Stroke orig=g2.getStroke();
        Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        g2.setStroke(thick);
        g2.setColor(new Color(0x002FA7));
        g2.draw(b2);



	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("by Evan West", 20,20);
    }


    /** Draw a picture with a few books, translated, scaled, rotated in many colors
     */
    public static void drawPicture2(Graphics2D g2) {
	Stroke orig = g2.getStroke();

	Book b1 = new Book(160,50,210,160);
	Book b2 = new Book(200,400,40,30);
	Book b3 = new Book(28,150,20,40);
	Book b4 = new Book(340,268,50,40);

	g2.setColor(Color.RED);     g2.draw(b1);
	g2.setColor(Color.GREEN);   g2.draw(b2);
	g2.setColor(Color.BLUE);    g2.draw(b3);
	g2.setColor(Color.MAGENTA); g2.draw(b4);

	Stroke thick = new BasicStroke (6.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	g2.setStroke(thick);
	Shape s1 = ShapeTransforms.scaledCopyOfLL(b1,0.6,0.6);
	//s1 = ShapeTransforms.translatedCopyOf(s1,110,50);
	s1 = ShapeTransforms.rotatedCopyOf(s1, .85);
	g2.setColor(Color.BLACK);  g2.draw(s1);


	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of regular books by Evan West", 20,20);
    }
  
    /** Draw a different picture with a few books and some bookswithbookmarks rotated and in many colors
     */

    public static void drawPicture3(Graphics2D g2) {
	Stroke orig = g2.getStroke();

	Book b1 = new Book(75,50,40,100);
	Book b2 = new Book(400,300,40,30);
	Book b3 = new Book(350,150,90,120);
	Book b4 = new Book(100,198,120,250);

	g2.setColor(Color.RED);     g2.draw(b1);
	g2.setColor(Color.GREEN);   g2.draw(b2);
	g2.setColor(Color.BLUE);    g2.draw(b3);
	g2.setColor(Color.MAGENTA); g2.draw(b4);

	Stroke thick = new BasicStroke (2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	g2.setStroke(thick);

	BookWithBookmark b5 = new BookWithBookmark(200,200,200,200);
	g2.setColor(Color.BLACK);   g2.draw(b5);

	Shape s1 = ShapeTransforms.scaledCopyOfLL(b5, 0.8, 0.7);
	s1 = ShapeTransforms.translatedCopyOf(s1, 250, 50);
	s1 = ShapeTransforms.rotatedCopyOf(s1, 0.5);

	g2.setColor(Color.ORANGE);   g2.draw(s1);

       	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of books and some with bookmarks by Evan West", 20,20);
    }
    

}
