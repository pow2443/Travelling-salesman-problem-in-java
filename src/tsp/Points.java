
package tsp;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Points
* File: Points.java
* saving coordinate of points.
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Points {

   // instance variables
    private String vertex;
    private int xValue;
    private int yValue;
    
    /**
     * Default constructor with no argument
     */
    public Points()
    {
        
    }
    
    /**
     * @param name
     * @param capital
     * @param pop

     */
    public Points(String vertex, int xval, int yval)
    {
        this.vertex = vertex;
        xValue = xval;
        yValue = yval;

    }

    public Points(int xval, int yval)
    {
       
        xValue = xval;
        yValue = yval;

    }
    
    public String getVertex() {
        return vertex;
    }

    public void setVertex(String vertex) {
        this.vertex = vertex;
    }

    public int getxValue() {
        return xValue;
    }

    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }
    
    
}
