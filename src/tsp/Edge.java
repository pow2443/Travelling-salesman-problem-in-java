package tsp;


import java.awt.Point;
import java.io.*;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Edge
* File: Edge.java
* Manage areas of a system 
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class Edge {

    private int point1; // first point 
    private int point2; // Second point 


    /** 
     * Constructor * 
     * @param point 1 are the first point. 
     * @param Point 2 second point of ar? E. 
     */
    Edge(int p1, int p2) {
	this.point1 = p1;
	this.point2 = p2;
    }
    
    /** 
     * Indicating Mode if are is equal to another. 
     * It takes into account the direction of travel of the are. * 
     * @param O arete that comparing. 
     */
   public boolean equals(Object o)
    {
	Edge edge = (Edge) o;
	if((edge.point1 == this.point1 && edge.point2 == this.point2))
	    return true;
	return false;
    }
    
    /** 
     * Day putting Mode points are a * 
     * @param x are the first point. 
     * @param Y second point of the are. 
     */
    void set(int x, int y){
	point1 = x;
	point2 = y;

    }
    /** 
     * Method returning the value of the first point of the are. 
     */
    int getPoint1(){
	return point1;
    }

    /** 
     * Method returning the value of the second point of the are. 
     */
    int getPoint2(){
	return point2;
    }

    /**
      * Mode are displaying a.
      */
    public String toString() {
	StringBuffer buffer = new StringBuffer();
	buffer.append("(" + point1 + " ---" + point2 +")" );
	return buffer.toString();
    }
    
}

