package edu.ucsb.cs56.S13.drawings.kreimer.advanced;

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
 * @author Keenan Reimer
 * @version for CS56, lab05, Spring 2013
 */


public class AllMyDrawings
{
    /** Draw a picture with a few golden rectangles
     */

    public static void drawPicture1(Graphics2D g2) {
	
	g2.drawString("A Few Golden Rectangles by Keenan Reimer", 20,20);
	
	// Draw rotate and translate a few golden rectangles
	GoldenRectangle r1 = new GoldenRectangle(100,250,150);
	g2.setColor(Color.BLACK); 
	g2.draw(r1);
	
	Shape r2 = ShapeTransforms.rotatedCopyOf(r1,Math.PI);
	r2 = ShapeTransforms.translatedCopyOf(r2,125,0);
	r2 = ShapeTransforms.scaledCopyOf(r2,.75,.75);
	g2.setColor(Color.BLUE); 
	g2.draw(r2);
	
	Shape r3 = ShapeTransforms.translatedCopyOf(r2, -125, 200);
	r3 = ShapeTransforms.scaledCopyOf(r3,.75,.75);
	g2.setColor(Color.RED); 
	g2.draw(r3);
	
	Shape r4 = ShapeTransforms.translatedCopyOf(r1, 125, 200);
	r4 = ShapeTransforms.scaledCopyOf(r4,Math.pow(.75,3),Math.pow(.75,3));
	g2.setColor(Color.GREEN); 
	g2.draw(r4);
	}


    /** Draw a picture with a few golden spirals
     */
    public static void drawPicture2(Graphics2D g2) {
	
	g2.drawString("A Few Golden Spirals by Keenan Reimer", 20,20);
	
	//Draw a little golden spiral
	GoldenSpiral s1 = new GoldenSpiral(100,200,150);
	g2.setColor(Color.BLACK);
	g2.draw(s1);
	
	//Rotate the little golden spiral
	Shape s2 = ShapeTransforms.rotatedCopyOf(s1,Math.PI/2);
	s2 = ShapeTransforms.translatedCopyOf(s2,200,0);
	g2.draw(s2);
	
	//Draw a gold golden spiral
	g2.setColor(Color.YELLOW.darker());
	Shape s3 = new GoldenSpiral(100,375,150);
	g2.draw(s3);
	
	//Draw a red golden spiral
	g2.setColor(Color.RED.darker());
	Shape s4 = ShapeTransforms.rotatedCopyOf(s3,Math.PI/2);
	s4 = ShapeTransforms.translatedCopyOf(s4,200,0);
	g2.draw(s4);
	}

	/**
	Draw a picture of a gigantic golden spiral
	*/

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A gigantic Golden Spiral by Keenan Reimer", 20,20);

	GoldenSpiral s1 = new GoldenSpiral( 350, 950, 1100);
	Shape s2 = ShapeTransforms.rotatedCopyOf(s1,Math.PI/2);
	g2.setColor(Color.BLACK);
	g2.draw(s2);
       
       
    }
    

}
