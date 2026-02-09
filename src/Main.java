
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Adam, compra tabaco");
        int suma = suma(2, 5);

        char[][] cara = new char[9][9];

        for (int i = 0; i < cara.length; i++) {
            for (int j = 0; j < cara[i].length; j++) {

                if (i == 0 || i == cara.length - 1 ||
                        j == 0 || j == cara[i].length - 1) {

                    cara[i][j] = '0';

                } else if ((i == 2 && j == 2) || (i == 2 && j == 6)) {

                    cara[i][j] = '0';

                } else if (i == 6 && (j >= 2 && j <= 6)) {

                    cara[i][j] = '0';

                } else {
                    cara[i][j] = ' ';
                }
            }
        }

        for (int i = 0; i < cara.length; i++) {
            for (int j = 0; j < cara[i].length; j++) {
                System.out.print(cara[i][j] + " ");
            }
            System.out.println();
        }

        Scanner sc = new Scanner(System.in);

        int pisos = 5;
        int habitaciones = 4;

        // Crear matriz para registrar reservas
        int[][] hotel = inicializarHotel(pisos, habitaciones);

        // Pedir datos al usuario
        int piso = pedirPiso(pisos);
        int habitacion = pedirHabitacion(habitaciones);
        int personas = pedirCantidadPersonas();

        // Registrar la reserva
        reservarHabitacion(hotel, piso, habitacion, personas);

        // Mostrar resumen
        mostrarResumen(piso, habitacion, personas);


        // make game
        Game game = new Game();

        // play game
        game.play();
    }

    public static int[][] inicializarHotel(int pisos, int habitaciones) {
        return new int[pisos][habitaciones]; // todas vacías
    }

    public static int pedirPiso(int pisos) {
        Scanner sc = new Scanner(System.in);
        int piso;
        do {
            System.out.print("Ingrese el piso que desea reservar (0-" + (pisos - 1) + "): ");
            piso = sc.nextInt();
        } while (piso < 0 || piso >= pisos);
        return piso;
    }

    public static int pedirHabitacion(int habitaciones) {
        Scanner sc = new Scanner(System.in);
        int habitacion;
        do {
            System.out.print("Ingrese la habitación que desea reservar (0-" + (habitaciones - 1) + "): ");
            habitacion = sc.nextInt();
        } while (habitacion < 0 || habitacion >= habitaciones);
        return habitacion;
    }

    public static int pedirCantidadPersonas() {
        Scanner sc = new Scanner(System.in);
        int personas;
        do {
            System.out.print("Ingrese la cantidad de personas que se alojarán: ");
            personas = sc.nextInt();
        } while (personas <= 0);
        return personas;
    }

    public static void reservarHabitacion(int[][] hotel, int piso, int habitacion, int personas) {
        hotel[piso][habitacion] = personas;
    }

    public static void mostrarResumen(int piso, int habitacion, int personas) {
        System.out.println("\n--- RESUMEN DE RESERVA ---");
        System.out.println("Piso reservado: " + piso);
        System.out.println("Habitación: " + habitacion);
        System.out.println("Cantidad de personas: " + personas);
    }


    static int suma(int a, int b) {
        return a + b;
    }
}

