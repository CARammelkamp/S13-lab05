package edu.ucsb.cs56.S13.drawings.bohan_lin.advanced;
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
   A Head
      
   @author Phill Conrad
   @author Bohan Lin
   @version for CS56, S13, UCSB, 5/24/2013
   
*/
public class HeadWithHair extends Head implements Shape
{
     /**
     * Constructor for objects of class HeadWithHair
     * @param x    x coordinate of center of head
     * @param y    y coordinate of center of head
     * @param r    radius of the head
     */
    public HeadWithHair(double x, double y, double r)//constructor for head with hair
    {
	super(x,y,r);//calls the super class constructor to draw the head without hair first

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	Line2D.Double leftSideHair = new Line2D.Double(x, y + r, x, y - r);//draws the left side of the hair
	Line2D.Double topSideHair = new Line2D.Double(x, y - r, x + 2*r, y - r);//draws the top side of the hair
	Line2D.Double rightSideHair = new Line2D.Double(x + 2*r, y - r, x + 2*r, y + r);//draws the right side of the hair



        GeneralPath headWithHair = this.get();//general path to append the parts of the hair
        headWithHair.append(leftSideHair, false);
        headWithHair.append(topSideHair, false);
        headWithHair.append(rightSideHair, false); 
    }

}
