package tsp;

import java.util.*;
import java.io.*;
import java.awt.Point;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Kruskal
* File: Kruskal.java
* Built an approach to the traveling salesman problem using heuristic 
* of Christofid. The minimum spanning tree is builded by 
* Kruskal's algorithm.
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Kruskal implements Operation {


    Vector dessin;    // Contains the drawing steps of the construction of the circuit //

    /**
    * default constructor
    */
    public Kruskal(){	
        dessin = new Vector();
    }

   /**
      * Construction of acres of the spanning tree algorithm with
      * Kruskal.
      *
      * @param Graph contains information about points and distances
      * Between points.
      * @return The table of acres of the spanning tree.
      */
    private Vector arbreRecouvrant(Graph graph){
	
	int nVertex = graph.nPoints;     // number of connecting point
	Vector circuit = new Vector();     // circuit that is created
	Vector tableauArete = new Vector();  // Arms table tree
	Drawing etape;                       // keeps track of the drawing
	Classification classification = new Classification(nVertex);
	
	LinkedList listeArete = new LinkedList(); // priority queue	
        ComparisonAnalysis comparateur = new ComparisonAnalysis(graph);
       
	// Create a priority queue of arcs of the graph in ascending 
        // cout
	for(int i=0; i < nVertex; i++){
	    for(int j=0; j < nVertex; j++){
		if(i!=j){
		    Edge edge = new Edge(i,j);
		    listeArete.add(edge);
		}
	    }
	}
	
	// Sorting edges by length
	Collections.sort(listeArete,comparateur);

	Edge edge = null;
	while(classification.getNombrePartitions() >1){

	   // Search the ridge of minimal cost
            // That does not create a circuit if added
            // The spanning tree.
	    boolean trouve = false;

	    while(!trouve){
		edge = (Edge) listeArete.getFirst();
	 
		if(! classification.sameClassification(edge.getPoint1(), edge.getPoint2())){
		    trouve = true;
		}
		
		listeArete.removeFirst();
	    }
	
	    tableauArete.addElement(edge);
	    
	    classification.union (edge.getPoint1(),edge.getPoint2());
	    
	    // Drawing
	    etape = new Drawing(dessin);
	    etape.addEdge(graph,edge.getPoint1(),edge.getPoint2());
	    etape.addDistance();
	    dessin.addElement(etape.ligne);
	}
	return tableauArete;
    }


    /**
      * Table containing the information required for full the
      * Building design
      *
      * @param Graph the information on the graph
      * @param System approach the problem of the traveling salesman on
      * graph
      */
    private void creeDessin(Graph graph,Vector circuit){
	 Drawing etape = new Drawing();

	 for(int i = 0; i< (circuit.size()-1) ; i++){
	     int sommet1 = ((Integer) circuit.elementAt(i)).intValue();
	     int sommet2 = ((Integer) circuit.elementAt(i+1)).intValue();
	     etape.addEdge(graph,sommet1,sommet2);
	 }
	 etape.addDistance();
	 dessin.addElement(etape.ligne);   
     }

    /** * Implementation of the algorithm of Christofides 
     * @param graph the information on the graph 
     */
    public void operation(Graph graph){
	Vector v =arbreRecouvrant(graph);  // creation of the spanning tree
	RouteSearch routeSearch = new RouteSearch(); // actual creation of the tree
	routeSearch = routeSearch.construitArbre(v);
	// creation of the circuit by a tree prices courses covering
	Vector circuit = routeSearch.creeCircuit(new Vector());
	circuit.addElement(circuit.elementAt(0));
	
	// circuit design
	creeDessin(graph,circuit);
    }
}
