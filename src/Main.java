public class Main {
    public static void main(String[] args) {
        import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

        public class MergeGame {

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
    }
}