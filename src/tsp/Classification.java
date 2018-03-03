package tsp;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Classification
* File: Classification.java
* Overseer classes / unions on a whole.
* Use for Kruskal's algorithm.
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class Classification {

    private int [] board;    // together.
    private int size;        // Size of the assembly.
    private int nbPartitions;  // Number of partitions of the set.

    /**
     * Manufacturer
     *
     * @param Size set size
     */
    Classification(int size){
	this.size = size;
	board = new int[size];
	nbPartitions = size;
	
	// initialisation de l'ensemble.
	for(int i=0;  i<size;i++){
	    board[i] = i;
	}
    }
    
    /**
     * Elise x the union of class with class 
     * @param y class x  class 
     * @param y class y
     */
    void union (int x,int y){
	int classe1;
	int classe2;

	// recherche de la classe qui va ?re inclue dans l'autre
	if( board[x] < board[y]){
	    classe1=board[x];
	    classe2=board[y];
	}
	else{
	    classe1=board[y];
	    classe2=board[x];
	}

	// union
	for(int i=0;i<size; i++){
	    if( board[i] == classe2)
		board[i] = classe1;
	}

	nbPartitions --;
	
    }

    /**
     * Change the contents of the array a given index 
     * 
     * @param indice number of top 
     * @param numero insertion index
     */
    void set(int indice, int numero){
	board[indice] = numero;
    }

    /**
      * Returns the number of partitions of the set
      *
      * @return nbPartitions  
      *  Number of partitions of all
      */
    int getNombrePartitions(){
	return nbPartitions;
    }

    /**
      * Tests if two vertices belong to class me
      *
      * @param Sommet1 number of the first somemt compare
      * @param Summit2 number of the second summit compare
      * @ Return the test results
      */
    boolean sameClassification(int vertex1, int vertex2){
	if(board[vertex1] == board[vertex2])
	    return true;
	return false;
    }

}
