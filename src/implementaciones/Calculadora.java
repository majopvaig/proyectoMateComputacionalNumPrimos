/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mike
 */
public class Calculadora {
    private List<Integer> divisibles;
    
    
    public Calculadora(){
        divisibles = new LinkedList<>();
    }
    
    public void reiniciar(){
        divisibles.clear();
    }
    
    public int numeroPrimo(int i){
        // 1 significa que NO es primo, 0 que SI es primo
        int respuesta = 0;
        // contador q ira dividiendo
        int contador = 1;
        // mientras el contador sea menor a i (el numero del cual se calcula si es primo o no)
        while(contador <= i){
            // si la division da como residuo 0
            if(i%contador == 0){
                // y si el contador es diferente de 1 o el propio numero (i)
                if(contador != i || contador != 1){
                    // q lo agregue a la lista
                    divisibles.add(contador);
                }
            }
            // aumenta el contador
            i++;
        }
        // si para el final del ciclo la lista no esta vacia, es pq es un numero compuesto
        if(!divisibles.isEmpty()){
            // cambia respuesta a 1 (es compuesto) y la regresa
            respuesta = 1;
            return respuesta;
        }
        // si no, no modifica nada y regresa 0 (es primo)
        return respuesta;
    }
}
