/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista5_andrepinto_leonardomedeiros;
import static java.lang.System.exit;
import java.util.Collections;
import java.util.ArrayList;
/**
 *
 * @author andrelucax
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        InitScreen initScreen = new InitScreen();
        initScreen.setSize(800, 600);
        initScreen.setLocationRelativeTo(null);
        initScreen.setVisible(false);
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;
        ArrayList randNumbers = new ArrayList();
        for(int i = 1; i <= 50; i++){
            randNumbers.add(i);
        }
        Collections.shuffle(randNumbers);
        for(int i = 0; i < 15; i++){
            root = tree.insert(root, (int)randNumbers.get(i));
        }
        tree.print(root);
        tree.treeToArray(root);
        
        exit(0);
    }
    
    public static int getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
}
