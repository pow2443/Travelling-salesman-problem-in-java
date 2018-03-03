package tsp;

import java.awt.Toolkit;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: About
* File: About.java
* Description: Helping user to understand about this program 
* subject of project Traveling salesman porblem
* @author: Edgar Hyeongwoo Park
* Environment: PC, Windows 7, jdk1.8, NetBeans 8.0.2
* Date: 30/05/2016
* @version 1.0
* @see javax.swing.JFrame
* History Log: 30/05/2016
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class About extends javax.swing.JFrame {

    /**
     * Creates new form About
     */
    public About() {
        initComponents();
        
                // Set icon image
                // citation image (http://worldartsme.com/employees/?order=alphabetical)
                 this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/resource/tsp.jpg"));
                 // Set okJButton as default
                 this.getRootPane().setDefaultButton(closeJButton);
                 // Set title
                 this.setTitle("Traveling Salesman Problem About Form");
                 // Center the form and set the focus 
                 this.setLocationRelativeTo(null);
                 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeJButton = new javax.swing.JButton();
        discriptionJScrollPane = new javax.swing.JScrollPane();
        descriptionJTextArea = new javax.swing.JTextArea();
        nameJLabel = new javax.swing.JLabel();
        logoJLabel = new javax.swing.JLabel();
        copyrightJLabel = new javax.swing.JLabel();
        warningJLabel = new javax.swing.JLabel();
        vendorJLabel = new javax.swing.JLabel();
        versionJLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        closeJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        closeJButton.setMnemonic('C');
        closeJButton.setText("Close");
        closeJButton.setToolTipText("exit");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });

        descriptionJTextArea.setEditable(false);
        descriptionJTextArea.setBackground(new java.awt.Color(204, 204, 204));
        descriptionJTextArea.setColumns(20);
        descriptionJTextArea.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        descriptionJTextArea.setRows(5);
        descriptionJTextArea.setText("The Travelling Salesman Problem (often called TSP) is a classic algorithmic problem \nin the field of computer science. It is focused on optimization. \nIn this context better solution often means a solution that is cheaper. \nTSP is a mathematical problem. It is most easily expressed \nas a graph describing the locations of a set of nodes.\n\nThe Travelling Salesman Problem describes a salesman who must travel between N cities. \nThe order in which he does so is something he does not care about, \nas long as he visits each one during his trip, and finishes where he was at first. Each city is connected to other close by cities, or nodes, by airplanes, or by road or railway. \nEach of those links between the cities has one or more weights (or the cost) attached.\nThe cost describes how \"difficult\" it is to traverse this edge on the graph, and may be given, \nfor example, by the cost of an airplane ticket or train ticket, \nor perhaps by the length of the edge, or time required to complete the traversal. \nThe salesman wants to keep both the travel costs, \nas well as the distance he travels as low as possible.\n\nThe Traveling Salesman Problem is typical of a large class of \"hard\" optimization problems that \nhave intrigued mathematicians and computer scientists for years. \nMost important, it has applications in science and engineering. For example,\nin the manufacture of a circuit board, \nit is important to determine the best order in which a laser will drill thousands of holes. \nAn efficient solution to this problem reduces production costs for the manufacturer.");
        descriptionJTextArea.setToolTipText("description");
        descriptionJTextArea.setCaretColor(new java.awt.Color(204, 204, 204));
        discriptionJScrollPane.setViewportView(descriptionJTextArea);

        nameJLabel.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        nameJLabel.setText("About : TSP ");
        nameJLabel.setToolTipText("title");

        copyrightJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        copyrightJLabel.setText("Copyright : Free");
        copyrightJLabel.setToolTipText("free copyright");

        warningJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        warningJLabel.setText("Warning   :   ...");
        warningJLabel.setToolTipText("no warning");

        vendorJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        vendorJLabel.setText("vendor :    Edgar Hyeongwoo Park");
        vendorJLabel.setToolTipText("name");

        versionJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        versionJLabel.setText("Product version :          1.1");
        versionJLabel.setToolTipText("version");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/tsp.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(discriptionJScrollPane)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(versionJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(copyrightJLabel)
                        .addGap(105, 105, 105))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameJLabel)
                            .addComponent(vendorJLabel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(warningJLabel)
                                .addGap(115, 115, 115))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(logoJLabel)
                                .addGap(51, 51, 51))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(nameJLabel)
                                .addGap(48, 48, 48)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(versionJLabel)
                            .addComponent(copyrightJLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vendorJLabel)
                            .addComponent(warningJLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(discriptionJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();//exit

    }//GEN-LAST:event_closeJButtonActionPerformed

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
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new About().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeJButton;
    private javax.swing.JLabel copyrightJLabel;
    private javax.swing.JTextArea descriptionJTextArea;
    private javax.swing.JScrollPane discriptionJScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JLabel vendorJLabel;
    private javax.swing.JLabel versionJLabel;
    private javax.swing.JLabel warningJLabel;
    // End of variables declaration//GEN-END:variables
}
