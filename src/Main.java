
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Definición de la clase Pokemon
class Pokemon {
    private String nombre;
    private String tipo;
    private int nivel;
    private int hp; // Puntos de vida

    // Constructor
    public Pokemon(String nombre, String tipo, int nivel, int hp) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.hp = hp;
    }

    // Método para atacar
    public void atacar(String movimiento, Pokemon objetivo) {
        System.out.println(this.nombre + " usa " + movimiento + " contra " + objetivo.getNombre() + "!");
        // Aquí se podría calcular daño basado en tipo, nivel, etc.
    }

    // Método para recibir daño
    public void recibirDanio(int danio) {
        this.hp -= danio;
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println(this.nombre + " se ha debilitado.");
        } else {
            System.out.println(this.nombre + " ahora tiene " + this.hp + " HP.");
        }
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getHp() { return hp; }
}


class MergeGame {

    static ArrayList<Integer> board = new ArrayList<>();
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initGame1();
        gameLoop();
    }

    static void initGame1() {
        board.add(2);
        board.add(2);
        board.add(4);
        board.add(4);
        addRandomNumber();
        addRandomNumber();
    }

    static void gameLoop() {
        while (true) {
            printBoard();

            if (checkWin()) {
                System.out.println("¡Ganaste! Llegaste a 32.");
                break;
            }

            if (!canMerge()) {
                System.out.println(" No hay más movimientos. Game Over.");
                break;
            }

            System.out.print("Elige dos posiciones para hacer merge (ej: 0 1): ");
            int pos1 = scanner.nextInt();
            int pos2 = scanner.nextInt();

            if (validMerge(pos1, pos2)) {
                int newValue = board.get(pos1) * 2;
                board.remove(Math.max(pos1, pos2));
                board.remove(Math.min(pos1, pos2));
                board.add(newValue);
                addRandomNumber();
            } else {
                System.out.println("Movimiento inválido.");
            }
        }
    }

    static void printBoard() {
        System.out.println("\nEstado actual:");
        for (int i = 0; i < board.size(); i++) {
            System.out.println(i + ": " + board.get(i));
        }
    }

    static boolean validMerge(int p1, int p2) {
        if (p1 < 0 || p2 < 0 || p1 >= board.size() || p2 >= board.size())
            return false;
        if (p1 == p2)
            return false;
        return board.get(p1).equals(board.get(p2));
    }

    static void addRandomNumber() {
        board.add(random.nextBoolean() ? 2 : 4);
    }

    static boolean canMerge() {
        for (int i = 0; i < board.size(); i++) {
            for (int j = i + 1; j < board.size(); j++) {
                if (board.get(i).equals(board.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkWin() {
        return board.contains(32);
    }
}

public class Main {
    public static void main(String[] args) {


        String arte = """
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⡿⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣀⠀⠀⠀⣼⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣷⣆⣴⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⡿⠋⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⡟⠁⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⠟⠁⠀⠀⠀⢀⣠⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⡇⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠒⠯⠟⡿⠛⠧⠀⠀⠀⢠⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣿⣿⣿⣿⣿⡿⠟⠋⠁⠸⣿⣿⣿⡁⠀⠀⠉⠛⠿⢿⣿⣿⣿⣿⣿⣿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⣿⣿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠘⣿⣣⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢿⣿⣿⣿⣿⣷⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣧⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⣿⣀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⣠⣴⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⢿⣿⣿⣿⣦⣤⣔⠁⠀⣀⣤⡄
⠀⠀⢀⣀⣰⣾⣿⣿⠟⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⡿⠋⠀
⢸⣿⣿⣿⣿⣿⠟⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⡿⠛⠉⠀⠀⠀
⠀⠙⠛⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀ """;

        System.out.println(arte);
        System.out.println(1);
   System.out.println(":D :D :D");
        System.out.println("Olaf k ashe");
        System.out.println("AllahuakBuyThisProduct");


        System.out.println("Adam, compra tabaco");
        System.out.println("En Joel es un genio");

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
}