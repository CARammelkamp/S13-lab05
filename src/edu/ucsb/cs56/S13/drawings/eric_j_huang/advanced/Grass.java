package edu.ucsb.cs56.S13.drawings.eric_j_huang.advanced;
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
   A grass
      
   @author Phill Conrad 
   @author Eric Huang
   @version for CS56, Spring 13, UCSB
   
*/
public class Grass extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of grass
       @param y y coord of lower left corner of grass
       @param width width of the picture
       @param height of picture (from root to top of flower)
     */
    public Grass(double x, double y, double width, double height)
    {
		/* get the coordinate of x and y at the center */
		double centerX = x + width/2;
		double centerY = y - height/2;
		double firstQuartY = y - height/4; /* how high the split will go */
		
		// draw the grass in the middle
		Line2D.Double centerGrass 
			= new Line2D.Double(centerX, y, centerX, centerY);
		
		// draw the two splits
		Line2D.Double leftGrass
			= new Line2D.Double(centerX, y, x, firstQuartY);
		
		Line2D.Double rightGrass
			= new Line2D.Double(centerX, y, x+width, firstQuartY);
		
		// put the three part of grass together
		GeneralPath wholeGrass = this.get();
		wholeGrass.append(centerGrass, false);
		wholeGrass.append(leftGrass, false);
		wholeGrass.append(rightGrass, false);
		
		
		
        
    }

}
