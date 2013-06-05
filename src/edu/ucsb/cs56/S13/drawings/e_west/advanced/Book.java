package edu.ucsb.cs56.S13.drawings.e_west.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a book that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Evan West
   @version for CS56, Spring 13, UCSB
   
*/
public class Book extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       @param x x coord of lower left corner of book
       @param y y coord of lower left corner of book
       @param width width of the book
       @param height of book (including first story and second story)
     */
    public Book(double x, double y, double width, double height)
    {
	double spineDeltaH = 0.2 * height;
	double pagesThickness = 0.02 * height + 0.02 * width;
	double midX = (x+width/2.0);

	Line2D.Double leftEdge = 
	    new Line2D.Double(x,y,x,y+height-spineDeltaH);

	Line2D.Double rightEdge = 
	    new Line2D.Double(x+width,y,x+width,y+height-spineDeltaH);

	Line2D.Double midSpine = 
	    new Line2D.Double(x+width/2.0,y+spineDeltaH,x+width/2.0,y+height);

	Line2D.Double bottomLeftEdge = 
	    new Line2D.Double(x,y+height-spineDeltaH,x+width/2.0,y+height);

	Line2D.Double bottomRightEdge = 
	    new Line2D.Double(x+width/2.0,y+height,x+width,y+height-spineDeltaH);

	Line2D.Double topLeftEdge = 
	    new Line2D.Double(x,y,x+width/2.0,y+spineDeltaH);

	Line2D.Double topRightEdge = 
	    new Line2D.Double(x+width/2.0,y+spineDeltaH,x+width,y);

	GeneralPath wholeBook = this.get();
	wholeBook.append(leftEdge,false);
	wholeBook.append(rightEdge,false);
	wholeBook.append(midSpine,false);
	wholeBook.append(bottomLeftEdge,false);
	wholeBook.append(bottomRightEdge,false);
	wholeBook.append(topLeftEdge,false);
	wholeBook.append(topRightEdge,false);

    }
}