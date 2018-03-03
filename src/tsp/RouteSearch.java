package tsp;

import java.util.*;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: RouteSearch
* File: RouteSearch.java
* Tree overseer containing whole for algorithms and Kruskal
* Prim.
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class RouteSearch {

    RouteSearch high;
    RouteSearch low;
    int value; 
    static final RouteSearch NIL = new RouteSearch();

    /**
     * Constructor top of a cell in a tree.
     */
    RouteSearch(){
	high = null;
	low = null;
	value = -1;
    }

    /**
      * Manufacturer
      *
      * @param Value value of the entire contents into the cell.
      * @param Son son of the cell considered
      * @param Brother brother of the cell considered
      */
    RouteSearch(int valeur, RouteSearch fils, RouteSearch frere)
    {
	this.value = valeur;
	high = fils;
	low = frere;
    }

    /**
      * Search a cell in a tree in a prixe course.
       *
      * @param Peak value of the cell that is desired.
      * @return The cell containing the sought after value
      */
    private RouteSearch searchObjet(int vertext ){
	if ( value == vertext  ) {
	    return this;
	} else {
	    if (high != NIL) {
		RouteSearch r=high.searchObjet(vertext );
		if ( r != NIL ) return r;
	    }
	    if( low != NIL) {
		RouteSearch r=low.searchObjet(vertext );
		if ( r != NIL ) return r;
	    }
	}
	return NIL;
    }


    /**
      * Built a tree from a table containing all the aroma es
      * Of this tree.
      *
      * @param TableauArete table containing the aroma are the tree? Construct
      *.
      * @return The built tree.
      */
    RouteSearch construitArbre(Vector tableauArete){
	
	Edge edge;
	LinkedList file= new LinkedList();
	
	// on prend la premi?e arete
	edge = (Edge) tableauArete.get(0);
	tableauArete.remove(0);
	
	// it adds vertices in the queue
	file.addLast(new Integer(edge.getPoint1()));
	file.addLast(new Integer(edge.getPoint2()));

	// creation of the root and of his first son
	RouteSearch racine = new RouteSearch(edge.getPoint1(),
					  new RouteSearch(edge.getPoint2(),
					   NIL,NIL),NIL);

	// We construct the tree.
	while (file.size()!=0){
	   
	    // we remove an element from the queue
	    int vertext = ((Integer) file.getFirst()).intValue();
	    file.removeFirst();

	    // one seeks the ement in tree
	    RouteSearch arbre = racine.searchObjet(vertext);

	    // are sought acres containing the top "top".
	    int i=0;
	    while(i < tableauArete.size()){
		RouteSearch arbreTmp = arbre;
		edge = (Edge) tableauArete.get(i);
		
		// If there is a point in the are in the tree,
                // It is added the second point of the tree are
		if( edge.getPoint1()== vertext  || edge.getPoint2()== vertext){
		    tableauArete.remove(i);

		    int vertext2;    // Insert 
		    
		    if(edge.getPoint1() == vertext){ 
			vertext2=edge.getPoint2();
		    }
		    else{
			vertext2=edge.getPoint1();
		    }
		    
		   // Insert as the son of the cell considered
		    if(arbreTmp.high == NIL){
			arbreTmp.high = new RouteSearch(vertext2,NIL,NIL);
		    }
		    // Insert as mother of the son of the cell considered //
		    else{
			arbreTmp = arbreTmp.high;
			// We insee as last fre
			while(arbreTmp.low!=NIL)
			    arbreTmp = arbreTmp.low;
			arbreTmp.low= new RouteSearch(vertext2,NIL,NIL);
		    }
		    file.addLast(new Integer(vertext2));
		}
		else i++;
	    }
	}    
	return racine;
    }


   /**
      * an array containing the path of the graph. The circuit is
      * Prixe the course of the tree.
      *
      * @param Loop current circuit graph
      * @return The circuit.
      */
    Vector creeCircuit(Vector circuit){

	circuit.addElement(new Integer(value));
	
	if (high != NIL)
	    high.creeCircuit(circuit);

	if (low != NIL)
	    low.creeCircuit(circuit);
	 
	return circuit;
    }
}
