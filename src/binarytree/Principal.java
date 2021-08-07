/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author jeff
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BinaryTree arbol = new BinaryTree();
        
        arbol.add(6);
        arbol.add(4);
        arbol.add(8);
        arbol.add(3);
        arbol.add(5);
        arbol.add(7);
        arbol.add(9);
        
        arbol.preOrden(arbol.root);
        
        
        boolean response = arbol.contieneNodoRecursivo(arbol.root, 7);
        System.out.println("\n" + response);   
        
        arbol.delete(7);
        
        arbol.preOrden(arbol.root);
        
        response = arbol.contieneNodoRecursivo(arbol.root, 7);
        System.out.println("\n" + response);
    }
    
}
