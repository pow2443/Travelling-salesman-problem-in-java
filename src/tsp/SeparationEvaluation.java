package tsp;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.lang.Math;
import java.util.Vector;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: SeparationEvaluation
* File: SeparationEvaluation.java
* Built the exact solution of the traveling salesman problem using the saration 
* algorithm and aluation.
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class SeparationEvaluation implements Operation{

    Vector dessin;      // Contains drawing stages of construction 
                        // circuit.
    double borne;       // terminal indicating need arre exploration.
    int [] circuit;     // circuit that is calculated.
    int [] min_circuit; // Minimum system found
    boolean [] utilise; // guard of used items
    Graph graph;      // give us to build the circuit.

    /**
     * default constructor
     */
    SeparationEvaluation(Graph graph)
    {
        dessin = new Vector();
	borne = 0 ;
	circuit = new int[graph.nPoints];
	min_circuit=new int[graph.nPoints];
	utilise = new boolean[graph.nPoints];
	for(int i=0;i<graph.nPoints;i++)
	    utilise[i] = false;
    }
    
    
    /**
      * Search the shortest circuit to connect all the dots.
      * @param Number of city-level ins in the circui.
      * @param Distance circuit length
      */
    void recherche(int niveau,double distance) {
	double d;
	int i;

	// If we have not finished the circuit
	if (niveau < graph.nPoints) {
	   
	    for (i=0;i<graph.nPoints;i++) {
		if(utilise[i]!=true){
		    d=distance+graph.tableauDistances[circuit[niveau-1]][i];
		    if ( d<borne ) {
			circuit[niveau]=i;
			utilise[i]=true;
			recherche(niveau+1,d);
			utilise[i]=false;
		    }
		}
	    }
	}
	// If we look at whether it is minimal
	else {
	    d=distance+graph.tableauDistances[circuit[niveau-1]][0];
	    if ( d < borne ) {
		borne=d;
		for ( i=0; i<graph.nPoints; i++ ) min_circuit[i]=circuit[i];
	    }
	}
    }

    /** 
     * Application of separation and evaluation algorithm 
     * @param graph the information on the graph 
     */
    public void operation(Graph graph) {
	
	// circuit initial: 0 -> 2->..->(nonbre points-1)->0 
	int i;
	this.graph=graph;
	double distance = 0;
	for ( i = 0; i<graph.nPoints-1; i++) {
	    distance += graph.tableauDistances[i][i+1];
	    min_circuit[i]=i;
	}
	distance+=graph.tableauDistances[graph.nPoints-1][0];
	
	borne = distance;
	circuit[0]=0;
	utilise[0] = true;

	// search the minimum system
	recherche(1,0);

	// drawing of the final circuit.
	Drawing etape = new Drawing(dessin);
	for ( i=0; i<graph.nPoints-1; i++) {
	    etape.addEdge(graph,min_circuit[i],min_circuit[i+1]);
	}
	etape.addEdge(graph,min_circuit[graph.nPoints-1],min_circuit[0]);
	etape.addDistance();
	dessin.addElement(etape.ligne);
    }
}
