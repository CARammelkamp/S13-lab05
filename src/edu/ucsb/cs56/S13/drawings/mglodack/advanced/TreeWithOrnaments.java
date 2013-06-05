package edu.ucsb.cs56.S13.drawings.mglodack.advanced;
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
   A Tree with ornaments
      
   @author Mathew Glodack
   @version for CS56, S13, UCSB, 05/18/2013
   
*/
public class TreeWithOrnaments extends Tree implements Shape
{
    /**
     * Constructor for objects of class TreeWithOrnaments
     * @param x is for the position on the Tree Frame
     * @param y is for the position on the Tree Frame
     * @param width is for the width of the Tree Frame
     * @param height is for the height of the the Tree Frame
     */
    public TreeWithOrnaments(double x, double y, double width, double height)
    {
	// construct the basic tree shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	double treeEnd = x +width/2.0;
	double oWidth = 7.0;
	double oHeight = 7.0;
	double oBigW = 12.0;
	double oBigH = 12.0;

	Ellipse2D.Double orna1 =
	    new Ellipse2D.Double(treeEnd-width*.10-3.5,y+height*.25, oWidth, oHeight);
       	Ellipse2D.Double orna2 =
	    new Ellipse2D.Double(treeEnd-width*.20-5.0, y+height*.50, 10.0, 10.0);
	Ellipse2D.Double orna3 =
	    new Ellipse2D.Double(treeEnd-width*.30-6.0, y+height*.75, oBigW, oBigH);
	Ellipse2D.Double orna4 =
	    new Ellipse2D.Double(treeEnd+width*.10-3.5,y+height*.25, oWidth, oHeight);
	Ellipse2D.Double orna5 =
	    new Ellipse2D.Double(treeEnd+width*.20-5.0, y+height*.50, 10.0, 10.0);
	Ellipse2D.Double orna6 =
	    new Ellipse2D.Double(treeEnd+width*.30-6.0, y+height*.75, oBigW, oBigH);

	// add the ornaments to the tree
        GeneralPath wholeTree = this.get();
        wholeTree.append(orna1, false);
	wholeTree.append(orna2, false);
	wholeTree.append(orna3, false); 
	wholeTree.append(orna4, false); 
       	wholeTree.append(orna5, false); 
       	wholeTree.append(orna6, false); 
    }

}
