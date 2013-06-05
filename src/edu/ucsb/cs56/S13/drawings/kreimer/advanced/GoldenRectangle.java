package edu.ucsb.cs56.S13.drawings.kreimer.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Arc2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a golden rectangle and a golden arc that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Keenan Reimer
   @version for CS56, Spring 2013, UCSB
   
*/
public class GoldenRectangle extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of golden rectangle
       @param y y coord of lower left corner of golden rectangle
       @param height of golden rectangle
     */
    public GoldenRectangle(double x, double y, double height)
    {
		double goldenRatio = 1.61803398875;
		double width = height / goldenRatio;
		double xOrigin = x;
		double yOrigin = y - height;
        
        // Make the golden rectangle
        
        Rectangle2D.Double goldenRectangle = 
            new Rectangle2D.Double( xOrigin, yOrigin, width, height);
                          
        // Make the golden arc segment

		Arc2D.Double goldenArc = 
			new Arc2D.Double( xOrigin, yOrigin - (2*width - height), 2*width, 2*width,270,-90,Arc2D.OPEN);
			
        // put the whole golden rectangle together
       
        GeneralPath wholeGoldenRectangle= this.get();
        wholeGoldenRectangle.append(goldenRectangle, false);
        wholeGoldenRectangle.append(goldenArc, false);
        
    }
}
