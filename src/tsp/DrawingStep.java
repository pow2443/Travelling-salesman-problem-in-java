package tsp;

import java.util.*;
import java.awt.Point;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: DrawingStep
* File: DrawingStep.java
* showing drawing steps
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class DrawingStep {
  Vector ligne;
  double distance;

  DrawingStep() {
    ligne = new Vector();
    distance = 0;
  }

  DrawingStep(double distance) {
    ligne = new Vector();
    this.distance = distance;
  }

  double addEdge(Graph graph, int indicePoint1, int indicePoint2){

    // Add the edges
    ligne.addElement("add");

    Point point1 = (Point) graph.ensemblePoints.elementAt(indicePoint1);
    Point point2 = (Point) graph.ensemblePoints.elementAt(indicePoint2);
    DrawingEdge edge  = new DrawingEdge(point1,point2);
    ligne.addElement(edge);
    distance += graph.tableauDistances[indicePoint1][indicePoint2];
    return distance;
  }

  double removeEdge(Graph graph, int indicePoint1, int indicePoint2){

    // Delete an edge
    ligne.addElement("remove");

    Point point1 = (Point) graph.ensemblePoints.elementAt(indicePoint1);
    Point point2 = (Point) graph.ensemblePoints.elementAt(indicePoint2);
    DrawingEdge edge  = new DrawingEdge(point1,point2);
    ligne.addElement(edge);
    distance -= graph.tableauDistances[indicePoint1][indicePoint2];
    return distance;
  }
    
    double clear(){

    // Delete an edge
    ligne.addElement("remove all");
    distance = 0 ;
    return distance;
    
  }

  void addDistance(){
  ligne.addElement("length");
  ligne.addElement(new Double(distance));
  }

}
