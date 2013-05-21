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
   A Pencil with an eraser
      
   @author Chris Atanasian
   @version for CS56, S13, UCSB, 05/20/2013
   
*/
public class PencilWithEraser extends Pencil implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     * @param x x coord of top left corner of pencil, excluding eraser
     * @param y y coord of top left corner of pencil, excluding eraser
     * @param width width of the pencil
     * @param height from the top left corner down to before the triangle tip
     */
    public PencilWithEraser(double x, double y, double width, double height)
    {
	// construct the basic pencil shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// make the metal above the top of the pencil before the eraser

	double metalHeight = height/4.0;

	Line2D.Double metalLeftSide =
	    new Line2D.Double (x, y,
			       x, y - metalHeight);

	Line2D.Double metalRightSide = 
	    new Line2D.Double (x + width, y,
			       x + width, y - metalHeight);
	
        GeneralPath wholePencil = this.get();
	wholePencil.append(metalLeftSide, false);
	wholePencil.append(metalRightSide, false);
         
    }

}
