
package tsp;

import java.util.*;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: ComparisonAnalysis
* File: ComparisonAnalysis.java
* Definition of the result of comparing the length of two acres. 
* Use this class to Kruskal's algorithm.
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class ComparisonAnalysis implements Comparator{

    Graph graph ; // Contains information on issues and Distances between points

    /** 
     * Default constructor 
     */
    ComparisonAnalysis(Graph graph){
	this.graph = graph;
    }

    /**
      * Campare the length of two edges.
      *
      * @param O1 are premie
      * @param Second o2 are
      * @return An integer 0 if both ares have the same size, value
      * Are positive if the First is the longest, a native number if the
      * Second are the longest.
      */
    public int compare(Object o1, Object o2){
	Edge arete1 = (Edge) o1;
	Edge arete2 = (Edge) o2;
     
	Double d1 = new Double(graph.tableauDistances[arete1.getPoint1()]
			      [arete1.getPoint2()]);
	Double d2 = new Double(graph.tableauDistances[arete2.getPoint1()] 
			       [arete2.getPoint2()]);

	return d1.compareTo(d2);
	
    }

}
