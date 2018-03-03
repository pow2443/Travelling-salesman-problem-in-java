package tsp;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.lang.Math;
import java.util.Vector;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Approximation
* File: Approximation.java
* Approach Travelling Salesman Problem by Using heuristics
* point, vector,graph
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class Approximation implements Operation{

     Vector dessin;    // contains the drawing step of the construction
                       // circuit

    /**
     * default constructor
     */
    Approximation()
    {
        dessin = new Vector();
    }


    /**
     * Calculating the polar angle between a straight and horizontal
     *
     * @param p1 premier point appartenant la droit
     * @param p2 second point belonging to the right.
     */
    public static double anglePolaire(Point p1, Point p2)
    {
	double angle;                     // sought-angle
	double dx = p2.getX()-p1.getX();  // difference abscissa
	double dy = p2.getY()-p1.getY();  // difference ordinate

	angle = Math.toDegrees(Math.atan2(dy,dx));
	// It is positive angles
	if (angle<0)
	    return 360+angle;
	return angle;
    }

    /**
     * angle calculation between two lines
     *
     * @param p1 intersection of the two lines.
     * @param p2 point of the first line.
     * @param p3 point of the second line.
     */
    public static double angle(Point p1, Point p2, Point p3)
    {
	double x1, x2, x3, y1, y2, y3; 
	x1 = p1.getX();
	x2 = p2.getX();
	x3 = p3.getX();
	y1 = p1.getY();
	y2 = p2.getY();
	y3 = p3.getY();

	
	double angle1 = Math.toDegrees(Math.atan2((y2-y1),(x2-x1)));
	double angle2 = Math.toDegrees(Math.atan2((y3-y1),(x3-x1)));
    
	double angle = Math.abs(angle1-angle2);
	
	// We take the angle <180 (oriented angle)
	if(angle >180)
	    return 360-angle;
	return angle;
    }
    

    /**
      * Construction of the convex hull
      *
      * @param Graph graph points and distances between points
      */
    Vector enveloppeConvexe(Graph graph){
	int nSommets = graph.nPoints;
	int i, min, sommet;
	Point point;       
	double angle;      // Angle between two lines
	Vector enveloppe;  // Chain list containing the circuit
                           // The convex hull

	// Copy of the point table
	enveloppe = (Vector) graph.ensemblePoints.clone();

	// Search for the lowest point
	for(min = 0, i=1; i<nSommets; i++)
	    if((((Point) enveloppe.elementAt(i)).getY())
	       < (((Point) enveloppe.elementAt(min)).getY()))
		min =i;
	
	// Establishment of a sentry.
	enveloppe.addElement((Point) enveloppe.elementAt(min));
	
	double alpha = 0.0;
	double valeur;

	// Envelope construction
        // Vertex is the number of vertices in the envelope
        // It connects all the vertices
	for(sommet = 0; sommet < nSommets; sommet++){
	   
	    point = (Point) enveloppe.elementAt(sommet);
	    enveloppe.setElementAt((Point) enveloppe.elementAt(min),sommet);
	    enveloppe.setElementAt(point, min);
	    
	    min = nSommets;

	    valeur= alpha;
	    alpha = 360.0;
	    
	    // Search the point that connects the summit considered    
            for(i = sommet+1; i <= nSommets; i++){
		angle =  anglePolaire((Point) enveloppe.elementAt(sommet),
				    (Point) enveloppe.elementAt(i));

		if( angle > valeur)
		    if(angle < alpha ){
			min = i;
			alpha  =  anglePolaire((Point) enveloppe.elementAt(
				    sommet), (Point) enveloppe.elementAt(min));
		    }
	    }
	    
	    if(min == nSommets){
		// We removed the items that are not parties 
                // envelope
		for(i=nSommets-1; i>sommet; i--){
		    enveloppe.removeElementAt(i);
		}
		return enveloppe;
	    }
            
            
	}
    
	return enveloppe;
        
    }



    /** * Applies digital algorithm on a set of points. 
     * 
     * @param Graph set of points in a graph. 
     */
    public void operation(Graph graph){
	Vector circuit = enveloppeConvexe(graph);
	int nSommets = graph.nPoints;
	Vector reste = new Vector();
	int indicePoint1, indicePoint2;
	Drawing etape= new Drawing();
	
	
	// Drawing ruit tour the convex hull
	for( int i=0; i<circuit.size()-1 ; i++){
	    indicePoint1 = graph.ensemblePoints.indexOf(
					   (Point) circuit.elementAt(i));
	    indicePoint2 = graph.ensemblePoints.indexOf(
				           (Point) circuit.elementAt(i+1));

	    
	    etape.addEdge(graph,indicePoint1,indicePoint2);

	}

	etape.addDistance();
	dessin.addElement(etape.ligne);


	// Keeps the items not included in the circuit
	for(int i =0; i< nSommets; i++){
	    Point point = (Point) graph.ensemblePoints.elementAt(i) ;
	    if(!circuit.contains(point))
		reste.addElement(point);
	}

	int indiceInsertion;
	int indiceElement;
	double angleMax=0;

	// Inclusions all points
	while(reste.size()!=0){
	    // recherche du plus grand angle entre un point et deux points 
	    // consutifs du circuit.
	    indiceInsertion = 1;
	    indiceElement = 0;
	    angleMax = 0;

	    int i, j;
	    for(i=0; i<reste.size(); i++){
		Point point1 = (Point) reste.elementAt(i);
		for(j=0; j<circuit.size()-1; j++){
		    Point point2 = (Point) circuit.elementAt(j);
		    Point point3 = (Point) circuit.elementAt(j+1);
		    double angle = angle(point1,point2,point3);

		    if(angle > angleMax)
			{
			    angleMax = angle;
			    indiceInsertion = j+1;
			    indiceElement = i;
			}
		}
	    }

	    // insertion
	    circuit.insertElementAt((Point) reste.elementAt(indiceElement) ,
				      indiceInsertion);
	    
	    //dessin
	    indicePoint1 = graph.ensemblePoints.indexOf(
			       (Point) circuit.elementAt(indiceInsertion-1));
	    indicePoint2 = graph.ensemblePoints.indexOf(
			         (Point) circuit.elementAt(indiceInsertion));
	    etape = new Drawing(dessin);
	    etape.addEdge(graph,indicePoint1,indicePoint2);
	    
	    indicePoint1 = graph.ensemblePoints.indexOf(
			         (Point) circuit.elementAt(indiceInsertion));
	    indicePoint2 = graph.ensemblePoints.indexOf(
			       (Point) circuit.elementAt(indiceInsertion+1));
	    etape.addEdge(graph,indicePoint1,indicePoint2);

	    indicePoint1 = graph.ensemblePoints.indexOf(
			       (Point) circuit.elementAt(indiceInsertion-1));
	    indicePoint2 = graph.ensemblePoints.indexOf(
			       (Point) circuit.elementAt(indiceInsertion+1));
	    etape.removeEdge(graph,indicePoint1,indicePoint2);
	    etape.addDistance();
	    dessin.addElement(etape.ligne);

	    // delete
	    reste.removeElementAt(indiceElement);
	    
	}

    }
}
