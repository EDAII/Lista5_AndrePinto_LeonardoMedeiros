/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista5_andrepinto_leonardomedeiros;

/**
 *
 * @author andrelucax
 */
public class TutorialScreen extends javax.swing.JFrame {

    /**
     * Creates new form TutorialScreen
     */
    public TutorialScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();

        jLabel2.setText("<html><body> \n- What is a AVL Tree?\n<br> \nAVL tree (named after inventors Adelson-Velsky and Landis) is a self-balancing binary search tree so the heights of the two child subtrees of any node differ by at most one.\n If at any time they differ by more than one, rebalancing is done to restore this property.\n Lookup, insertion, and deletion all take O(log n) time in both the average and worst cases, where n is the number of nodes in the tree\n Insertions and deletions may require the tree to be rebalanced by one or more tree rotations\n AVL trees are often compared with red–black trees because both support the same set of operations and take O(log n) time for the basic operations. For lookup-intensive applications, AVL trees are faster than red–black trees because they are more strictly balanced.\n<br><br>\n- Insertion opetarion\n<br>\nThe insertion operation follow the same flow of a normal binary search tree, but for the AVL tree there are 4 cases that can desbalance the tree:\n<br>\n1: Inserted node generated a node that have balance 2 and it's right child has balance 1. In this case this the node with balance 2 will do a left rotation;\n<br>\n2: Inserted node generated a node that have balance -2 and it's right child has balance -1. In this case this the node with balance -2 will do a right rotation;\n<br>\n3: Inserted node generated a node that have balance 2 and it's right child has balance -1. In this case the node with balance -1 do a left rotation and then the node with balance 2 do a right rotation;\n<br>\n4: Inserted node generated a node that have balance 2 and it's right child has balance -1. In this case the node with balance 1 do a right rotation and then the node with balance -2 do a left rotation.\n<br><br>\n- The game\n<br>\nIn this game your job is to tell what node will need a rotation. But be careful, your life is in DANGER, if you give a wrong answer you will die! You will have 20 seconds to get as much points as posible,\n when the time gets to 0 you die too, so it's more secure to don't play the game. The score is based on the time remaining, when you\n get a right answer your score will increase the time left value, so basically the more you do, the less you won.\n If you want to tell a node will do a left rotation click in it with the left button, if you want to tell a node will do a right rotation click in\n it with the right button (don't try the center button, please). You will know your actual answer looking at the nodes colours, it\n will follow the same colours as it's described in the game (you will see it, I swear). If no nodes will do any rotation\n your answer will have no nodes marked. When you have finished your answer just click in the \"ANSWER\" button.\n When you get a right answer your time limit will be incresed in 10% of the actual left time, but don't worry, you can't win, not even\n when your score pass 6669666, I guess, can't remenber.\n<br><br>\nI will give no examples, you can handle it... I guess...\n<br><br>\nGood luck! And remenber your life is in DANGER, so don't play it.<br>\n\n </body></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TutorialScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TutorialScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TutorialScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TutorialScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TutorialScreen().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}