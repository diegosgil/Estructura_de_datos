/*1. Para un arreglo de N posiciones de datos 
enteros, devolver el valor menor en el arreglo.*/
package tallerRecursividad.taller1;
/*
 * @author diegosgil
 */
public class ejercicio1 {
    
    public int determinarMenor(int[] numeros, int indice, int min){
        //Caso base
        if (indice >= 0){
            if (numeros[indice] < min){
                min = numeros[indice];
                indice--;
                return determinarMenor(numeros, indice, min);
            }else{
                indice--;
                return determinarMenor(numeros, indice, min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ejercicio1 r = new ejercicio1();
        int[] listaNumeros = new int[]{1,5,-5,2,5,8,2,1,9};
        int t = listaNumeros.length - 1;
        System.out.println("El número menor del arreglo es: " + r.determinarMenor(listaNumeros,5,t));
    }
}


