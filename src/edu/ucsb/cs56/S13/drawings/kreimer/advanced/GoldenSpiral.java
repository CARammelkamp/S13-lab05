package edu.ucsb.cs56.S13.drawings.kreimer.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Arc2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a golden spiral that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Keenan Reimer
   @version for CS56, Spring 2013, UCSB
   
*/
public class GoldenSpiral extends GoldenRectangle implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of golden spiral
       @param y y coord of lower left corner of golden spiral
       @param height of golden spiral
     */
    public GoldenSpiral(double x, double y, double height)
    {
		//Make the compiler happy
		super(x,y,height);
		
		//Prep variables for the gobbles of necessary info
		double goldenRatio = 1.61803398875;
		double thisHeight = height;
		double nextHeight = height/goldenRatio;
		double thisWidth = height/goldenRatio;
		double nextWidth = nextHeight/goldenRatio;
		double thisXOrigin = x;
		double thisYOrigin = y;
		double nextYOrigin = y - thisHeight + nextWidth/2 + nextHeight/2;
		double nextXOrigin = x + thisWidth/2 - nextWidth/2;
		
		//Setup for the loop
		int i = 0;
		GeneralPath wholeGoldenSpiral= this.get();
		Shape gR = this;
		
		//Place all the golden rectangles & arcs
		while(nextWidth > 1){
		
			//Make a new rectangle for scaling and rotation. I couldn't use the given scaleCopy method because it scales about a point.
			gR = new GoldenRectangle(nextXOrigin,nextYOrigin,nextHeight);
			//Rotate 90 degrees
			gR = ShapeTransforms.rotatedCopyOf(gR,(i+1)*Math.PI/2);
			wholeGoldenSpiral.append(gR,false);
			
			//Prep the next rectangle
			thisHeight = nextHeight;
			thisWidth = nextWidth;
			nextHeight = nextHeight/goldenRatio;
			nextWidth = nextWidth/goldenRatio;
			thisXOrigin = nextXOrigin;
			thisYOrigin = nextYOrigin;
			
			//Origin moves differently after each rotation. This was hard.
			if(i%4 == 0){
				nextXOrigin = thisXOrigin + nextHeight - nextWidth/2;
				nextYOrigin = thisYOrigin - nextWidth/2;
			}
			else if(i%4 == 1){
				nextXOrigin = thisXOrigin + nextHeight/2 - nextWidth/2;
				nextYOrigin = thisYOrigin + nextHeight/2 - nextWidth/2;
			}
			else if(i%4 == 2){
				nextXOrigin = thisXOrigin - nextWidth/2;
				nextYOrigin = thisYOrigin - nextWidth/2;
			}
			else if (i%4 == 3){
				nextXOrigin = thisXOrigin + nextHeight/2 - nextWidth/2;
				nextYOrigin = thisYOrigin - (nextHeight/2 + nextWidth/2);
			}
			i++;
		}
    }
}
