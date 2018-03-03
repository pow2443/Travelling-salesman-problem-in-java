package tsp;

import java.util.Vector;
import java.awt.geom.Point2D;
import java.awt.Point;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Drawing
* File: Drawing.java
* Player design that will achieve the GUI
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Drawing {
    Vector ligne;       // An ape drawing
    double distance;    // Distance circuit


    /** 
     * Constructor by skipping a line drawing 
    */
    Drawing() {
	ligne = new Vector();
    }

    /** 
     * Constructor of an ape design * 
     * @param vector containing vector construction by ape ape in the space *. 
     */
    Drawing(Vector vecteur) {
	// graph construction begins
	if( vecteur.size() == 0){
	    ligne = new Vector();
	    distance = 0;
	}
	// graph construction continues
	else{
	    // Copy the circuit
	     ligne = (Vector) ((Vector) (vecteur.lastElement())).clone();
	     // Removing the distance
	    distance = ((Double) ligne.lastElement()).doubleValue();
	    ligne.removeElementAt(ligne.size()-1);
	}
    }

    /**
      * Adds an edge in the drawing
      *
      * @param Graph the points of the graph.
      * @param IndicePoint1 first point of the ridge
      * @param IndicePoint2 second point of the ridge
      */
    void addEdge(Graph graph, int indicePoint1, int indicePoint2){

	Point point1 = (Point) graph.ensemblePoints.elementAt(indicePoint1);
	Point point2 = (Point) graph.ensemblePoints.elementAt(indicePoint2);
	
	DrawingEdge edge  = new DrawingEdge(point1,point2);
	ligne.addElement(edge);
	distance += graph.tableauDistances[indicePoint1][indicePoint2];
    }

    /**
      * Removes one are in the drawing.
      *
      * @param Graph the points of the graph.
      * @param IndicePoint1 first point of the ridge
      * @param IndicePoint2 second point of the ridge
      */
    void removeEdge(Graph graph, int indicePoint1, int indicePoint2){
	
	Point point1 = (Point) graph.ensemblePoints.elementAt(indicePoint1);
	Point point2 = (Point) graph.ensemblePoints.elementAt(indicePoint2);
	DrawingEdge edge  = new DrawingEdge(point1,point2);
 
	ligne.removeElement(edge);
	distance -= graph.tableauDistances[indicePoint1][indicePoint2];
    }
    
   /** 
    * Add the distance from the circuit. 
    */
    void addDistance(){
	ligne.addElement(new Double(distance));
    }
}
