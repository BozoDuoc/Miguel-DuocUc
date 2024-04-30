package exp1_s8_miguel_bozo;

import java.util.Scanner;
import java.util.ArrayList;

public class Exp1_S8_Miguel_Bozo {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Integer> ventas = new ArrayList<>();
        ArrayList<Integer> asientos = new ArrayList<>();
        ArrayList<String> descuentos = new ArrayList<>();
        ArrayList<Integer> valorAsientos = new ArrayList<>();
        ArrayList<String> tipoAsientos = new ArrayList<>();
        
        System.out.println("Bienvenido al Teatro Moro");
        System.out.print("Por favor ingrese su nombre: ");
        String nombreCliente = scanner.nextLine();
        clientes.add(nombreCliente);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar asientos disponibles");
            System.out.println("2. Comprar entrada");
            System.out.println("3. Modificar entrada");
            System.out.println("4. Eliminar entrada");
            System.out.println("5. Conocer descuentos");
            System.out.println("6. Imprimir boleta");
            System.out.println("7. Salir");

            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    mostrarAsientos(asientos);
                    break;
                case 2:
                    comprarEntrada(clientes, ventas, asientos, descuentos, scanner, valorAsientos, tipoAsientos);
                    break;
                case 3:
                    modificarEntrada(ventas, asientos, clientes, scanner, valorAsientos, tipoAsientos);
                    break;
                case 4:
                    eliminarEntrada(ventas, asientos, clientes, scanner, valorAsientos, tipoAsientos);
                    break;
                case 5:
                    agregarDescuentos(descuentos, scanner);
                    break;
                case 6:
                    imprimirBoleta(ventas, asientos, clientes, valorAsientos, tipoAsientos);
                    break;
                case 7:
                    return; // Salir del método main
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static void mostrarAsientos(ArrayList<Integer> asientos) {
        System.out.println("\nMapa de asientos:");
        int asiento = 1;
        for (int fila = 1; fila <= 5; fila++) {
            for (int columna = 1; columna <= 10; columna++) {
                if (asientos.contains(asiento)) {
                    System.out.print(" X ");
                } else {
                    if(asiento < 10) System.out.print(" "+asiento + " ");
                    else System.out.print(asiento + " ");
                }
                asiento++;
            }
            System.out.println();
        }
    }

    public static void comprarEntrada(ArrayList<String> clientes, ArrayList<Integer> ventas,
            ArrayList<Integer> asientos, ArrayList<String> descuentos, Scanner scanner, ArrayList<Integer> valorAsientos, ArrayList<String> tipoAsientos) {
        System.out.println("Tipo de asiento:");
        System.out.println("1. Galería - $20.000");
        System.out.println("2. Palco - $15.000");
        System.out.println("3. VIP - $10.000");
        System.out.print("Ingrese el número correspondiente al tipo de asiento que desea comprar: ");
        int tipoAsiento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        
        String tipoAsientoStr = "";
        int valorAsiento = 0;
        switch (tipoAsiento) {
            case 1:
                tipoAsientoStr = "Galería";
                valorAsiento = 20000;
                break;
            case 2:
                tipoAsientoStr = "Palco";
                valorAsiento = 15000;
                break;
            case 3:
                tipoAsientoStr = "VIP";
                valorAsiento = 10000;
                break;
            default:
                System.out.println("Opción no válida");
                return;
        }

        System.out.println("¿Desea aplicar algún descuento?");
        System.out.println("1. Descuento Estudiante (10%)");
        System.out.println("2. Descuento Adulto Mayor (15%)");
        System.out.println("3. No aplicar descuento");
        System.out.print("Ingrese el número correspondiente a la opción: ");
        int opcionDescuento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        
        if (opcionDescuento == 1) {
            descuentos.add("Descuento Estudiante");
            valorAsiento -= (valorAsiento * 0.10); // Aplicar descuento del 10% para estudiantes
        } else if (opcionDescuento == 2) {
            descuentos.add("Descuento Adulto Mayor");
            valorAsiento -= (valorAsiento * 0.15); // Aplicar descuento del 15% para adultos mayores
        }

        System.out.print("Ingrese el número de asientos que desea comprar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el asiento para la entrada " + (i + 1) + ": ");
            int asiento = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            asientos.add(asiento);
            ventas.add(asiento);
            valorAsientos.add(valorAsiento);
            tipoAsientos.add(tipoAsientoStr);
            clientes.add("Cliente " + (clientes.size() + 1));
        }
        System.out.println("Entradas compradas con éxito");
    }

    public static void modificarEntrada(ArrayList<Integer> ventas, ArrayList<Integer> asientos,
            ArrayList<String> clientes, Scanner scanner, ArrayList<Integer> valorAsientos, ArrayList<String> tipoAsientos) {
        System.out.print("Ingrese el número de asiento que desea modificar: ");
        int asientoModificar = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        System.out.print("Ingrese el nuevo número de asiento: ");
        int nuevoAsiento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        if (asientos.contains(asientoModificar)) {
            int index = asientos.indexOf(asientoModificar);
            asientos.set(index, nuevoAsiento);
            ventas.set(index, nuevoAsiento);
            System.out.println("Entrada modificada con éxito");
        } else {
            System.out.println("El asiento que intenta modificar no existe");
        }
    }

    public static void eliminarEntrada(ArrayList<Integer> ventas, ArrayList<Integer> asientos,
            ArrayList<String> clientes, Scanner scanner, ArrayList<Integer> valorAsientos, ArrayList<String> tipoAsientos) {
        System.out.print("Ingrese el número de asiento que desea eliminar: ");
        int asientoEliminar = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        if (asientos.contains(asientoEliminar)) {
            int index = asientos.indexOf(asientoEliminar);
            asientos.remove(index);
            ventas.remove(index);
            clientes.remove(index);
            valorAsientos.remove(index);
            tipoAsientos.remove(index);
            System.out.println("Entrada eliminada con éxito");
        } else {
            System.out.println("El asiento que intenta eliminar no existe");
        }
    }

    public static void agregarDescuentos(ArrayList<String> descuentos, Scanner scanner) {
        System.out.println("Conoce los siguientes descuentos:");
        System.out.println("1. Descuento Estudiante (10%)");
        System.out.println("2. Descuento Adulto Mayor (15%)");
        System.out.println("3. No aplicar descuento");
        System.out.print("Ingrese el número correspondiente a la opción: ");
        int opcionDescuento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        
        if (opcionDescuento == 1) {
            descuentos.add("Descuento Estudiante");
            System.out.println("Descuento de estudiante aplicado");
        } else if (opcionDescuento == 2) {
            descuentos.add("Descuento Adulto Mayor");
            System.out.println("Descuento de adulto mayor aplicado");
        } else if (opcionDescuento == 3) {
            System.out.println("No se aplicará ningún descuento");
        } else {
            System.out.println("Opción no válida");
        }
    }

    public static void imprimirBoleta(ArrayList<Integer> ventas, ArrayList<Integer> asientos,
            ArrayList<String> clientes, ArrayList<Integer> valorAsientos, ArrayList<String> tipoAsientos){
        System.out.println("\nBoleta:");
        System.out.println("Nombre del cliente: " + clientes.get(0));
        for (int i = 0; i < ventas.size(); i++) {
            int asiento = ventas.get(i);
            String tipoAsiento = tipoAsientos.get(i);
            System.out.println("Tipo de asiento: " + tipoAsiento);
            System.out.println("Asiento seleccionado: " + asiento);
        }
        int total = 0;
        for (Integer valorAsiento : valorAsientos) {
            total += valorAsiento;
        }
        System.out.println("Total de la venta: $" + total);
    }
}
