/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Mike
 */
public class Ventana extends JFrame {
    
    public Ventana(){
        setTitle("Calculadora de números primos");
        setResizable(false);
        setSize(800, 800);
        setLocationRelativeTo(null);
        iniciarComponentes();
        setVisible(true);
    }
    
    public void iniciarComponentes(){
        Calculadora calculadora = new Calculadora();
        JLabel nombre = new JLabel("Calculadora de Números Primos");
        JLabel indicacion = new JLabel("Ingrese el número para calcular:");
        Font fuente1 = new Font("Arial", Font.BOLD, 16);
        nombre.setFont(fuente1);
        JTextField campo1 = new JTextField(20);
        JTextArea texto1 = new JTextArea();
        JButton calcular = new JButton("Calcular");
        JButton borrar = new JButton("Borrar");
        
        calcular.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String num = campo1.getText().trim();
                if(!num.matches("\\d+$")){
                    JOptionPane.showMessageDialog(Ventana.this, "Entrada inválida, deben ser digítos.");
                    return;
                }
                if(Integer.parseInt(num) > 9999){
                    JOptionPane.showMessageDialog(Ventana.this, "Número muy grande, no podrá ser procesado.");
                    return;
                }
                int respuesta = calculadora.numeroPrimo(Integer.parseInt(num));
                if(respuesta == 1){
                    String s1 = num + " es compuesto! \n";
                    String s2 = "Esto debido a que " + num + " es divisible por: ";
                    List<Integer> divisibles = calculadora.getDivisibles();
                    for(Integer i : divisibles){
                        if(divisibles.getLast().equals(i)){
                            s2 += "y " + i + "\n";
                        } else {
                          s2 += i + ", ";  
                        }
                    }
                    String s3 = "Su raíz entera es: " + calculadora.raizEntera(Integer.parseInt(num)) + "\n";
                    String s4 = "Con un residuo de: " + (Integer.parseInt(num) - (calculadora.raizEntera(Integer.parseInt(num))*calculadora.raizEntera(Integer.parseInt(num)))) + "\n";
                    texto1.append(s1);
                    texto1.append(s2);
                    texto1.append(s3);
                    texto1.append(s4);
                } else {
                    String s1 = num + " es primo! \n";
                    String s2 = "Esto debido a que " + num + " solo es divisible por 1 y sí mismo. \n";
                    // igual aqui hay un error xq solo agrega hasta el numero 3
                    String s3 = "Números primos anteriores a " + num + ": ";
                    List<Integer> npa = calculadora.numerosPrimosAnteriores(Integer.parseInt(num));
                    for(Integer i : npa){
                        if(npa.getLast().equals(i)){
                            s3 += "y " + i + "\n";
                        } else {
                          s3 += i + ", ";  
                        }
                    }
                    String s4 = "Su raíz entera es: " + calculadora.raizEntera(Integer.parseInt(num)) + "\n";
                    String s5 = "Con un residuo de: " + (Integer.parseInt(num) - (calculadora.raizEntera(Integer.parseInt(num))*calculadora.raizEntera(Integer.parseInt(num)))) + "\n";
                    texto1.append(s1);
                    texto1.append(s2);
                    texto1.append(s3);
                    texto1.append(s4);
                    texto1.append(s5);
                }
                calculadora.reiniciar();
            }
        });
        
        borrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                campo1.setText("");
                texto1.setText("");
                calculadora.reiniciar();
            }
        });
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.add(nombre);
        panel.add(indicacion);
        panel.add(campo1);
        panel.add(texto1);
        panel.add(calcular);
        panel.add(borrar);
        this.add(panel);
    }
}
