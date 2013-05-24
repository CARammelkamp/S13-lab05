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
public class Masterball extends Pokeball implements Shape
{

    
    /**
     * Constructor for objects of class Pokeball
     */
    public Masterball(double x, double y, double width, double height)
    {
		super(x,y,width,height);
		
		GeneralPath gp = this.get();
		
        final double ORIG_ULX = 0.0; 
        final double ORIG_ULY = 0.0;
        final double ORIG_HEIGHT = 240.0; 
        final double ORIG_WIDTH = 240.0; 
                
		System.out.println("Start of Constructor of Masterball");
		
		GeneralPath leftSideM = new GeneralPath();
        leftSideM.moveTo(80,80);
        leftSideM.lineTo(100,50);
		
		leftSideM.lineTo(120,65);
		
		leftSideM.lineTo(140,50);
		leftSideM.lineTo(160,80);
       
        GeneralPath wholeM = new GeneralPath ();
		
        wholeM.append(leftSideM, false);
		
		System.out.println("Pokeball assembled into shape");
        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
		
        //Shape s = ShapeTransforms.translatedCopyOf(wholeM, -ORIG_ULX + x, -ORIG_ULY + y);
		//Shape s = ShapeTransforms.translatedCopyOf(wholeM, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        //s =  ShapeTransforms.scaledCopyOf(s, width/ORIG_WIDTH, height/ORIG_HEIGHT) ;
		//Shape s =  ShapeTransforms.scaledCopyOf(wholeM, width/ORIG_WIDTH, height/ORIG_HEIGHT) ;
		
		Shape s =  ShapeTransforms.scaledCopyOf(wholeM, width/ORIG_WIDTH, height/ORIG_HEIGHT) ;
		s = ShapeTransforms.translatedCopyOf(s, 0, 0);
	
		// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
		gp.append(s,false);
		
	this.set(new GeneralPath(gp));
        
    }

}
