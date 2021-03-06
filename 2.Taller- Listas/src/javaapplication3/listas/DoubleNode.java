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
public class DoubleNode<V> {
    private V data;
    private DoubleNode<V> nextNode;
    private DoubleNode<V> previousNode;

    public DoubleNode(V data){
        this(null,data,null);
    }
    
    public DoubleNode(DoubleNode prevNod, V data, DoubleNode nextNod){   //(nodo anterior, data, nodo siguiente)
        setData(data);
        setNextNode(nextNod);
        setPreviousNode(prevNod);
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
    public DoubleNode<V> getNextNode() {
        return nextNode;
    }

    /**
     * @param nextNode the nextNode to set
     */
    public void setNextNode(DoubleNode<V> nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * @return the previousNode
     */
    public DoubleNode<V> getPreviousNode() {
        return previousNode;
    }

    /**
     * @param previousNode the previousNode to set
     */
    public void setPreviousNode(DoubleNode<V> previousNode) {
        this.previousNode = previousNode;
    }
}
