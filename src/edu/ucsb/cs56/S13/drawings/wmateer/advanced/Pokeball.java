package edu.ucsb.cs56.S13.drawings.wmateer.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A Pokeball class (wrapper around a General Path, implements Shape)

   @author Will Mateer 
   @version for CS56, S13, UCSB, 5/17/13
   
*/
public class Pokeball extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class Pokeball
     */
    public Pokeball(double x, double y, double width, double height)
    {
		
        final double ORIG_ULX = 0.0; 
        final double ORIG_ULY = 0.0;
        final double ORIG_HEIGHT = 240.0; 
        final double ORIG_WIDTH = 240.0;
                
		System.out.println("Start of Constructor of Pokeball");
		
        GeneralPath leftSideMidLine = new GeneralPath();
        leftSideMidLine.moveTo(0,120);
        leftSideMidLine.lineTo(90,120);
        
        GeneralPath rightSideMidLine = new GeneralPath();
		rightSideMidLine.moveTo(150,120);
        rightSideMidLine.lineTo(240,120);
       
        Circle largeCircle = new Circle(120,120,120);
		
		Circle innerCircle = new Circle(120,120,20);
		
		Circle middleCircle = new Circle(120,120,30);
																	
        // now we put the whole thing together ino a single path.
       
        GeneralPath wholePokeball = new GeneralPath ();
		
        wholePokeball.append(leftSideMidLine, false);
        wholePokeball.append(rightSideMidLine, false);
        wholePokeball.append(largeCircle, false);
		wholePokeball.append(innerCircle, false);
		wholePokeball.append(middleCircle, false);
		
		System.out.println("Pokeball assembled into shape");
        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
		
        //Shape s = ShapeTransforms.translatedCopyOf(wholePokeball, -ORIG_ULX + x, -ORIG_ULY + y);
		Shape s = ShapeTransforms.translatedCopyOf(wholePokeball, 0, 0);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s, width/ORIG_WIDTH, height/ORIG_HEIGHT) ;
		//Shape s =  ShapeTransforms.scaledCopyOf(wholePokeball, width/ORIG_WIDTH, height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	this.set(new GeneralPath(s));
        
    }

}
