/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerRecursividad.taller1;
/**
 *
 * @author Usuario
 */
public class solucionarioRecursividad {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] data = {2, -4, 6, 8, 1, 99};
        double[] dataDouble = {2, -4, 6, 8, 1, 99};
        System.out.println("Encontrar el menor de un arreglo: " + minArray(data, 0, Integer.MAX_VALUE));
        System.out.println("Verificar si se encuentra el dato: " + exists(dataDouble, 0, 22));
        System.out.println("Potenciacion: " + pow(35, 55));
        System.out.println("Verificar palindromo: " + palindrome("rotor"));
        System.out.println("Navshesh: " + navshesh(133));
    }

    /**
     * Para un arreglo de N posiciones de datos enteros, devolver el valor menor
     * en el arreglo.
     *
     * @param d Arreglo de datos entero
     * @param i contador de posicion
     * @param m el valor minimo encontrado
     * @return el valor menor
     */
    public static int minArray(int[] d, int i, int m) {
        //Caso de repeticion
        if (i < d.length) {
            if (d[i] <= m) {
                m = d[i];
            }
            m = minArray(d, i + 1, m);
        }
        return m;
    }

    /**
     * Para un arreglo de N posiciones de datos reales, determinar si un dato
     * determinado existe.
     *
     * @param d arreglo de datos
     * @param i contador de posicion
     * @param data valor a buscar
     * @return Verdadero si lo encuentra, Falso si no lo encuentra
     */
    public static boolean exists(double[] d, int i, double data) {
        //casos base
        if (d[i] == data && i < d.length) {
            return true;
        } else if (d[i] != data && i == (d.length - 1)) {
            return false;
        } else {
            return exists(d, i + 1, data);
        }
    }

    /**
     * Para un valor N real y un M entero positivo mayor que cero, calcular N^M.
     *
     * @param b Numero base
     * @param e numero exponetne
     * @return el resultado de la potencia
     */

    public static double pow(int b, int e) {
        if (e == 0) {
            return 1;
        } else {
            return b * pow(b, e - 1);
        }
    }

    /**
     * Determinar si una palabra es palíndroma.
     *
     * @param t La palabra
     * @return Verdadero si es palindroma, falso si no lo es.
     */
    public static boolean palindrome(String t) {
        if (t.length() == 0 || t.length() == 1) {
            return true;
        } else if (t.charAt(0) != t.charAt(t.length() - 1)) {
            return false;
        } else {
            t = t.substring(1, t.length() - 1);
            return palindrome(t);
        }
    }

    public static int navshesh(int n) {
        if (n < 10) {
            return n;
        } else {
            n = n / 10 + n % 10;
            return navshesh(n);
        }
    }
}
