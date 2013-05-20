package edu.ucsb.cs56.S13.drawings.chrisatanasian.advanced;
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
   A vector drawing of a pencil that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Chris Atanasian 
   @version for CS56, Sprin 13, UCSB
   
*/
public class Pencil extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of top left corner of pencil
       @param y y coord of top left corner of pencil
       @param width width of the pencil
       @param height from the top left corner down to before the triangle tip
     */
    public Pencil(double x, double y, double width, double height)
    {
    
	// make the left and right side of the pencil
	
	Line2D.Double leftSide = 
	    new Line2D.Double (x, y,
			       x, y + height);

	Line2D.Double rightSide =
	    new Line2D.Double (x + width, y,
			       x + width, y + height);

	// make the top part of the pencil

	Line2D.Double top = 
	    new Line2D.Double (x, y,
			       x + width, y);

	// make the triangular tip of the pencil

	double tipHeight = height/8.0;

	Line2D.Double leftTip =
	    new Line2D.Double (x, y + height,
			       x + width/2.0, y + height + tipHeight);

	Line2D.Double rightTip = 
	    new Line2D.Double (x + width, y + height,
			       x + width/2.0, y + height + tipHeight);

        // put the whole pencil together
       
        GeneralPath wholePencil = this.get();
        wholePencil.append(leftSide, false);
        wholePencil.append(rightSide, false);
	wholePencil.append(top, false);
	wholePencil.append(leftTip, false);
	wholePencil.append(rightTip, false);
             
    }

}
