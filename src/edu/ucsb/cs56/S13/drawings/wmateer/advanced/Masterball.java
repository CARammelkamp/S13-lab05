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
   A Masterball class (wrapper around a General Path, implements Shape)

   @author Will Mateer 
   @version for CS56, S13, UCSB, 5/17/13
   
*/
public class Masterball extends Pokeball implements Shape
{

    
    /**
     * Constructor for objects of class Masterball
     */
    public Masterball(double x, double y, double width, double height)
    {
		super(0,0,240,240);
		
		GeneralPath fp = this.get();
		
		GeneralPath gp = new GeneralPath(fp);
		
		GeneralPath leftSideM = new GeneralPath();
        leftSideM.moveTo(80,80);
        leftSideM.lineTo(100,50);
		
		leftSideM.lineTo(120,65);
		
		leftSideM.lineTo(140,50);
		leftSideM.lineTo(160,80);

        gp.append(leftSideM, false);
		
		gp = MasterballScalingHelper(gp,x,y,width,height);
	
		this.set(new GeneralPath(gp));
        
    }
	
	/**
	 Private Helper method to implement the scaling and displacement of the Masterball Drawing
	 @param gp Input GeneralPath that is to be modified and returned
	 @param x New Upper Left X-coordinate to move drawing to
	 @param y New Upper Left Y-coordinate to move drawing to
	 @param width variable that determines scaling of width from original
	 @param height variable that determines scaling of height from original
	 @return NewPath GeneralPath return value that is the modified version of the input with the specificed values
	 */
	
	private GeneralPath MasterballScalingHelper(GeneralPath gp, double x, double y, double width, double height){
		Shape s = ShapeTransforms.translatedCopyOf(gp, x, y);	
		s =  ShapeTransforms.scaledCopyOf(s, width/240, height/240);
		GeneralPath NewPath = new GeneralPath();
		NewPath.append(s,false);
		return NewPath;
	}

}
