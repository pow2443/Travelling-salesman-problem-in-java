package tsp;

import java.util.*;
import java.io.*;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Graph
* File: Graph.java
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class Graph {

    Vector ensemblePoints;       // Connect the points.
    int nPoints;                 // The number of points.
    double[][] tableauDistances; // Distance between each point.
    Points p1 = new Points();

    /** 
     * Constructor * 
     * @param set points connect all items 
     */
    Graph(Vector ensemblePoints) {
	this.ensemblePoints = ensemblePoints;
	this.nPoints = ensemblePoints.size();
	this.calculeDistances();
    }

    /** 
     * Default constructor 
     */
    Graph() {
	this.ensemblePoints = null;
    }

    /**
      * Constructor from a file
      *
      * @param Filename filename.
      */
    Graph(String nomFichier) throws FileNotFoundException, IOException {
	Vector v = new Vector();        // Array containing points.
	String ligne = new String();    // Line of a file.
	FileReader f = new FileReader(nomFichier);   // Open the file
	LineNumberReader lecteur = new LineNumberReader(f);
	
	// Read the file line by line
	while ((ligne = lecteur.readLine()) != null) {
	    StringTokenizer st = new StringTokenizer(ligne);
	    while (st.hasMoreTokens()) {
		p1.setVertex(st.nextToken());
                p1.setxValue(Integer.parseInt(st.nextToken()));
                p1.setyValue(Integer.parseInt(st.nextToken()));
		Point point = new Point(p1.getxValue(), p1.getyValue());
		v.addElement(point);
                
	    }
	}
	
	// Last updated attributes
	this.ensemblePoints = v;
	this.nPoints = ensemblePoints.size();
	this.calculeDistances();
    }

     /** 
      * Constructor from a given number of items * 
      * @param Random Points numbers of points. 
      */
    
    Graph(int nRandomPoints) {
	Vector v = new Vector();      // Array containing points.
	Random rand = new Random();

	// Create the points
	for (int k = 1; k <= nRandomPoints; k++) {
	    Point point = new Point(TSPGUI.RAYON_POINT + 
	                  rand.nextInt(TSPGUI.DIM_ECRAN - 2 * TSPGUI.RAYON_POINT),
	                  TSPGUI.RAYON_POINT +
	                  rand.nextInt(TSPGUI.DIM_ECRAN - 2 * TSPGUI.RAYON_POINT));
	    v.addElement(point);	    
	}
	
	// Last updated attributes
	this.ensemblePoints = v;
	this.nPoints = ensemblePoints.size();
	this.calculeDistances();
    }

    /** 
     * Method calculating the distances between each point 
     */
    public void calculeDistances() {
	int nPoints = ensemblePoints.size();
	tableauDistances = new double[nPoints][nPoints];

	for (int i = 0; i < nPoints; i++) {
	    for (int j = 0; j < nPoints; j++) {
		double dist = ((Point) ensemblePoints.elementAt(i)).
		                 distance((Point) ensemblePoints.elementAt(j));
		tableauDistances[i][j] = dist;
	    }
	}
    }

    /** 
     * Mode displaying distances between points with a format 
     */
    public String addedDistances() {
	StringBuffer buffer = new StringBuffer("\n");
	
	DecimalFormatSymbols dfs = new DecimalFormatSymbols();
	dfs.setDecimalSeparator('.');
	DecimalFormat df = new DecimalFormat("000.00000", dfs);

	for (int i = 0; i < nPoints; i++) {
	    for (int j = 0; j < nPoints; j++) {
		double distance = tableauDistances[i][j];
		buffer.append(df.format(distance) + " ");
	    }
	    buffer.append("\n");
	}
	return buffer.toString();
    }
    
     /** 
      * Displays the points and their details 
      */
    public String toString() {
	StringBuffer buffer = new StringBuffer();
	for (int i = 1; i <= ensemblePoints.size(); i++) {
	    buffer.append(i + ") " + ensemblePoints.elementAt(i-1) + "\n");
	}
	return buffer.toString();
    }

}
