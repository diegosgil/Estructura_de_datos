/*2. Para un arreglo de N posiciones de datos 
reales, determinar si un dato determinado existe*/
package tallerRecursividad.taller1;
/*
 * @author diegosgil
 */
public class ejercicio2 {
    
    public boolean determinarSiExiste(int[] numeros, int nExiste, int i){
        //Caso base
        if(i < 0){
            return false;
        }else{
            if(numeros[i] == nExiste){
                return true;
            }else{
                i--;
                return determinarSiExiste(numeros, nExiste, i);
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ejercicio2 r = new ejercicio2();
        int[] listaNumeros = new int[]{1,5,2,5,8,2,1,9,4,-3,-2,-1, 0, 1, 2, 3, 4};
        int t = listaNumeros.length - 1;
        System.out.println("El número está en el arreglo: " + r.determinarSiExiste(listaNumeros,2,t));
    }
}
