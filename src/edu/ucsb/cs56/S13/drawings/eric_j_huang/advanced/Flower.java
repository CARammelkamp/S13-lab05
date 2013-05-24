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

import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;
/**
   A Flower.
      
   @author Phill Conrad 
   @author Eric Huang
   @version for CS56, Spring 13, UCSB
   
*/
public class Flower extends Grass implements Shape
{
    /**
     * Constructor for objects of class Flower
     * I realized the Circle class would be useful so I implemented it in
     */
    public Flower(double x, double y, double width, double height)
    {
		super(x,y,width,height);

		double centerX = x + width/2; /* coordinate of x at the center */
		double centerY = y - height/2; /* coordinate of y at the center */
		double firstQuartY = y - height/4; /* the height of the two split */
		double radius = width/6;
		
		// the GeneralPath that I'm going to append stuff onto
		GeneralPath gp = this.get();
		
		/* create the flower part of the flower, they're
		 * all in relation to each other instead of hard coded
		 * coordinate
		 */
		Circle centerFlower =
			new Circle(centerX, centerY, radius);
		
		Circle topFlower =
			new Circle(centerX, centerY - 2*radius, radius);
			
		Circle leftFlower =
			new Circle(centerX - 2*radius, centerY, radius);
			
		Circle rightFlower =
			new Circle(centerX + 2*radius, centerY, radius);
			
		/* add the flower part to the grass part */
		GeneralPath wholeFlower = this.get();
        wholeFlower.append(centerFlower, false);
        wholeFlower.append(topFlower, false);
        wholeFlower.append(leftFlower, false); 
        wholeFlower.append(rightFlower, false); 
    }

}
