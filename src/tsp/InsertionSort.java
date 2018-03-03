package tsp;

import java.util.*;
import java.io.*;
import java.awt.Point;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: InsertionSort
* File: InsertionSort.java
* Built approach the Travelling Salesman Problem using 
* heuristic insertion at the lowest co.
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class InsertionSort implements Operation{

    Vector dessin;     // Contains the drawing steps of the construction of the circuit //


    /**
     * Default constructor.
     */
    InsertionSort(){
        dessin = new Vector();
    }

    /**
      * Calculates the length of a circuit
      *
      * @param Graph contains information about points of the circuit and
      * Distances between points.
      * @param Loop circuit that is alue.
      */
    double calculDistanceCircuit(Graph graph, Vector circuit){
	double distance = 0;
	for(int i = 0; i< (circuit.size()-1); i++){
	    int point1 = ((Integer) circuit.elementAt(i)).intValue();
	    int point2 = ((Integer) circuit.elementAt(i+1)).intValue();
	    distance += graph.tableauDistances[point1][point2];
	}
	return distance;
    }

    /**
      * Application of insertion algorithm at the lowest co.
      *
      * @param Graph contains information about points and distances
      * Between points.
      */
   public void operation(Graph graph){

       int taille = graph.nPoints;       // The number of points Circuit must contain.
       boolean []  visite = new boolean[taille]; // Array of points for Whether one point  in the ciruit. 
       Vector circuit = new Vector();       // circuit with the algorithm
       Vector circuitTemp;                  // temporary system


	// initialization table visit points
	for(int i=0; i<taille; i++)
	    visite[i] = false;

	// At the circuit is ruit had a point.
	circuit.addElement(new Integer(0));
	circuit.addElement(new Integer(0));
	visite[0] = true;

        // Construction of an ape drawing.
	Drawing etape = new Drawing(dessin);
        etape.addEdge(graph,0,0);
        etape.addDistance();
        dessin.addElement(etape.ligne);

        // It is believed all points
	while(circuit.size() != graph.nPoints +1){
	    
	    // search insert point and place the inserted oon.
	    double distanceMin=-1;
	    double distanceCourante=0;
	    int indiceInsertion=1;
	    int point=0;

	    // for all points remaining insert
	    for(int i=0;i<taille;i++){
		if(!visite[i]){

		    // See the circuit length during insertion
                    // The point guard and the smallest circuit.
		    for(int j=1;j<circuit.size();j++){
			circuitTemp = (Vector) circuit.clone();
			circuitTemp.insertElementAt(new Integer(i),j);
			distanceCourante=calculDistanceCircuit(graph,
							       circuitTemp);
			if(distanceMin == -1 ||distanceCourante < distanceMin){
			      indiceInsertion = j;
	                      point = i;
			      distanceMin = distanceCourante;
			}
                    }
		  }
	    }
	    // Insertion point
	    circuit.insertElementAt(new Integer(point),indiceInsertion);
	    
	    // Update the point table ins
	    visite[point]=true;

	    // Construction of the corresponding drawing
	    etape = new Drawing(dessin);

	    int indicePoint1 = ((Integer) circuit.elementAt(
						indiceInsertion-1)).intValue();
	    int indicePoint2 = ((Integer) circuit.elementAt(
						indiceInsertion+1)).intValue();
            int indicePointInsertion = ((Integer)circuit.elementAt(
						indiceInsertion)).intValue();

            etape.addEdge(graph,indicePoint1,indicePointInsertion);
            etape.addEdge(graph,indicePointInsertion,indicePoint2);
	    etape.removeEdge(graph,indicePoint1,indicePoint2);
            etape.addDistance();
      	    dessin.addElement(etape.ligne);
	}
    }
}

