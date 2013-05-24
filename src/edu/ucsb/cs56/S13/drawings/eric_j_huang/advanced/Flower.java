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
   A Flower
      
   @author Phill Conrad 
   @author Eric Huang
   @version for CS56, Spring 13, UCSB
   
*/
public class Flower extends Grass implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public Flower(double x, double y, double width, double height)
    {
		super(x,y,width,height);
		
		double centerX = x + width/2;
		double centerY = y - height/2;
		double firstQuartY = y - height/4;
		double radius = width/6;
		
		GeneralPath gp = this.get();
		
		Circle centerFlower =
			new Circle(centerX, centerY, radius);
		
		Circle topFlower =
			new Circle(centerX, centerY - 2*radius, radius);
			
		Circle leftFlower =
			new Circle(centerX - 2*radius, centerY, radius);
			
		Circle rightFlower =
			new Circle(centerX + 2*radius, centerY, radius);
			
		GeneralPath wholeFlower = this.get();
        wholeFlower.append(centerFlower, false);
        wholeFlower.append(topFlower, false);
        wholeFlower.append(leftFlower, false); 
        wholeFlower.append(rightFlower, false); 
    }

}
