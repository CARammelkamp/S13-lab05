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
   A n extension of a vector drawing of a book that adds a bookmark
      
   @author Evan West
   @version for CS56, Spring 13, UCSB
   
*/

public class BookWithBookmark extends Book implements Shape
{
    /*
      Constructor for BookWithBookmark, extension of Book
    */
    public BookWithBookmark(double x, double y, double width, double height)
    {
	// construct the basic book
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	//now add a bookmark on top of the book, on the left side
	//with its upper left corner touching the top of the bound

	double spineDeltaH = 0.2 * height;
	double bookmarkXFraction = 0.2;
	double bookmarkWidthFraction = 0.1;

	//equation for top left line:
	double topLeftSlope =  ((y+spineDeltaH*(bookmarkXFraction))-y)/((x+(bookmarkXFraction*width)+bookmarkWidthFraction*width)-(x+(bookmarkXFraction*width)));


	Line2D.Double topLine = 
	    new Line2D.Double(x+(bookmarkXFraction*width),y,x+(bookmarkXFraction*width)+bookmarkWidthFraction*width,y+spineDeltaH*(bookmarkXFraction));
	    //new Line2D.Double(x+(bookmarkXFraction*width),y,x+(bookmarkXFraction*width)+bookmarkWidthFraction*width,y+spineDeltaH

	Line2D.Double leftLine = 
	    new Line2D.Double(x+(bookmarkXFraction*width),y,x+(bookmarkXFraction*width),y+spineDeltaH*topLeftSlope*(1-bookmarkWidthFraction));

	Line2D.Double rightLine = 
	    new Line2D.Double(x+(bookmarkXFraction*width)+bookmarkWidthFraction*width,y+spineDeltaH*(bookmarkXFraction),x+(bookmarkXFraction*width)+bookmarkWidthFraction*width, y+spineDeltaH*(bookmarkXFraction)+spineDeltaH*topLeftSlope*(1-bookmarkWidthFraction));


	gp.append(topLine,false);
	gp.append(leftLine,false);
	gp.append(rightLine,false);
    }
}