package tsp;

import java.util.*;
import java.io.*;
import java.awt.Point;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Heuristic
* File: Heuristic.java
* Built approach the Travelling Salesman Problem using heuristic insertion 
* Call the nearest
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class Heuristic implements Operation{
    
     Vector dessin;  // Contains the drawing steps of the construction of the circuit


    /** 
     * Default constructor  
     */
    Heuristic(){
        dessin = new Vector();
    }

    /**
      * Application of the algorithm of the insertion of the nearest
      *
      * @param Graph contains information about points of the circuit and
      * Distances between points.
      */
    public void operation(Graph graph){
	Vector circuit = new Vector();           // Circuit that is built
	int taille = graph.nPoints;              // number of connecting point
	boolean []  visite = new boolean[taille]; // table indicating whether a
	                                           // Point dreli

	// initialization table visit points.
	for(int i=0; i<taille; i++)
	    visite[i] = false;

	// At first, the circuit is ruit 1 point.
	circuit.addElement(new Integer(0));
	circuit.addElement(new Integer(0));
	visite[0] = true;

        // Construction of an ape drawing.
	Drawing etape = new Drawing(dessin);
        etape.addEdge(graph,0,0);
        etape.addDistance();
        dessin.addElement(etape.ligne);

	// Insertion of all points
	while(circuit.size() != graph.nPoints +1){
	    
	    // search of the nearest point
	    int element;
	    double distanceMin=0;
	    int indicePoint=0;
	    double distanceCourante=0;

	    for(int i = 0; i <circuit.size(); i++){
		element = ((Integer) circuit.elementAt(i)).intValue();

		for(int j = 0 ; j < taille ; j++){
		    if(!visite[j])
			distanceCourante = graph.tableauDistances[element][j];
		    
		    if(distanceMin == 0 || distanceCourante < distanceMin){
			distanceMin = distanceCourante;
			indicePoint = j;
			
		    }
		}
	    }

	    // updating of the point table
	    visite[indicePoint] = true;

	    // Search the place oa place the insertion
	    double distanceInsertion = -1;

	    // by daut is inserted in second place
	    int indexInsertion =1;

            // Search the place where we will do the insertion
	    for(int index = 1; index <circuit.size()-1 ; index++){
		distanceCourante = 0;

		distanceCourante -= graph.tableauDistances
		    [((Integer) circuit.elementAt(index-1)).intValue()]
		    [((Integer) circuit.elementAt(index)).intValue()];

		distanceCourante += graph.tableauDistances
		    [((Integer) circuit.elementAt(index-1)).intValue()]
		    [indicePoint];

		distanceCourante += graph.tableauDistances
		    [indicePoint]
		    [((Integer) circuit.elementAt(index)).intValue()];

		if(distanceInsertion == -1 || 
		   distanceInsertion > distanceCourante)
		    {
			distanceInsertion = distanceCourante;
			indexInsertion = index;
		    }
	    }

	    // insertion au bon endroit
	    circuit.insertElementAt(new Integer(indicePoint),indexInsertion);

	    // dessin du circuit
	    etape = new Drawing(dessin);
	    int indicePoint1 = ((Integer) circuit.elementAt(
						 indexInsertion-1)).intValue();
            int indicePoint2 = ((Integer) circuit.elementAt(
						 indexInsertion+1)).intValue();
	    int indicePointInsertion = ((Integer) circuit.elementAt(
						   indexInsertion)).intValue();

            etape.addEdge(graph, indicePoint1, indicePointInsertion);
            etape.addEdge(graph, indicePointInsertion, indicePoint2);
            etape.removeEdge(graph,indicePoint1,indicePoint2);
            etape.addDistance();
	    dessin.addElement(etape.ligne);
	}
    }
}
