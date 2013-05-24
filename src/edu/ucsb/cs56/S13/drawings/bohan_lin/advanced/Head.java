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
import java.awt.geom.Ellipse2D;

/**
   A vector drawing of a head that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @author Bohan Lin
   @version for CS56, Winter 13, UCSB
   
*/
public class Head extends GeneralPathWrapper implements Shape
{  
     /**
     * Constructor for objects of class Head
     * @param x    x coordinate of center of head
     * @param y    y coordinate of center of head
     * @param r    radius of the head
     */
    public Head(double x, double y, double r)
    {
        
        Ellipse2D.Double head = new Ellipse2D.Double( x, y, r * 2,  r * 2); /* width and height are double the radius */
	double eyeSize = r/3; //base size to use for eye and pupil
	double mouthSize = r/2;//size of mouth
	Ellipse2D.Double leftEye = new Ellipse2D.Double( x + r/2, y + r/2, eyeSize, eyeSize );//draws the left eye
	Ellipse2D.Double rightEye = new Ellipse2D.Double( x + r, y + r/2, eyeSize, eyeSize);//draws the right eye
	Ellipse2D.Double leftPupil = new Ellipse2D.Double( x + r/2 + r/10, y + r/2+ r/5, eyeSize/3, eyeSize/3);//draws the left pupil
	Ellipse2D.Double rightPupil = new Ellipse2D.Double( x + r + r/10, y + r/2 + r/5, eyeSize/3, eyeSize/3);//draws the right pupil
	Ellipse2D.Double mouth = new Ellipse2D.Double( x + r/2, y + 3/2*r, mouthSize, mouthSize);//draws the mouth
	Line2D.Double nose1 = new Line2D.Double( x + r - 2*r/10, y + r - r/10, x + r- 2*r/10 + r/10, y + r - r/10 - r/10);//draws the slant of the nose
	Line2D.Double nose2 = new Line2D.Double( x + r - 2*r/10, y + r - r/10, x + r- 2*r/10 + r/10, y + r - r/10);//draws the base of the nose
        
	GeneralPath entireHead = this.get();//General path to append all the parts of the head
	entireHead.append(head, false);
	entireHead.append(leftEye, false);
	entireHead.append(rightEye, false);
	entireHead.append(leftPupil, false);
	entireHead.append(rightPupil, false);
	entireHead.append(mouth, false);
	entireHead.append(nose1, false);
       	entireHead.append(nose2, false);
    }
        
}

