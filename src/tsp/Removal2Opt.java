package tsp;

import java.util.*;
import java.awt.Point;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Removal2Opt
* File: Removal2Opt.java
 * Built an approach to the traveling salesman problem using heuristic appel hange 
 * 2-opt.
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Removal2Opt implements Operation{

    Vector dessin;   // Contains the drawing steps of the construction of the circuit //
    
    /**
     * default constructor
     */
    Removal2Opt()
    {
	dessin = new Vector();
    }

   /**
      * Opposite the direction of a part of a circuit.
      * Reverse the direction of the edges that we consid.
      *
      * @param Circuit Circuit considered listeArete * @param list acres
      * @param Start the beginning of the circuit? Reverse
      * @param End the end of the circuit? Reverse
      */
    void inverseSensCircuit(LinkedList circuit,LinkedList listeArete,int debut,
			    int fin){
	
	Vector tmp = new Vector(); // Vector 
                                    // containing weapons having changed direction.

	// We keep the weapons that have changed meaning. 
        // It changes the meaning of acres of acres in the list.
	for( int i = debut +1 ; i <fin ;i++){
	   
	    Edge edge1 = (Edge) circuit.get(debut+1); 
	    circuit.remove(debut+1);
	    Edge edge2 = new Edge(edge1.getPoint2(),edge1.getPoint1());
	    
	    tmp.add(edge2);

	    
	    if(listeArete.remove(edge1))
		listeArete.add(edge2);
	}
       
	// Change the direction of acres of way have the weapons in order in the circuit.
	for( int i = fin-1, j=0 ; i >debut ;i--,j++){
	    circuit.add(debut+1,tmp.elementAt(j));

	}

    }

     /** 
      * Implementation of 2-opt algorithm changes. * 
      * @param Graph contains information about points and distances between points 
      *. 
      */
    public void operation(Graph graph){
	int nSommets = graph.nPoints;            // nb of vertices in the graph
	LinkedList circuit = new LinkedList();    // List string containing
	                                          // the edges of the circuit
	LinkedList listeArete = new LinkedList(); // List string containing
	                                          // the edges look
	Edge edge;                             // arete that is consid
	Drawing etape = new Drawing(dessin);      // stores an ape drawing
	
	// Create any circuit that has thus worthy ares: 
        // (0-1) (1-2) ... (nSommets -1-0) 
        // We crr the corresponding drawing
	for(int i =0; i< nSommets-1 ; i++){
	    edge = new Edge(i,i+1);
	    listeArete.add(edge);
	    circuit.add(edge);
	    etape.addEdge(graph,i,i+1);
	}
	edge = new Edge(nSommets-1,0);
	listeArete.add(edge);
	circuit.add(edge);

	etape.addEdge(graph,nSommets-1,0);
	etape.addDistance();
	dessin.addElement(etape.ligne);


	int taille_liste = nSommets-1 ;  // Maximum number of acres watch
	

	// Start of hange algorithm 
        // We compare all ares
	while( taille_liste >= 0 ){

	    
	    // Premie considered arete
	    edge = (Edge) listeArete.get(0);
	    int point1 = edge.getPoint1();
	    int point2 = edge.getPoint2();
	   
	    int j=0;
	    boolean trouve=false;
	    
	    // We are looking for the who when performing an angel 
            // reduces circuit size
	    while (j < taille_liste && trouve==false){
		
		// Second are considered
		edge = (Edge) listeArete.get(j);
		int point3 = edge.getPoint1();
		int point4 = edge.getPoint2();
		
		// It looks so both areas are contiguous. 
                // If they are not the hange is carried ruisent 
                // if the size of the circuit.
		if( point1 !=point2 && point1!= point3 && point1 !=point4 
		    && point2!= point3 && point2!= point4 && point3!= point4 ){


		    // Calculate the distance
		    double distanceAncienne = graph.tableauDistances[point1]
			[point2] + graph.tableauDistances[point3][point4];

		    double distanceNouvelle=graph.tableauDistances[point1]
			[point3] + graph.tableauDistances[point2][point4];
		   
		    
		    // It looks so the angel of arms reduces the size of the loop //
		    if( distanceAncienne > distanceNouvelle){
			trouve=true;
			
			// Indices remove Elements
			int indice_arete1 = circuit.indexOf(listeArete.get(0));
			int indice_arete2 = circuit.indexOf(listeArete.get(j));
					    
			
			
			// Construction of new ares taking account
                        // Direction of the circuit.
			Edge edge1;
			Edge edge2;
			
			if( indice_arete1 <indice_arete2){
			     edge1 = new Edge(point1,point3);
			     edge2 = new Edge(point2,point4);
			}
			else{
			     edge1 = new Edge(point4,point2);
			     edge2 = new Edge(point3,point1);
			}
			

			// It removes the old stations in the list 
                        // edges of visit
			listeArete.remove(0);
			listeArete.remove(j-1);
			
			// The new weapons added in the list 
                        // edges of visit
			listeArete.add(edge1);
			listeArete.add(edge2);

			  
			// We modify the circuit, paying attention to direction
                        // Circuit 
			if( indice_arete1 <indice_arete2){
			   // We remove the edges
			    circuit.remove(indice_arete1);
			    circuit.remove(indice_arete2-1);
			    // ares is added
			    circuit.add(indice_arete1,edge1);
			    circuit.add(indice_arete2,edge2);
			    //partial reversal of direction
			    inverseSensCircuit(circuit, listeArete,
					       indice_arete1, indice_arete2);
			}
			else{
			    // it removes edges
			    circuit.remove(indice_arete2);
			    circuit.remove(indice_arete1-1);
			    // ares is added
			    circuit.add(indice_arete2,edge2);
			    circuit.add(indice_arete1,edge1);
			    //partial inversion circuit
			    inverseSensCircuit(circuit,listeArete,
					       indice_arete2,indice_arete1);
			}
			
			// Update drawing
			etape = new Drawing(dessin);
			
			etape.removeEdge(graph, point1, point2);
			etape.removeEdge(graph, point3, point4);
			
			etape.addEdge(graph,edge1.getPoint1(),
					  edge1.getPoint2());
			etape.addEdge(graph,edge2.getPoint1(),
					  edge2.getPoint2());
			etape.addDistance();
			dessin.addElement(etape.ligne);
		    }
		}
		j++;
	    }
	    // No exchange is interesting about this so we are the deletes
	    if( trouve == false) {
		listeArete.remove(0);
		taille_liste--;
	    }
	}
    }
}
