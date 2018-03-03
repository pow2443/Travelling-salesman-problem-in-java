
package tsp;

/**
 *Project Name : Travelling salesman problem
 * Class:       <b>TSPGUI</b>
 * File:        TSPGUI.java
 * <pre>
 * Description:  Given a list of cities and the distances between each pair of cities, 
 * what is the shortest possible route that visits each city exactly once and returns to the origin city? 
 * It is an NP-hard problem in combinatorial optimization, 
 * important in operations research and theoretical computer science.
 * TSP is a special case of the travelling purchaser problem and the vehicle routing problem.
 * In the theory of computational complexity, the decision version of the TSP (where, 
 * given a length L, the task is to decide whether the graph has any tour shorter than L) 
 * belongs to the class of NP-complete problems. Thus, it is possible that the worst-case running time for any algorithm 
 * for the TSP increases superpolynomially (perhaps, specifically, exponentially) with the number of cities.
 * The problem was first formulated in 1930 and is one of the most intensively studied problems in optimization. 
 * It is used as a benchmark for many optimization methods. Even though the problem is computationally difficult, 
 * a large number of heuristics and exact algorithms are known, so that some instances with tens of thousands of cities can be solved 
 * completely and even problems with millions of cities can be approximated within a small fraction of 1%.[1]
 * The TSP has several applications even in its purest formulation, such as planning, logistics, 
 * and the manufacture of microchips. Slightly modified, it appears as a sub-problem in many areas, 
 * such as DNA sequencing. In these applications, the concept city represents, for example, customers, soldering points, 
 * or DNA fragments, and the concept distance represents travelling times or cost, or a similarity measure between DNA fragments. 
 * The TSP also appears in astronomy, as astronomers observing many sources will want to minimise the time spent moving the telescope 
 * between the sources. In many applications, additional constraints such as limited resources or time windows may be imposed.
 * Platform:     PC, Windows 7, jdk 1.8.0_25, NetBeans 8.0.2
 * Date:         30/05/2016
 * History Log:  30/05/2016
 * @version:    1.0
 * @see:        javax.swing.JFrame
 * @author:     <i>Edgar Hyeongwoo Park</i>
 *Images cited work: park.jpg(https://dribbble.com/shots/2065011-Board-Game-Logo-Alt)
 *                  (This picture doesn't require copyright to me because I use this picture for education)
 *                   tsp.jpg(http://www.austincc.edu/powens/+Topics/HTML/06-3/06-3-4.htm)
 *                  (This picture doesn't require copyright to me because I use this picture for education)
 *                   shortest.jpg(http://support.sas.com/documentation/cdl/en/ornoaug/65289/HTML/default/ornoaug_optnet_examples07.htm)
 *                  (This picture doesn't require copyright to me because I use this picture for education)
 *                  
 * </pre>
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: TSPGUI
* File: TSPGUI.java
* Description: Travelling salesman problem
* Graphic interface to get given information
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 7.0
* Date: 25/Apr/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log:  25/Apr/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class TSPGUI extends javax.swing.JFrame {

    /**
     * Creates new form TSPGUI
     */
    
    
    private ArrayList<Points> allCountry = new ArrayList();
    
    private StringBuilder output = new StringBuilder(); 
    int countw = 0;
    Points p1 = new Points();
    int returnVal;
    final JFileChooser chooser = new JFileChooser("src/resource");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
    private final String fileName = "src/resource/SavedPoint.txt";
    

    
    Graph graph;
    Vector ensemblePoints;
    int nPoints = 0; 

    double dist = 0.0; 

    Vector etapesAlgo = null; 
    int etapeCourante = 0;
    int nEtapes = 0;
    int count = 0;
    
    final static int DIM_ECRAN = 560;  // Display Screen Size
    final static int RAYON_POINT = 3;  // Radius of a point on the screen
    
    public TSPGUI(Graph graph) {
        
        this.setBackground(Color.WHITE);
        this.graph = graph;
	this.ensemblePoints = graph.ensemblePoints; 
	this.nPoints = graph.nPoints;
        initComponents();
        
        pack();
        nearestNeighborJRadioButton.setSelected(true);
        nearestNeighborJRadioButton.setEnabled(false);
        heuristicJRadioButton.setEnabled(false);
        insertionSortJRadioButton.setEnabled(false);
        PrimJRadioButton.setEnabled(false);
        kruskalJRadioButton.setEnabled(false);
        removal2OptJRadioButton.setEnabled(false);
        approximationJRadioButton.setEnabled(false);
        separationEvaluationJRadioButton.setEnabled(false);
        playJButton.setEnabled(false);
        leftJButton.setEnabled(false);
        rightJButton.setEnabled(false);
        
        pointJTextField.requestFocus();
        
        // Set icon image
                 this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/resource/tsp.jpg"));
                 // Set okJButton as default
                 this.getRootPane().setDefaultButton(randomJButton);
                 // Set title
                 this.setTitle("Traveling Salesman Problem(the shortest distance)");
                 // Center the form and set the focus 
                 this.setLocationRelativeTo(null);
        
	setVisible(true); 
        
    }
    
    /**
     * Method:  savePoints()
     * Description:     save the points in SavedPoint.txt
     * @return void
     */
    public void savePoints(String fileName)
    {
        try
        {
           FileWriter filePointer = new FileWriter(fileName, false); 
           PrintWriter output = new PrintWriter(filePointer);
           for (int i = 0; i < nPoints; i++) {
            
	    Point p = new Point((Point) ensemblePoints.elementAt(i));
            
               String line = (char)(i+65) + " " + p.x + " " + p.y;
               output.println(line);
            
            
           }
           output.close();
        }
        catch(IOException exp)
        {
            exp.printStackTrace();
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        algorithmbuttonGroup = new javax.swing.ButtonGroup();
        displayJPanel = new javax.swing.JPanel();
        drawJPanel = new javax.swing.JPanel();
        choiseJPanel = new javax.swing.JPanel();
        pointJPanel = new javax.swing.JPanel();
        pointJTextField = new javax.swing.JTextField();
        randomJButton = new javax.swing.JButton();
        algolithmJPanel = new javax.swing.JPanel();
        nearestNeighborJRadioButton = new javax.swing.JRadioButton();
        heuristicJRadioButton = new javax.swing.JRadioButton();
        insertionSortJRadioButton = new javax.swing.JRadioButton();
        PrimJRadioButton = new javax.swing.JRadioButton();
        kruskalJRadioButton = new javax.swing.JRadioButton();
        removal2OptJRadioButton = new javax.swing.JRadioButton();
        approximationJRadioButton = new javax.swing.JRadioButton();
        separationEvaluationJRadioButton = new javax.swing.JRadioButton();
        playJButton = new javax.swing.JButton();
        leftJButton = new javax.swing.JButton();
        rightJButton = new javax.swing.JButton();
        pointsJLabel = new javax.swing.JLabel();
        autoJComboBox = new javax.swing.JComboBox();
        autoJLabel = new javax.swing.JLabel();
        eraseJButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        resultJPanel = new javax.swing.JPanel();
        totalJLabel = new javax.swing.JLabel();
        distanceJLabel = new javax.swing.JLabel();
        lastJLabel = new javax.swing.JLabel();
        currentJLabel = new javax.swing.JLabel();
        beforeJLabel = new javax.swing.JLabel();
        forwardJLabel = new javax.swing.JLabel();
        standardJLabel = new javax.swing.JLabel();
        standardLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        clearJMenuItem = new javax.swing.JMenuItem();
        openJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        quitJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        displayJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        displayJPanel.setToolTipText("Dessin Panel");
        displayJPanel.setPreferredSize(new java.awt.Dimension(620, 620));

        drawJPanel.setBackground(new java.awt.Color(255, 255, 255));
        drawJPanel.setToolTipText("Drawing pad");
        drawJPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                drawJPanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout drawJPanelLayout = new javax.swing.GroupLayout(drawJPanel);
        drawJPanel.setLayout(drawJPanelLayout);
        drawJPanelLayout.setHorizontalGroup(
            drawJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        drawJPanelLayout.setVerticalGroup(
            drawJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout displayJPanelLayout = new javax.swing.GroupLayout(displayJPanel);
        displayJPanel.setLayout(displayJPanelLayout);
        displayJPanelLayout.setHorizontalGroup(
            displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(drawJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        displayJPanelLayout.setVerticalGroup(
            displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(drawJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(displayJPanel, java.awt.BorderLayout.WEST);

        choiseJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        choiseJPanel.setToolTipText("Control panel");
        choiseJPanel.setPreferredSize(new java.awt.Dimension(330, 620));

        pointJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(" Points "));
        pointJPanel.setToolTipText("How many cities?");

        pointJTextField.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        pointJTextField.setToolTipText("Input number of cities");
        pointJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pointJTextFieldActionPerformed(evt);
            }
        });

        randomJButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        randomJButton.setMnemonic('R');
        randomJButton.setText("Random");
        randomJButton.setToolTipText("getting coordinate randomly");
        randomJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pointJPanelLayout = new javax.swing.GroupLayout(pointJPanel);
        pointJPanel.setLayout(pointJPanelLayout);
        pointJPanelLayout.setHorizontalGroup(
            pointJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pointJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pointJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(randomJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pointJPanelLayout.setVerticalGroup(
            pointJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pointJPanelLayout.createSequentialGroup()
                .addGroup(pointJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pointJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(randomJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        algolithmJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Algorithm"));
        algolithmJPanel.setToolTipText("select a algorithm");

        algorithmbuttonGroup.add(nearestNeighborJRadioButton);
        nearestNeighborJRadioButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        nearestNeighborJRadioButton.setText("Nearest Neighbor");
        nearestNeighborJRadioButton.setToolTipText("Nearest Neighbor");
        nearestNeighborJRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nearestNeighborJRadioButtonMouseClicked(evt);
            }
        });

        algorithmbuttonGroup.add(heuristicJRadioButton);
        heuristicJRadioButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        heuristicJRadioButton.setText("Heuristic");
        heuristicJRadioButton.setToolTipText("algorithm");
        heuristicJRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                heuristicJRadioButtonMouseClicked(evt);
            }
        });

        algorithmbuttonGroup.add(insertionSortJRadioButton);
        insertionSortJRadioButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        insertionSortJRadioButton.setText("Insertion Sort");
        insertionSortJRadioButton.setToolTipText("algorithm");
        insertionSortJRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertionSortJRadioButtonMouseClicked(evt);
            }
        });

        algorithmbuttonGroup.add(PrimJRadioButton);
        PrimJRadioButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        PrimJRadioButton.setText("Prim");
        PrimJRadioButton.setToolTipText("algorithm");
        PrimJRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrimJRadioButtonMouseClicked(evt);
            }
        });

        algorithmbuttonGroup.add(kruskalJRadioButton);
        kruskalJRadioButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        kruskalJRadioButton.setText("Kruskal");
        kruskalJRadioButton.setToolTipText("algorithm");
        kruskalJRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kruskalJRadioButtonMouseClicked(evt);
            }
        });

        algorithmbuttonGroup.add(removal2OptJRadioButton);
        removal2OptJRadioButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        removal2OptJRadioButton.setText("Removal2Opt");
        removal2OptJRadioButton.setToolTipText("algorithm");
        removal2OptJRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removal2OptJRadioButtonMouseClicked(evt);
            }
        });

        algorithmbuttonGroup.add(approximationJRadioButton);
        approximationJRadioButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        approximationJRadioButton.setText("Approximation");
        approximationJRadioButton.setToolTipText("algorithm");
        approximationJRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                approximationJRadioButtonMouseClicked(evt);
            }
        });

        algorithmbuttonGroup.add(separationEvaluationJRadioButton);
        separationEvaluationJRadioButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        separationEvaluationJRadioButton.setText("Separation Evaluation");
        separationEvaluationJRadioButton.setToolTipText("algorithm");
        separationEvaluationJRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                separationEvaluationJRadioButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout algolithmJPanelLayout = new javax.swing.GroupLayout(algolithmJPanel);
        algolithmJPanel.setLayout(algolithmJPanelLayout);
        algolithmJPanelLayout.setHorizontalGroup(
            algolithmJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(algolithmJPanelLayout.createSequentialGroup()
                .addGroup(algolithmJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nearestNeighborJRadioButton)
                    .addComponent(heuristicJRadioButton)
                    .addComponent(insertionSortJRadioButton)
                    .addComponent(PrimJRadioButton)
                    .addComponent(kruskalJRadioButton)
                    .addComponent(removal2OptJRadioButton)
                    .addComponent(approximationJRadioButton)
                    .addComponent(separationEvaluationJRadioButton))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        algolithmJPanelLayout.setVerticalGroup(
            algolithmJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(algolithmJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nearestNeighborJRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heuristicJRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertionSortJRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrimJRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kruskalJRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removal2OptJRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(approximationJRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separationEvaluationJRadioButton)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        playJButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        playJButton.setMnemonic('P');
        playJButton.setText("Play");
        playJButton.setToolTipText("Drawing shortest ");
        playJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playJButtonActionPerformed(evt);
            }
        });

        leftJButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        leftJButton.setMnemonic('B');
        leftJButton.setText("Back Step");
        leftJButton.setToolTipText("back step");
        leftJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftJButtonActionPerformed(evt);
            }
        });

        rightJButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        rightJButton.setMnemonic('F');
        rightJButton.setText("Forward");
        rightJButton.setToolTipText("going up");
        rightJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightJButtonActionPerformed(evt);
            }
        });

        pointsJLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        pointsJLabel.setText("0 of 0");
        pointsJLabel.setToolTipText("showing num of dots");

        autoJComboBox.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        autoJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Randomly ", "Self", "Input Coordinate " }));
        autoJComboBox.setToolTipText("Select options");
        autoJComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                autoJComboBoxItemStateChanged(evt);
            }
        });

        autoJLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        autoJLabel.setText("Select auto or hand operated :");
        autoJLabel.setToolTipText("choose options");

        eraseJButton1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        eraseJButton1.setMnemonic('E');
        eraseJButton1.setText("Erase");
        eraseJButton1.setToolTipText("Erase all dots");
        eraseJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseJButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/shortest.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout choiseJPanelLayout = new javax.swing.GroupLayout(choiseJPanel);
        choiseJPanel.setLayout(choiseJPanelLayout);
        choiseJPanelLayout.setHorizontalGroup(
            choiseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choiseJPanelLayout.createSequentialGroup()
                .addGroup(choiseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choiseJPanelLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(pointsJLabel))
                    .addGroup(choiseJPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(choiseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(algolithmJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pointJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(choiseJPanelLayout.createSequentialGroup()
                                .addComponent(leftJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rightJButton))))
                    .addGroup(choiseJPanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(eraseJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(choiseJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(choiseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(autoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(autoJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        choiseJPanelLayout.setVerticalGroup(
            choiseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choiseJPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(choiseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choiseJPanelLayout.createSequentialGroup()
                        .addComponent(autoJLabel)
                        .addGap(18, 18, 18)
                        .addComponent(autoJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(choiseJPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pointJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(algolithmJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(choiseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftJButton)
                    .addComponent(rightJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pointsJLabel)
                .addGap(18, 18, 18)
                .addComponent(eraseJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(choiseJPanel, java.awt.BorderLayout.EAST);

        resultJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        resultJPanel.setToolTipText("statistic panel");
        resultJPanel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        resultJPanel.setPreferredSize(new java.awt.Dimension(950, 120));

        totalJLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        totalJLabel.setText("Total Points : 0");
        totalJLabel.setToolTipText("showing num of dots");

        distanceJLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        distanceJLabel.setText("Distance : 0.0");
        distanceJLabel.setToolTipText("Current Distance");

        lastJLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lastJLabel.setText("Last Algorithm Time : ");
        lastJLabel.setToolTipText("statistic");

        currentJLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        currentJLabel.setText("Current Algorithm Time : ");
        currentJLabel.setToolTipText("statistic");

        beforeJLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        forwardJLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        standardJLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        standardJLabel.setText("milli seconds");
        standardJLabel.setToolTipText("milli seconds");

        standardLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        standardLabel1.setText("milli seconds");
        standardLabel1.setToolTipText("milli seconds");

        javax.swing.GroupLayout resultJPanelLayout = new javax.swing.GroupLayout(resultJPanel);
        resultJPanel.setLayout(resultJPanelLayout);
        resultJPanelLayout.setHorizontalGroup(
            resultJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultJPanelLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(resultJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalJLabel)
                    .addComponent(distanceJLabel))
                .addGap(186, 186, 186)
                .addGroup(resultJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastJLabel)
                    .addComponent(currentJLabel))
                .addGap(18, 18, 18)
                .addGroup(resultJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(resultJPanelLayout.createSequentialGroup()
                        .addComponent(forwardJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(standardLabel1))
                    .addGroup(resultJPanelLayout.createSequentialGroup()
                        .addComponent(beforeJLabel)
                        .addGap(73, 73, 73)
                        .addComponent(standardJLabel)))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        resultJPanelLayout.setVerticalGroup(
            resultJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultJPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(resultJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalJLabel)
                    .addComponent(lastJLabel)
                    .addComponent(beforeJLabel)
                    .addComponent(standardJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(resultJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(distanceJLabel)
                    .addComponent(currentJLabel)
                    .addComponent(forwardJLabel)
                    .addComponent(standardLabel1))
                .addGap(28, 28, 28))
        );

        getContentPane().add(resultJPanel, java.awt.BorderLayout.SOUTH);

        jMenuBar1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jMenu1.setMnemonic('I');
        jMenu1.setText("File");
        jMenu1.setToolTipText("Instead of buttons");

        clearJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("instead of erase button");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(clearJMenuItem);

        openJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        openJMenuItem.setMnemonic('O');
        openJMenuItem.setText("Open");
        openJMenuItem.setToolTipText("Open the txt file");
        openJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openJMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(openJMenuItem);

        saveJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        saveJMenuItem.setMnemonic('S');
        saveJMenuItem.setText("Save");
        saveJMenuItem.setToolTipText("instead of saving file");
        saveJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(saveJMenuItem);

        printJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        printJMenuItem.setMnemonic('T');
        printJMenuItem.setText("Print");
        printJMenuItem.setToolTipText("print this form");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(printJMenuItem);

        quitJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        quitJMenuItem.setMnemonic('Q');
        quitJMenuItem.setText("Quit");
        quitJMenuItem.setToolTipText("exit");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(quitJMenuItem);

        jMenuBar1.add(jMenu1);

        helpJMenu.setMnemonic('H');
        helpJMenu.setText("Help");
        helpJMenu.setToolTipText("showing about form");

        aboutJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        aboutJMenuItem.setMnemonic('A');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.setToolTipText("uderstanding program ");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        jMenuBar1.add(helpJMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leftJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftJButtonActionPerformed
        // TODO add your handling code here:
        Graphics g = drawJPanel.getGraphics();
        etapeCourante--;
        paintComponent(g);
        ajourneEtape();
      
    }//GEN-LAST:event_leftJButtonActionPerformed

    private void playJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playJButtonActionPerformed
        // TODO add your handling code here:
        
       Graphics g = drawJPanel.getGraphics();
        if(nearestNeighborJRadioButton.isSelected())
        {
            NearestNeighbor ppv = new NearestNeighbor();
            ppv.operation(graph);
            etapesAlgo = ppv.dessin;
            
        }
        else if (heuristicJRadioButton.isSelected()) 
        {
            Heuristic inspp = new Heuristic();
            inspp.operation(graph);
            etapesAlgo = inspp.dessin;	    
        }
        else if (insertionSortJRadioButton.isSelected()) 
        {
            InsertionSort insmc = new InsertionSort();
            insmc.operation(graph);
            etapesAlgo = insmc.dessin;
        }
        else if (PrimJRadioButton.isSelected()) 
        {
            Prim prim = new Prim();
            prim.operation(graph);
            etapesAlgo = prim.dessin;
        }
        else if (kruskalJRadioButton.isSelected()) 
        {
            Kruskal kruskal = new Kruskal();
            kruskal.operation(graph);
            etapesAlgo = kruskal.dessin;
        }
        else if (removal2OptJRadioButton.isSelected()) 
        {
            Removal2Opt e2opt = new Removal2Opt();
            e2opt.operation(graph);
            etapesAlgo = e2opt.dessin;
        }
        else if (approximationJRadioButton.isSelected()) 
        {
            Approximation geom = new Approximation();
            geom.operation(graph);
            etapesAlgo = geom.dessin;
        }
        else if (separationEvaluationJRadioButton.isSelected()) 
        {
            SeparationEvaluation sepa = new SeparationEvaluation(graph);
            sepa.operation(graph);
            etapesAlgo = sepa.dessin;
        }
             
        nEtapes = etapesAlgo.size();
        etapeCourante = 0;
        ajourneEtape();
        ajourneBoutons();
        long startTime = System.currentTimeMillis();
        
        
        try {
		    while (etapeCourante < nEtapes)
			{
			    etapeCourante++;
			    ajourneEtape();
			    distanceJLabel.setText("Distance : " + dist);
                            paintComponent(g);
                            g.setColor(Color.black);
                              
			    Thread.sleep(100);
			}
		} catch (InterruptedException e2) {}	
                long endTime = System.currentTimeMillis();    
                long totalTime = endTime - startTime;
                beforeJLabel.setText(forwardJLabel.getText());
                forwardJLabel.setText(totalTime + "");
                
	    ajourneEtape();
	    ajourneBoutons();
        
        
        
        
    }//GEN-LAST:event_playJButtonActionPerformed

    private void rightJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightJButtonActionPerformed
       
        Graphics g = drawJPanel.getGraphics();
        
        etapeCourante++;
        paintComponent(g);
        ajourneEtape();

    }//GEN-LAST:event_rightJButtonActionPerformed

    private void randomJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomJButtonActionPerformed
        nearestNeighborJRadioButton.setEnabled(true);
        heuristicJRadioButton.setEnabled(true);
        insertionSortJRadioButton.setEnabled(true);
        PrimJRadioButton.setEnabled(true);
        kruskalJRadioButton.setEnabled(true);
        removal2OptJRadioButton.setEnabled(true);
        approximationJRadioButton.setEnabled(true);
        separationEvaluationJRadioButton.setEnabled(true);
        
        
        
        
        String texte = pointJTextField.getText();
        Graphics g = drawJPanel.getGraphics();
        
        
        try {
            
                int nR = Integer.parseInt(texte);
                if (nR < 3) throw new NumberFormatException();
                etapeCourante = 0;
                nEtapes = Integer.parseInt(texte);
                ajourneEtape();
                ajourneBoutons();
                Graph grAlea = new Graph(nR);
                graph = grAlea;
                ensemblePoints = grAlea.ensemblePoints; 
                nPoints = grAlea.nPoints;
                paintComponent(g);
                totalJLabel.setText("Total Points:  " + nPoints);
                
            } 
        catch (NumberFormatException e2) 
            {

            }
        leftJButton.setEnabled(false);
        rightJButton.setEnabled(false);
        
    }//GEN-LAST:event_randomJButtonActionPerformed

    private void drawJPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawJPanelMouseReleased

        nearestNeighborJRadioButton.setEnabled(true);
        heuristicJRadioButton.setEnabled(true);
        insertionSortJRadioButton.setEnabled(true);
        PrimJRadioButton.setEnabled(true);
        kruskalJRadioButton.setEnabled(true);
        removal2OptJRadioButton.setEnabled(true);
        approximationJRadioButton.setEnabled(true);
        separationEvaluationJRadioButton.setEnabled(true);
        
	if(evt.getButton()==1&&autoJComboBox.getSelectedIndex()==1)
	{
        Graphics g = drawJPanel.getGraphics();
        
            playJButton.setEnabled(true);
            Point p=evt.getPoint();
            ensemblePoints.add(p);
            drawJPanel.getGraphics().fillRect(p.x-1,p.y-1,3,3);
            count++;
                
                etapeCourante = 0;
                nEtapes = count;
                ajourneEtape();
                ajourneBoutons();
                
                Graph grAlea = new Graph(ensemblePoints);
                graph = grAlea;
                ensemblePoints = grAlea.ensemblePoints; 
                nPoints = grAlea.nPoints;
                paintComponent(g);
                totalJLabel.setText("Total Points:  " + nPoints);
            
        }
            
    }//GEN-LAST:event_drawJPanelMouseReleased

    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed

        // TODO add your handling code here:
        PrintUtilities.printComponent(this);

    }//GEN-LAST:event_printJMenuItemActionPerformed

    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
        // TODO add your handling code here:
        System.exit(0);

    }//GEN-LAST:event_quitJMenuItemActionPerformed

    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        // show about
        About about = new About();
        about.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed

    private void openJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openJMenuItemActionPerformed
        // Open an array of unsorted integers but serialized
         nearestNeighborJRadioButton.setEnabled(true);
        heuristicJRadioButton.setEnabled(true);
        insertionSortJRadioButton.setEnabled(true);
        PrimJRadioButton.setEnabled(true);
        kruskalJRadioButton.setEnabled(true);
        removal2OptJRadioButton.setEnabled(true);
        approximationJRadioButton.setEnabled(true);
        separationEvaluationJRadioButton.setEnabled(true);
        chooser.setFileFilter(filter);
        output.delete(0, output.length());
        countw = 0;
        Graphics g = drawJPanel.getGraphics();
        Graphics g1 = drawJPanel.getGraphics();
        g1.setColor(Color.white);
        g1.fillRect(0, 0, drawJPanel.getWidth(), drawJPanel.getHeight());
        returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();

            //read integer from external selected file
            try
            {
                // Clear JTextArea and output StringBuffer

                BufferedReader input = new BufferedReader(new FileReader(file));
                String line = input.readLine();     // read first line
                while(line != null)    // read as long as there are lines in file
                {

                    StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                    while (stringTokenizer.hasMoreTokens())
                    {
                        p1.setVertex(stringTokenizer.nextToken());
                        p1.setxValue(Integer.parseInt(stringTokenizer.nextToken()));
                        p1.setyValue(Integer.parseInt(stringTokenizer.nextToken()));
                      
                        countw+=1;
                    

                        etapeCourante = 0;
                        nEtapes = countw;
                        ajourneEtape();

                        //choiseJPanel.initChoixAlgos();
                        Graph grAlea = new Graph(file.toString());
                        graph = grAlea;
                        ensemblePoints = grAlea.ensemblePoints;
                        nPoints = grAlea.nPoints;

                        if (etapeCourante != 0) {
                            // Draw the ares of the current step
                            Vector etape = new Vector(
                                (Vector) etapesAlgo.elementAt(etapeCourante - 1));
                            int n = 0;
                            while (n < etape.size() - 1) {
                                DrawingEdge edge = (DrawingEdge) etape.elementAt(n);
                                g.drawLine(edge.point1.x, edge.point1.y,
                                    edge.point2.x, edge.point2.y);
                                n++;
                               
                            }
                            dist = ((Double) etape.elementAt(etape.size() - 1));
                        }
                        else {
                            dist = 0.0;
                        }
                        for (int i = 0; i < nPoints; i++) {
                            Point p = new Point((Point) ensemblePoints.elementAt(i));
                            g.setColor(Color.green);
                            g.fillOval(p.x - RAYON_POINT, p.y - RAYON_POINT,
                                RAYON_POINT * 2, RAYON_POINT * 2);
                        }

                        distanceJLabel.setText("Distance : " + dist);
                        totalJLabel.setText("Total Points:  " + nPoints);
                        output.append(p1.getxValue() +  " " + p1.getyValue() + "\n");

                        // Draws the points

                        distanceJLabel.setText("Distance : " + dist);

                    }
                    line = input.readLine();

                }
                

            }
            catch (FileNotFoundException ex)
            {
                System.out.print("File Open Error: " + ex.getMessage());
            }
            catch (IOException ex)
            {
                System.out.print("File Error: " + ex.getMessage());
            }
            
        }

    }//GEN-LAST:event_openJMenuItemActionPerformed

    private void nearestNeighborJRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nearestNeighborJRadioButtonMouseClicked
        // TODO add your handling code here:
        playJButton.setEnabled(true);
        leftJButton.setEnabled(false);
        rightJButton.setEnabled(false);
        
    }//GEN-LAST:event_nearestNeighborJRadioButtonMouseClicked

    private void heuristicJRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_heuristicJRadioButtonMouseClicked
        // TODO add your handling code here:
        playJButton.setEnabled(true);
        leftJButton.setEnabled(false);
        rightJButton.setEnabled(false);
    }//GEN-LAST:event_heuristicJRadioButtonMouseClicked

    private void insertionSortJRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertionSortJRadioButtonMouseClicked
        // TODO add your handling code here:
        playJButton.setEnabled(true);
        leftJButton.setEnabled(false);
        rightJButton.setEnabled(false);
    }//GEN-LAST:event_insertionSortJRadioButtonMouseClicked

    private void PrimJRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrimJRadioButtonMouseClicked
        // TODO add your handling code here:
        playJButton.setEnabled(true);
        leftJButton.setEnabled(false);
        rightJButton.setEnabled(false);
    }//GEN-LAST:event_PrimJRadioButtonMouseClicked

    private void kruskalJRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kruskalJRadioButtonMouseClicked
        // TODO add your handling code here:
        playJButton.setEnabled(true);
        leftJButton.setEnabled(false);
        rightJButton.setEnabled(false);
    }//GEN-LAST:event_kruskalJRadioButtonMouseClicked

    private void removal2OptJRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removal2OptJRadioButtonMouseClicked
        // TODO add your handling code here:
        playJButton.setEnabled(true);
        leftJButton.setEnabled(false);
        rightJButton.setEnabled(false);
    }//GEN-LAST:event_removal2OptJRadioButtonMouseClicked

    private void approximationJRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approximationJRadioButtonMouseClicked
        // TODO add your handling code here:
        playJButton.setEnabled(true);
        leftJButton.setEnabled(false);
        rightJButton.setEnabled(false);
    }//GEN-LAST:event_approximationJRadioButtonMouseClicked

    private void separationEvaluationJRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_separationEvaluationJRadioButtonMouseClicked
        // TODO add your handling code here:
        playJButton.setEnabled(true);
        leftJButton.setEnabled(false);
        rightJButton.setEnabled(false);
    }//GEN-LAST:event_separationEvaluationJRadioButtonMouseClicked

    private void eraseJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraseJButton1ActionPerformed
        
        
	drawJPanel.getGraphics().clearRect(0, 0, drawJPanel.getWidth(), drawJPanel.getHeight());
	ensemblePoints.clear();
        autoJComboBox.setSelectedItem("Randomly ");
        pointJTextField.setText("");
        pointsJLabel.setText("0 of 0");
        totalJLabel.setText("Total Points : 0");
        distanceJLabel.setText("Distance : 0.0");
        nearestNeighborJRadioButton.setSelected(true);
        
        
        nearestNeighborJRadioButton.setEnabled(false);
        heuristicJRadioButton.setEnabled(false);
        insertionSortJRadioButton.setEnabled(false);
        PrimJRadioButton.setEnabled(false);
        kruskalJRadioButton.setEnabled(false);
        removal2OptJRadioButton.setEnabled(false);
        approximationJRadioButton.setEnabled(false);
        separationEvaluationJRadioButton.setEnabled(false);
        playJButton.setEnabled(false);
        leftJButton.setEnabled(false);
        rightJButton.setEnabled(false);
        pointJTextField.requestFocus();
        
    }//GEN-LAST:event_eraseJButton1ActionPerformed

    private void saveJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJMenuItemActionPerformed
        // TODO add your handling code here:
        savePoints(fileName);
        
    }//GEN-LAST:event_saveJMenuItemActionPerformed

    private void pointJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pointJTextFieldActionPerformed
        // TODO add your handling code here:
        randomJButton.setEnabled(true);
    }//GEN-LAST:event_pointJTextFieldActionPerformed

    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        // TODO add your handling code here:
        eraseJButton1ActionPerformed(evt);
    }//GEN-LAST:event_clearJMenuItemActionPerformed

    private void autoJComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_autoJComboBoxItemStateChanged
       
        String b = "Input Coordinate ";
        
        if(autoJComboBox.getSelectedItem()== "Randomly")
        {
            randomJButton.setEnabled(true);
        }
        else if(autoJComboBox.getSelectedItem()== "Self")
        {
            randomJButton.setEnabled(false);
        }
        
        else if(autoJComboBox.getSelectedItem()==b)
        {
            
            String numPoint =JOptionPane.showInputDialog("Please enter the number of points :");
            
            int a=Integer.parseInt(numPoint);
            
            for(int i = 0; i < a; i++ )
            {
                String inx=JOptionPane.showInputDialog("Please enter x coordinate of " + (i + 1) +"th point:");
                String iny=JOptionPane.showInputDialog("Please enter y coordinate of " + (i + 1) + "th point:");
                
                
                
                 Graphics g = drawJPanel.getGraphics();

             Point point = new Point(Integer.parseInt(inx),Integer.parseInt(iny));
           
            ensemblePoints.add(point);
            
            
            
                nEtapes = a;
                ajourneEtape();
                ajourneBoutons();
                Graph grAlea = new Graph(ensemblePoints);
                graph = grAlea;
                ensemblePoints = grAlea.ensemblePoints; 
                nPoints = grAlea.nPoints;
                paintComponent(g);
                totalJLabel.setText("Total Points:  " + nPoints); 
                
                autoJComboBox.setSelectedItem("Randomly");
                
                }
            
            
            nearestNeighborJRadioButton.setEnabled(true);
            heuristicJRadioButton.setEnabled(true);
            insertionSortJRadioButton.setEnabled(true);
            PrimJRadioButton.setEnabled(true);
            kruskalJRadioButton.setEnabled(true);
            removal2OptJRadioButton.setEnabled(true);
            approximationJRadioButton.setEnabled(true);
            separationEvaluationJRadioButton.setEnabled(true);
            
            randomJButton.setEnabled(true);
        }
        
    }//GEN-LAST:event_autoJComboBoxItemStateChanged

    
    public void ajourneEtape() {
	pointsJLabel.setText(etapeCourante + " of " + nEtapes);
        ajourneBoutons();
    }
    
    public void ajourneBoutons() {
	leftJButton.setEnabled(true);
	rightJButton.setEnabled(true);
	playJButton.setEnabled(true);
	// The following tests to contain securit
        if (etapeCourante <= 0) {
	    etapeCourante = 0;
	    leftJButton.setEnabled(false);
	} 
	if (etapeCourante >= nEtapes) {
	    etapeCourante = nEtapes;
	    rightJButton.setEnabled(false);
	    playJButton.setEnabled(false);
	}
        
    }
    
    public void redessine() {
	drawJPanel.repaint();
    }
    
    public void initChoixAlgos() {
	algorithmbuttonGroup.setSelected(null, true);
    }
    
    
    public void paintComponent(Graphics g) {
        
        Graphics g1 = drawJPanel.getGraphics();
        g1.setColor(Color.white);
        g1.fillRect(0, 0, drawJPanel.getWidth(), drawJPanel.getHeight());
        
	if (etapeCourante != 0) {
	    // Draw the ares of the current step
	    Vector etape = new Vector(
			     (Vector) etapesAlgo.elementAt(etapeCourante - 1));
	    int n = 0;
	    while (n < etape.size() - 1) {
		DrawingEdge edge = (DrawingEdge) etape.elementAt(n);
		g.drawLine(edge.point1.x, edge.point1.y, 
			   edge.point2.x, edge.point2.y);
		n++;
                
	    }
	    dist = ((Double) etape.elementAt(etape.size() - 1));
	}
	else {
	    dist = 0.0;
	}

	// Draws the points
	for (int i = 0; i < nPoints; i++) {
            
	    Point p = new Point((Point) ensemblePoints.elementAt(i));
           
	    g.setColor(Color.green);
	    g.fillOval(p.x - RAYON_POINT, p.y - RAYON_POINT, 
		       RAYON_POINT * 2, RAYON_POINT * 2);
            
	}

	distanceJLabel.setText("Distance : " + dist); 
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
	    Graph gr; 
	    if (args.length == 0) gr = new Graph(0);
	    else gr = new Graph(args[0]);

	    TSPGUI fenetre = new TSPGUI(gr);
            fenetre.setVisible(true); 
	} catch (IOException e) {
	    System.out.println("NO");
	}
                
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton PrimJRadioButton;
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JPanel algolithmJPanel;
    private javax.swing.ButtonGroup algorithmbuttonGroup;
    private javax.swing.JRadioButton approximationJRadioButton;
    private javax.swing.JComboBox autoJComboBox;
    private javax.swing.JLabel autoJLabel;
    private javax.swing.JLabel beforeJLabel;
    private javax.swing.JPanel choiseJPanel;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JLabel currentJLabel;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JLabel distanceJLabel;
    private javax.swing.JPanel drawJPanel;
    private javax.swing.JButton eraseJButton1;
    private javax.swing.JLabel forwardJLabel;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JRadioButton heuristicJRadioButton;
    private javax.swing.JRadioButton insertionSortJRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton kruskalJRadioButton;
    private javax.swing.JLabel lastJLabel;
    private javax.swing.JButton leftJButton;
    private javax.swing.JRadioButton nearestNeighborJRadioButton;
    private javax.swing.JMenuItem openJMenuItem;
    private javax.swing.JButton playJButton;
    private javax.swing.JPanel pointJPanel;
    private javax.swing.JTextField pointJTextField;
    private javax.swing.JLabel pointsJLabel;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JButton randomJButton;
    private javax.swing.JRadioButton removal2OptJRadioButton;
    private javax.swing.JPanel resultJPanel;
    private javax.swing.JButton rightJButton;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JRadioButton separationEvaluationJRadioButton;
    private javax.swing.JLabel standardJLabel;
    private javax.swing.JLabel standardLabel1;
    private javax.swing.JLabel totalJLabel;
    // End of variables declaration//GEN-END:variables
}
