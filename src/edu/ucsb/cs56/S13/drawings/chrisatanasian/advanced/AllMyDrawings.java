package edu.ucsb.cs56.S13.drawings.chrisatanasian.advanced;

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
 * @author Chris Atanasian
 * @version for CS56, lab05, Spring 2013
 */


public class AllMyDrawings
{
    /** Draw a picture with a few pencils 
     */

    public static void drawPicture1(Graphics2D g2) {

	Pencil p1 = new Pencil(100,250,25,100);
	g2.setColor(Color.BLACK); g2.draw(p1);
	
	// Make a red pencil that's half the size, 
	// and moved over 150 pixels in x direction

	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.RED); g2.draw(p2);
	
	// Here's a pencil that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	p2 = ShapeTransforms.scaledCopyOfLL(p2,4,4);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(p2); 
	
	// Draw two houses with Windows
	
	PencilWithEraser pw1 = new PencilWithEraser(50,350,40,75);
	PencilWithEraser pw2 = new PencilWithEraser(200,350,200,100);
	
	g2.draw(pw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(pw2);
	
	// Signing and labeling drawings
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few pencils by Chris Atanasian", 20,20);
	
	}


    /** Draw a picture with a few pencils
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some coffee cups.
	
        PencilWithEraser large = new PencilWithEraser(100,50,225,150);
	PencilWithEraser small = new PencilWithEraser(20,50,40,30);
	PencilWithEraser tallSkinny = new PencilWithEraser(20,150,20,40);
	PencilWithEraser shortFat = new PencilWithEraser(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
        Pencil p1 = new Pencil(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(p1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.BLACK); g2.draw(p2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	p2 = ShapeTransforms.scaledCopyOfLL(p2,4,4);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(p2); 
	
	// Draw two houses with Windows
	
	PencilWithEraser pw1 = new PencilWithEraser(50,350,40,75);
	PencilWithEraser pw2 = new PencilWithEraser(200,350,200,100);
	
	g2.draw(pw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape pw3 = ShapeTransforms.rotatedCopyOf(pw2, Math.PI/4.0);

	g2.draw(pw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Pencils by Chris Atanasian", 20,20);
    }
  
    /** Draw a different picture with a five pencils in different sizes/colors
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Pencils of different sizes by Chris Atanasian", 20,20);

	
	// Draw some coffee cups.
	
       Pencil p1 = new Pencil(20,50,50,100);
       Pencil p2 = new Pencil(80,50,75,150);
       Pencil p3 = new Pencil(170,50,100,200);
       Pencil p4 = new Pencil(290,50,125,250);
       Pencil p5 = new Pencil(450,50,150,300);
       
       g2.setColor(Color.RED);     g2.draw(p1);
       g2.setColor(Color.GREEN);   g2.draw(p2);
       g2.setColor(Color.BLUE);    g2.draw(p3);
       g2.setColor(Color.ORANGE);  g2.draw(p4);
       g2.setColor(Color.MAGENTA); g2.draw(p5);
       
       
    }
    

}
