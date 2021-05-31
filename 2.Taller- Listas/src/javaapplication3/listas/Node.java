  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.listas;

/**
 *
 * @author samaniw
 */
public class Node<V> {   
    private V data;             //Tengo la libertar de decidir que tipo de dato es.
    private Node<V> nextNode;

    public Node(V data){        //Constructor        
        this.data = data;       //this :la utilizo cuando tenga que aclarar la clase
        this.nextNode = null;   //Nodo vacio
    }
    
    public Node(V data, Node nextNode){
        setData(data);
        setNextNode(nextNode);   
    }

    /**
     * @return the data
     */
    public V getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(V data) {
        this.data = data;
    }

    /**
     * @return the nextNode
     */
    public Node<V> getNextNode() {
        return nextNode;
    }

    /**
     * @param nextNode the nextNode to set
     */
    public void setNextNode(Node<V> nextNode) {
        this.nextNode = nextNode;    
    }
}