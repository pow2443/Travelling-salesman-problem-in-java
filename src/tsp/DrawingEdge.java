package tsp;


import java.awt.Point;
import java.io.*;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: DrawingEdge
* File: DrawingEdge.java
* Management of the art of drawing
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class DrawingEdge {

    Point point1; // First point 
    Point point2; // Second point 

    /** * Constructor * 
    * @param point 1 are the first point. 
    * @param Point 2 of the second point are. 
    */
    DrawingEdge(Point point1, Point point2) {
	this.point1 = point1;
	this.point2 = point2;
    }
	

    /** 
     * Default constructor 
     */
    DrawingEdge() {
	point1 = new Point(0, 0);
	point2 = new Point(0, 0);
    }
    
    /** 
     * Mode are whether a is equal to another * 
     * @param o arete that comparing. 
     */
    public boolean equals(Object o) {
	DrawingEdge a = (DrawingEdge) o;

	if((point1.equals(a.point1) && point2.equals(a.point2))||
	   (point1.equals(a.point2) && point2.equals(a.point1)))
	    return true;
	return false;
    }

    /** 
     * Mode are displaying a. 
     */
    public String toString() {
	StringBuffer buffer = new StringBuffer();
	buffer.append("(" + point1.x + ", " + point1.y + ")---(" + 
	                    point2.x + ", " + point2.y + ")");
	return buffer.toString();
    }
    
    
}
