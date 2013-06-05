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
     * @param x for the x position
     * @param y for the y position
     * @param width for the width of the Tree
     * @param height for the height of the Tree
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

	double xPos = x+ width/2.0;
	
	
               
        GeneralPath leftSide = new GeneralPath();
      
        //leftSide of the tree
       
	leftSide.moveTo(xPos, y);

        leftSide.lineTo(xPos-width*.10,y+height*.25);
        leftSide.lineTo(xPos-width*.05, y+height*.25);

        leftSide.lineTo(xPos-width*.20,y+height*.50);
        leftSide.lineTo(xPos-width*.10,y+height*.50);

	leftSide.lineTo(xPos-width*.30,y+height*.75);
	leftSide.lineTo(xPos-width*.05,y+height*.75);

	leftSide.lineTo(xPos-width*.05,y+height*.90);
	leftSide.lineTo(xPos,y+height*.90);
        
	
        Shape rightSide = ShapeTransforms.horizontallyFlippedCopyOf(leftSide);
       
        // after flipping around the upper left hand corner of the
        // bounding box, we move this over to the right by width*.60
       
        rightSide = ShapeTransforms.translatedCopyOf(rightSide, width*.6, 0.0);
      
        // now we put the whole thing together ino a single path.
       
        GeneralPath wholeTree = new GeneralPath ();
        wholeTree.append(leftSide, false);
        wholeTree.append(rightSide, false); 
       	this.set(new GeneralPath(wholeTree));
        
    }

}
