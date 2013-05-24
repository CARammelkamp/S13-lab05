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
   A House
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class Flower extends Grass implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public Flower(double x, double y, double width, double height)
    {
		double radius = width/6;
		
		super(x,y,width,height);
		
		GeneralPath gp = this.get();
		
		Circle centerFlower =
			new Circle(super.centerX, super.centerY, radius);
		
		Circle topFlower =
			new Circle(super.centerX, super.centerY - 2*radius, radius);
			
		Circle leftFlower =
			new Circle(super.centerX - 2*radius, super.centerY, radius);
			
		Circle rightFlower =
			new Circle(super.centerX + 2*radius, super.centerY, radius);
			
		GeneralPath wholeFlower = this.get();
        wholeFlower.append(centerFlower, false);
        wholeFlower.append(topFlower, false);
        wholeFlower.append(leftFlower, false); 
        wholeFlower.append(rightFlower, false); 
    }

}
