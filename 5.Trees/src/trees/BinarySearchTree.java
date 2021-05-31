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
public class BinarySearchTree {

    private BinaryNode root;    //root:raiz
    private BinaryNode father;
    private boolean fatherLeftOrRight;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int data) {
        root = new BinaryNode(data);
    }

    public BinaryNode search(int data) {
        return search(data, root);
    }

    private BinaryNode search(int data, BinaryNode currentRoot) {
        //casos base
        if (currentRoot.getData() == data) {
            return currentRoot;
        }
        if (currentRoot == null) {
            return null;
        }

        father = currentRoot;

        if (data > currentRoot.getData()) {
            fatherLeftOrRight = true;
            return search(data, currentRoot.getRightNode());
        } else {
            fatherLeftOrRight = false;
            return search(data, currentRoot.getLeftNode());
        }       
    }

    public void add(int data) {
        if(root==null){
            root = new BinaryNode(data);
        }else{
            add(data, root);
        }     
    }

    private void add(int data, BinaryNode currentRoot) {
        //CASE BASE 1
        if (data < currentRoot.getData()) {
            if (currentRoot.getLeftNode() == null) {
                currentRoot.setLeftNode(new BinaryNode(data));
            } else {
                add(data, currentRoot.getLeftNode());
            }
        //CASE BASE 2
        } else if (currentRoot.getRightNode() == null) {
            currentRoot.setRightNode(new BinaryNode(data));
        } else {
            add(data, currentRoot.getRightNode());
        }
    }   

    public void delete(int data) {
        if (root == null) {
            System.out.println("Arbol vacio");
        } else {
            delete(data, root);
        }
    }

    private void delete(int data, BinaryNode currentRoot) {
        //CASOS BASE

        BinaryNode tempNode = search(data);
        if (tempNode == null) {
            System.out.println("No existe el nodo");
        } else {
            /*Si el nodo que se va a eliminar es una hoja, 
            su nodo padre apuntará ahora hacia vacío*/
            if (tempNode.isLeaf()) {//caso base 1
                //identificar la dirección de desplazamiento
                if (fatherLeftOrRight) {
                    father.setRightNode(null);
                } else {
                    father.setLeftNode(null);
                }
            //CASO BASE 2
            } else if (tempNode.oneChild()) {
                //Caso especial de un solo hijo (raiz)
                if(tempNode == root){
                    root = (tempNode.isLeftOrRight()) ? tempNode.getRightNode() : tempNode.getLeftNode(); 
                    return;
                }
                /*Si el nodo por borrar tiene solo un hijo, 
                su respectivo padre apuntará directamente a dicho nodo hijo.*/
                if (tempNode.isLeftOrRight()) {     //donde este el hijo? Derecha
                    //Identificar la dirección de desplazamiento
                    if (fatherLeftOrRight) {
                        father.setRightNode(tempNode.getRightNode());
                    } else {
                        father.setLeftNode(tempNode.getRightNode());
                    }
                    //Donde este el hijo? Izquierda
                } else if (fatherLeftOrRight) {
                    father.setRightNode(tempNode.getLeftNode());
                } else {
                    father.setLeftNode(tempNode.getLeftNode());
                }
            //CASO RECURSIVO - Se tiene un nodo con dos hijos
            }else{  
                /*Buscar predecesor y reemplazarlo con dicho nodo.
                Ubicarse en subarbol izquierdo y localizar el dato mayor*/
                BinaryNode major = getMajor(tempNode.getLeftNode());
                delete(major.getData());
                tempNode.setData(major.getData());
            }
        }
    }
    
    private BinaryNode getMajor(BinaryNode currentRoot){
        //CASO BASE
        if(currentRoot.getRightNode() == null){
            return currentRoot;
        }else{
            return getMajor(currentRoot.getRightNode());
        }
    }
    
    public void preOrder(){
        preOrder(root);
    }
     
    private void preOrder (BinaryNode currentRoot){
        if(currentRoot != null){
            System.out.println(currentRoot.getData() + " ");
            preOrder(currentRoot.getLeftNode());
            preOrder(currentRoot.getRightNode());
        }  
    }
      
    public void postOrder(){
        postOrder(root);
    }
     
    private void postOrder (BinaryNode currentRoot){
        if(currentRoot != null){
            postOrder(currentRoot.getLeftNode());
            postOrder(currentRoot.getRightNode());
            System.out.println(currentRoot.getData() + " ");
        }  
    } 
    
    public void inOrder(){
        inOrder(root);
    }
     
    private void inOrder (BinaryNode currentRoot){
        if(currentRoot != null){
            inOrder(currentRoot.getLeftNode());
            System.out.println(currentRoot.getData() + " ");
            inOrder(currentRoot.getRightNode());
        }  
    }    
}
    
    
