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
public class BinaryTree {
    Nodo root;
    
    //inserta un nodo
    public void add(int valor){
        root = addRecursivo(root, valor);
    }
    
    //método recursivo
    private Nodo addRecursivo(Nodo actual, int valor){
        if(actual == null){
            return new Nodo(valor);
        }
        
        if(valor < actual.valor){
            actual.izquierda = addRecursivo(actual.izquierda, valor);
        }
        else if(valor > actual.valor){
            actual.derecha = addRecursivo(actual.derecha, valor);
        }else{
            return actual;
        }
        
        return actual;
    }
    
    //imprime nodo
    public void preOrden(Nodo nodo){
        if(nodo != null){
            System.out.print(" " + nodo.valor);
            preOrden(nodo.izquierda);
            preOrden(nodo.derecha);
        }
    }
    
    public void postOrden(Nodo nodo){
        if(nodo != null){
            postOrden(nodo.izquierda);
            postOrden(nodo.derecha);
            System.out.print(" " + nodo.valor);
        }
    }
    
    public void inOrden(Nodo nodo){
        if(nodo != null){
            inOrden(nodo.izquierda);
            System.out.print(" " + nodo.valor);
            inOrden(nodo.derecha);
        }
    }
    
    //eliminar nodo
    public void delete(int valor){
        deleteRecursivo(root, valor);
    }
    
    private Nodo deleteRecursivo(Nodo actual, int valor){
        if(actual == null)
            return null;
        if(valor == actual.valor){
            //si el nodo es una terminación u hoja
            if(actual.izquierda == null && actual.derecha == null){
                return null;
            }
            
            //si el nodo tiene un hijo
            if(actual.derecha == null)
                return actual.izquierda;
            if(actual.izquierda == null)
                return actual.derecha;
            
            //si el nodo tiene dos hijos
            int valorMasPequeno = encuentraValorMasPequeno(actual.derecha);
            actual.valor = valorMasPequeno;
            actual.derecha = deleteRecursivo(actual.derecha, valorMasPequeno);
            return actual;
        }
        if(valor < actual.valor){
            actual.izquierda = deleteRecursivo(actual.izquierda, valor);
            return actual;
        }
        actual.derecha = deleteRecursivo(actual.derecha, valor);
        return actual;
                    
    }
    
    //encuentra el nodo con el valor más pequeño
    private int encuentraValorMasPequeno(Nodo root){
         return root.izquierda == null ? root.valor : encuentraValorMasPequeno(root.izquierda);   
    }
    
    //encuentra nodo
    public boolean contieneNodoRecursivo(Nodo actual, int valor){
        if(actual == null)
            return false;
        if(valor == actual.valor){
            return true;
        }
        if(valor <  actual.valor){
            return contieneNodoRecursivo(actual.izquierda, valor);
        }
        else
            return contieneNodoRecursivo(actual.derecha, valor);
    }
}
