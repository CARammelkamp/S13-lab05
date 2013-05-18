package edu.ucsb.cs56.S13.drawings.mglodack.advanced;
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
   A Tree (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.
   
      
   @author Mathew Glodack 
   @version for CS56, S13, UCSB, 5/18/13
   
*/
public class Tree extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class Tree
     */
    public Tree(double x, double y, double width, double height)
    {
    
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* Tree
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 300.0; 
        final double ORIG_WIDTH = 400.0; 
                
        GeneralPath leftSide = new GeneralPath();
      
        //leftSide of the tree
       
        leftSide.moveTo(200,400);

        leftSide.lineTo(185,430);
        leftSide.lineTo(190,430);

        leftSide.lineTo(175,460);
        leftSide.lineTo(180,460);

	leftSide.lineTo(165,490);
	leftSide.lineTo(190,490);

	leftSide.lineTo(190,510);
	leftSide.lineTo(200,510);
        
	
        Shape rightSide = ShapeTransforms.horizontallyFlippedCopyOf(leftSide);
       
        // after flipping around the upper left hand corner of the
        // bounding box, we move this over to the right by 400 pixels
       
        rightSide = ShapeTransforms.translatedCopyOf(rightSide, 70.0, 0.0);
       
        // now we put the whole thing together ino a single path.
       
        GeneralPath wholeTree = new GeneralPath ();
        wholeTree.append(leftSide, false);
        wholeTree.append(rightSide, false);

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeTree, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	this.set(new GeneralPath(s));
        
    }

}
