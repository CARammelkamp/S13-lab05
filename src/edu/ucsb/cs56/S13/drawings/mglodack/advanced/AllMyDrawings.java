package edu.ucsb.cs56.S13.drawings.mglodack.advanced;

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
 * @author Mathew Glodack
 * @version CS56, lab05, 5/23/13
 */

public class AllMyDrawings
{
    /** Draw a picture with a few Trees
     */

    public static void drawPicture1(Graphics2D g2) {

	Tree t1 = new Tree(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(t1);
	
	// Make a black tree that's half the size, 
	// and moved over 150 pixels in x direction
	Shape t2 = ShapeTransforms.scaledCopyOfLL(t1,0.5,0.5);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	g2.setColor(Color.BLACK); g2.draw(t2);
	
	// Here's a Tree that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	t2 = ShapeTransforms.scaledCopyOfLL(t2,4,4);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(t2); 
	
	// Draw two Tree with ornaments
	
	TreeWithOrnaments tw1 = new TreeWithOrnaments(50,350,40,75);
	TreeWithOrnaments tw2 = new TreeWithOrnaments(200,350,200,100);
	
	g2.draw(tw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(tw2);
		
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few Trees by Mathew Glodack", 20,20);
    }


    /** Draw a picture with a few Trees
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some Trees.
	
	Tree large = new Tree(100,50,225,150);
	Tree smallCC = new Tree(20,50,40,30);
	Tree tallSkinny = new Tree(20,150,20,40);
	Tree shortFat = new Tree(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Tree t1 = new Tree(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(t1);
	
	// Make a black Tree that's half the size, 
	// and moved over 150 pixels in x direction
	Shape t2 = ShapeTransforms.scaledCopyOfLL(t1,0.5,0.5);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	g2.setColor(Color.BLACK); g2.draw(t2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	t2 = ShapeTransforms.scaledCopyOfLL(t2,4,4);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(t2); 
	
	// Draw two houses with Windows
	
	TreeWithOrnaments tw1 = new TreeWithOrnaments(50,350,40,75);
	TreeWithOrnaments tw2 = new TreeWithOrnaments(200,350,200,100);
	
	g2.draw(tw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape tw3 = ShapeTransforms.rotatedCopyOf(tw2, Math.PI/4.0);

	g2.draw(tw3);
	
 	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Trees and Trees With Ornaments by Mathew Glodack", 20,20);
    }
  
    /** Draw a different picture with a bunch of Trees with Ornaments and Trees
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Trees by Mathew Glodack", 20,20);

	
	// Draw some Trees, TreeWithOrnaments
	TreeWithOrnaments first = new TreeWithOrnaments(100,50,225,300);
	TreeWithOrnaments second = new TreeWithOrnaments(20,50,80,100);
	TreeWithOrnaments third = new TreeWithOrnaments(200, 100, 300, 400);
	TreeWithOrnaments fourth = new TreeWithOrnaments(400, 400, 600, 700);
	Tree t1 = new Tree(50, 100, 300, 300);
	g2.setColor(Color.GREEN);     g2.draw(first);
       	g2.setColor(Color.black);   g2.draw(second);
	g2.setColor(Color.black);         g2.draw(third);
	g2.draw(fourth);
	g2.draw(t1);
    }
    

}
