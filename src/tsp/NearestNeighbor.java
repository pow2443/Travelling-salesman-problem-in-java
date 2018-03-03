package tsp;
import java.util.*;
import java.io.*;
import java.awt.Point;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: NearestNeighbor
* File: NearestNeighbor.java
* Built an approach to the traveling salesman problem using heuristic 
* nearest neighbor.
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class NearestNeighbor implements Operation{

     Vector dessin;     // Contains the drawing steps of the construction of the circuit //


    /**
    * default constructor
    */
    NearestNeighbor()
    {
        dessin = new Vector();
    }
    
   /**
      * Application of nearest neighbor algorithm
      *
      * @param Graph contains information about points of the circuit and
      * Distances between points.
      */
    public void operation(Graph graph){

	int taille = graph.nPoints;              // Number of connected dots
	boolean []  visite = new boolean[taille]; // If ge point gave
                                                    // connected
                                                    // Initialize the array of items visit
	for(int i=0; i<taille; i++)
	    visite[i] = false;


	// We start with item 1.
	visite[0] = true;
	int indicePoint1 = 0;

	// Algo nearest neighbor
	// It connects all the points
	for(int i=0; i<taille; i++){
	    double distanceMin = -1;
	    int indicePoint2 = 0; // Initialize the point 0 to connect
                                    // Latter trouvau item quia
                                    // Commencl algorithm

	    // One seeks the shortest weapon from the point number 
            // indicePoint1
	    for(int j=0; j<taille; j++){
		double distanceCourante=0;
		if((indicePoint1!=j) && (!visite[j])){
		   distanceCourante = graph.tableauDistances[indicePoint1][j];

		    if((distanceMin == -1)||
		       (distanceCourante < distanceMin)){
			distanceMin = distanceCourante;
			indicePoint2 = j;
		    }
		}
	    }

	    // Update the drawing
	    Drawing etape = new Drawing(dessin);
            etape.addEdge(graph,indicePoint1,indicePoint2);
	    etape.addDistance();
            dessin.addElement(etape.ligne);
	    
	    // Modified values
	    visite[indicePoint2] = true;
	    indicePoint1=indicePoint2;
	}
    }
}

