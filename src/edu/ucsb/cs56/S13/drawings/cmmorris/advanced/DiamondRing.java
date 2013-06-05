package edu.ucsb.cs56.S13.drawings.cmmorris.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;
/**
   A Diamond Ring
      
   @author Christina Morris
   @version for CS56, S13, UCSB, 05/19/13
   
*/
public class DiamondRing extends Diamond implements Shape
{
    /**
     * Constructor for objects of class Diamond Ring
     */
    public DiamondRing(double x, double y, double width, double height)
    {
	// construct the basic diamond shape
	super(x + width*.375,y,width*.25,height*.25);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	//draw the ring underneath the diamond
	Ellipse2D.Double ring = new Ellipse2D.Double(x + (width*.125), y + (height*.25), width*.75, height*.75);

	//add the ring the the diamond object
        GeneralPath wholeRing = this.get();
        wholeRing.append(ring, false);
    }

}
