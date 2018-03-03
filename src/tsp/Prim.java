package tsp;
import java.util.*;
import java.io.*;
import java.awt.Point;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Prim
* File: Prim.java
* Built an approach to the traveling salesman problem using heuristic 
* of Christofid. The minimum spanning tree is builded by 
* Prim's algorithm.
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class Prim implements Operation {
   
    Vector dessin;  // Contains the drawing steps of the construction of the circuit //
   
    /**
    *default constructor
    */
    public Prim(){
	dessin = new Vector();
    }

    /** 
     * Construction of acres of tree cover with Prim algorithm. 
     * 
    * @param Graph the points of the graph. 
    * @return The table of acres of the spanning tree. 
    */
    Vector arbreRecouvrant(Graph graph){
	
	int nSommets = graph.nPoints;     // number of the graph point
	Vector circuit = new Vector();     // circuit that is cr
	Vector tableauArete = new Vector();// Table of acres
	Drawing etape;                 // keeps an ape drawing
	

	// 0 is the first summit
	circuit.addElement(new Integer(0));

	// the circuit is cr
	while(circuit.size() < nSommets){
	    double distanceMin = -1;
	    int sommet1Min = 0;
	    int sommet2Min = 0;

	    // for all stock summits
	    for(int k=0; k<circuit.size() ; k++){
		int i = ((Integer) circuit.elementAt(k)).intValue(); 
		for(int j=0; j<nSommets; j++){
		    // For all the summits were not included in the circuit 
                    // we search the nearest point
		    if(!circuit.contains(new Integer(j))){
			double distance = graph.tableauDistances[i][j];
			if( distance <distanceMin || distanceMin == -1){
			    distanceMin = distance;
			    sommet1Min = i;
			    sommet2Min = j;
			}
		    }
		}
	    }
	    
	    circuit.addElement(new Integer(sommet2Min));
	    Edge edge = new Edge(sommet1Min,sommet2Min);

	    // Draw the edges
	    etape = new Drawing(dessin);
	    etape.addEdge(graph,sommet1Min,sommet2Min);
	    etape.addDistance();
	    dessin.addElement(etape.ligne);

	    tableauArete.addElement(edge);
	}
	return tableauArete;
    }

    /**
     * Table containing the information required for full the
     * Construction of the drawing.
      *
      * @param Graph the information on the graph
      * @param System approach the problem of the traveling salesman on
      * graph
      */
     void creeDessin(Graph graph, Vector circuit){
	Drawing etape= new Drawing();
	
	for(int i = 0; i< (circuit.size()-1) ; i++){
	    int sommet1 = ((Integer) circuit.elementAt(i)).intValue();
	    int sommet2 = ((Integer) circuit.elementAt(i+1)).intValue();
	    etape.addEdge(graph,sommet1,sommet2);
	 }
	etape.addDistance();
	dessin.addElement(etape.ligne);
     }

    /** 
     * Implementation of the algorithm of Christofides 
     * @param graph the information on the graph 
     */
    public void operation(Graph graph){
	Vector v =arbreRecouvrant(graph);   // creation of the spanning tree
	RouteSearch routeSearch = new RouteSearch();  // actual creation of the tree
	routeSearch = routeSearch.construitArbre(v);
	
	// Creation of the circuit by a tree prices courses covering
	Vector circuit = routeSearch.creeCircuit(new Vector());
	circuit.addElement(circuit.elementAt(0));
	
	// Draw the circuit
	creeDessin(graph,circuit);
    }
}
