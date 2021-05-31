/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author Usuario
 */
public class BinaryNode {
    private int data;
    private BinaryNode leftNode;
    private BinaryNode rightNode;
    private boolean leftOrRight;
    
    //Constructor
    public BinaryNode(int data){
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }
       
    //Verificar si el nodo es una hoja
    public boolean isLeaf(){
        return(getLeftNode() == null && getRightNode() == null) ? true : false;
    }
    
    //Verificamos si tiene un hijo
    public boolean oneChild(){    
        if(getLeftNode()!=null && getRightNode()==null){
            leftOrRight = false;
            return true;
        }else if(getLeftNode()==null && getRightNode()!=null){
            leftOrRight = true;
            return true;
        }else{
            return false;
        }
    }
    
    
    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the leftOrRight
     */
    public boolean isLeftOrRight() {
        return leftOrRight;
    }

    /**
     * @param leftOrRight the leftOrRight to set
     */
    public void setLeftOrRight(boolean leftOrRight) {
        this.leftOrRight = leftOrRight;
    }

    /**
     * @return the leftNode
     */
    public BinaryNode getLeftNode() {
        return leftNode;
    }

    /**
     * @param leftNode the leftNode to set
     */
    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }

    /**
     * @return the rightNode
     */
    public BinaryNode getRightNode() {
        return rightNode;
    }

    /**
     * @param rightNode the rightNode to set
     */
    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }
}
