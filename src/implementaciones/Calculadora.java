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
    
    public int numeroPrimo(int i) {
        // 1 significa que NO es primo, 0 que SI es primo
        divisibles.clear();
        int respuesta = 0;
        // contador q ira dividiendo
        int contador = 2;
        // mientras el contador sea menor a i (el numero del cual se calcula si es primo o no)
        while (contador < i) {
            // falta q valide q el contador tmb sea primo 
            if(i % contador == 0){
                divisibles.add(contador);
            }
            // aumenta el contador
            contador++;
        }
        // si para el final del ciclo la lista no esta vacia, es pq es un numero compuesto
        if (!divisibles.isEmpty()) {
            // cambia respuesta a 1 (es compuesto) y la regresa
            respuesta = 1;
            return respuesta;
        }
        // si no, no modifica nada y regresa 0 (es primo)
        return respuesta;
    }
    
    public int raizEntera(double numero){
        int raiz;
        raiz = (int) Math.sqrt(numero);
        return raiz;
    }
    
    public List<Integer> factoresPrimos(int i){
        List<Integer> temp = new LinkedList<>();
        List<Integer> factores = new LinkedList<>();
        int raiz = raizEntera(i);
        for(Integer elem : divisibles){
            temp.add(elem);
        }
        System.out.println(temp.toString());
        for(Integer num : temp){
            if(num <= raiz){
                if(numeroPrimo(num) == 0){
                    factores.add(num);
                }
            }
        }
        System.out.println(factores.toString());
        return factores;
    }
    
    public List<Integer> getDivisibles(){
        return divisibles;
    }
    
    // aqui hay un fallo xq como q solo agrega hasta el numero 3
    public List<Integer> numerosPrimosAnteriores(int i){
        List<Integer> lista = new LinkedList<>();
        int contador = 1;
        while(contador < i){
            if(numeroPrimo(contador) == 0){
                lista.add(contador);
            }
            contador++;
        }
        return lista;
    }
}
