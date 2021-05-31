/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.listas;

/**
 *
 * @author Usuario
 */
public class ArrayStack {
    
    private Object[] data;
    private int top;    //Cantidad de celdas ocupadas de la pila
    private int max;    //Tamaño maximo de la pila

    public ArrayStack(int n){
        data = new Object[n];
        top=0;
        max=n;
    }
    
    public boolean empty(){     //Comprueba si la lista esta vacia
        return top==0;
    }
    
    public Object peek(){       //Consulta el elemento de la cima de la pila
        return data[top-1];
    }
    
    public Object push(Object item){        //Retorna el objeto que se ha agregado a la pila
        if(top==max){
            return null;
        }else{
            data[top++] = item;
            return item;
        }
    }
    
    public Object pop(){        //Saca un elemento de la pila
        if(empty()){
            return null;
        }else{
            Object temp = data[top-1];
            data[top-1] = null;
            return temp;
        }    
    }
    
    @Override
    public String toString(){
        String data = "[";
        for (int i = 0; i < max-1; i++) {
            data+=this.data[i]+", ";
        }
        data+=this.data[max-1]+"]";
        return data;
    }  
}