/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp2_s6_miguel_bozo;

/**
 *
 * @author miguel
 */
import java.util.Scanner;
public class EXP2_S6_Miguel_Bozo {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner scanner = new Scanner (System.in);
    String nombreCliente = " ";
    int cantidadEntradas = 0;
    int entradasDisponibles = 50;
    double dctoEstudiante = 0.10;
    
    int valorEntrada = 15000;
    
      System.out.println("Bienvenido! Por favor ingresa tu nombre");
        nombreCliente = scanner.nextLine().toLowerCase();
        while (nombreCliente.isEmpty()); {
        System.out.println("Nombre no válido, por favor vuelve a intentarlo");
    }
    }
}
