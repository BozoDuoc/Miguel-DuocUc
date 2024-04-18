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
        Scanner scanner = new Scanner(System.in);
        String nombreCliente = " ";
        int cantidadEntradas = 0;
        int numeroAsiento;
        double dctoEstudiante = 0.10;
        String tipoEntrada = "";
        boolean[] asientos = new boolean[50];

        int valorEntrada = 15000;

        System.out.println("Bienvenido! Por favor ingresa tu nombre");
        nombreCliente = scanner.nextLine().toLowerCase();
        while (nombreCliente.isEmpty()) {
            System.out.println("Nombre no válido, por favor vuelve a intentarlo");
            nombreCliente = scanner.nextLine().toLowerCase();
        }
        do {
            System.out.println("Bienvenido! " + nombreCliente + ". Por favor escoge una opción");
            System.out.println("1. Comprar Entradas");
            System.out.println("2. Conocer Descuentos");
            System.out.println("3. Salir del menú");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("Has escogido comprar entradas. ¿Cuántas entradas vas a querer?");
                    cantidadEntradas = scanner.nextInt();
                    while (cantidadEntradas == 0) {
                        System.out.println("Cantidad de entradas no válida");
                        cantidadEntradas = scanner.nextInt();
                    }
                     for (int x = 0; x < cantidadEntradas; x++) {
                        System.out.println("Por favor elige un asiento entre el 1 y el 50 para la entrada " + (x + 1));
                        int numeroAsiento = scanner.nextInt();
                        while (numeroAsiento < 1 || numeroAsiento > 50 || asientos[numeroAsiento - 1] != 0) {
                            System.out.println("Asiento no válido o ya ocupado. Por favor elige otro.");
                            numeroAsiento = scanner.nextInt();
                        }
                        asientos[x] = numeroAsiento
                    }
                    System.out.println("Has escogido " + cantidadEntradas + " entradas. Por favor elige un asiento entre el 1 y el 50.");
                    numeroAsiento = scanner.nextInt();
                    while (numeroAsiento < 1 || numeroAsiento > 50) {
                        System.out.println("Número de asiento no válido. Por favor elige un número entre 1 y 50.");
                        numeroAsiento = scanner.nextInt();
                    }

                    System.out.println("Has escogido el asiento número " + numeroAsiento + ".");
                    System.out.println("Gracias! Eres estudiante?  si/no");
                    tipoEntrada = scanner.nextLine().toLowerCase();
                    if (tipoEntrada.equals("Si"));
                    double totalEntrada = valorEntrada * dctoEstudiante;
                    double precioFinal = valorEntrada -= totalEntrada;
                    System.out.println("Tu entrada pasó de " + valorEntrada + "a " + precioFinal);
                    break;

                case "2":
                    System.out.println("En este momento, contamos con un 10% de descuento para estudiantes.");
                    break;

                case "3":
                    System.out.println("Saliendo del menú");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
            if (!opcion.equals("3")) {
                System.out.println("Desea hacer algo más? si/no");
                String respuesta = scanner.nextLine().toLowerCase();
                if (respuesta.equals("no")) {
                    System.out.println("Perfecto " + nombreCliente ! "Su resumen es:" );
                    System.out.println("Cantidad entradas:" + cantidadEntradas);
                    System.out.println("Asiento:" + numeroAsiento);
                    System.out.println("tu total a pagar es:" + precioFinal);
                    
                }
            }
    }
}
