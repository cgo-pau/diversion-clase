import java.util.*;

public class MiniMinecraft {

    // === CONFIGURACIÓN ===
    static final int WIDTH = 60;
    static final int HEIGHT = 25;

    // === BLOQUES ===
    static final char AIR = ' ';
    static final char GRASS = 'G';
    static final char DIRT = 'D';
    static final char STONE = 'S';
    static final char WATER = 'W';
    static final char TREE = 'T';
    static final char PLAYER = '@';

    static char[][] world = new char[HEIGHT][WIDTH];

    // === JUGADOR ===
    static int playerX = WIDTH / 2;
    static int playerY = 0;

    static Map<Character, Integer> inventory = new HashMap<>();

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        generateWorld();
        placePlayer();
        gameLoop();
    }

    // ================== GAME LOOP ==================
    static void gameLoop() {

        while (true) {

            render();
            System.out.println("\nWASD = mover | M = minar | P = colocar | I = inventario | Q = salir");
            String input = sc.nextLine().toUpperCase();

            if (input.equals("c")) break;

            handleInput(input);
            applyGravity();
        }
    }

    // ================== INPUT ==================
    static void handleInput(String input) {

        switch (input) {

            case "W": move(0, -1); break;
            case "S": move(0, 1); break;
            case "A": move(-1, 0); break;
            case "D": move(1, 0); break;
            case "M": mine(); break;
            case "P": place(); break;
            case "I": showInventory(); break;
        }
    }

    // ================== MOVIMIENTO ==================
    static void move(int dx, int dy) {

        int nx = playerX + dx;
        int ny = playerY + dy;

        if (nx < 0 || nx >= WIDTH || ny < 0 || ny >= HEIGHT) return;

        if (world[ny][nx] == AIR || world[ny][nx] == WATER) {
            playerX = nx;
            playerY = ny;
        }
    }

    // ================== GRAVEDAD ==================
    static void applyGravity() {

        if (playerY + 1 < HEIGHT &&
                (world[playerY + 1][playerX] == AIR || world[playerY + 1][playerX] == WATER)) {

            playerY++;
        }
    }

    // ================== MINAR ==================
    static void mine() {

        int targetY = playerY + 1;

        if (targetY >= HEIGHT) return;

        char block = world[targetY][playerX];

        if (block != AIR && block != WATER) {

            inventory.put(block, inventory.getOrDefault(block, 0) + 1);
            world[targetY][playerX] = AIR;
        }
    }

    // ================== COLOCAR ==================
    static void place() {

        System.out.println("Bloque a colocar (G D S T): ");
        String b = sc.nextLine().toUpperCase();

        if (b.length() != 1) return;

        char block = b.charAt(0);

        if (!inventory.containsKey(block) || inventory.get(block) <= 0) return;

        int targetY = playerY + 1;

        if (targetY < HEIGHT && world[targetY][playerX] == AIR) {

            world[targetY][playerX] = block;
            inventory.put(block, inventory.get(block) - 1);
        }
    }

    // ================== INVENTARIO ==================
    static void showInventory() {

        System.out.println("\n=== INVENTARIO ===");
        for (char c : inventory.keySet()) {
            System.out.println(c + " : " + inventory.get(c));
        }
        System.out.println("Pulsa ENTER...");
        sc.nextLine();
    }

    // ================== GENERACIÓN MUNDO ==================
    static void generateWorld() {

        int ground = HEIGHT / 2;

        for (int y = 0; y < HEIGHT; y++) {

            for (int x = 0; x < WIDTH; x++) {

                if (y < ground) world[y][x] = AIR;
                else if (y == ground) world[y][x] = GRASS;
                else if (y < ground + 4) world[y][x] = DIRT;
                else world[y][x] = STONE;
            }
        }

        generateTrees();
        generateWater();
    }

    static void generateTrees() {

        for (int x = 2; x < WIDTH - 2; x++) {

            if (random.nextInt(12) == 0) {

                int g = findGround(x);

                world[g - 1][x] = TREE;
                world[g - 2][x] = TREE;
                world[g - 3][x] = TREE;
            }
        }
    }

    static void generateWater() {

        int start = random.nextInt(WIDTH - 8);
        int width = 5 + random.nextInt(3);

        for (int x = start; x < start + width; x++) {

            int g = findGround(x);
            world[g][x] = WATER;
            world[g + 1][x] = WATER;
        }
    }

    static int findGround(int x) {

        for (int y = 0; y < HEIGHT; y++) {
            if (world[y][x] == GRASS) return y;
        }
        return HEIGHT / 2;
    }

    // ================== JUGADOR ==================
    static void placePlayer() {

        playerY = findGround(playerX) - 1;
    }

    // ================== RENDER ==================
    static void render() {

        clearConsole();

        for (int y = 0; y < HEIGHT; y++) {

            for (int x = 0; x < WIDTH; x++) {

                if (x == playerX && y == playerY)
                    System.out.print(PLAYER);
                else
                    System.out.print(world[y][x]);
            }
            System.out.println();
        }
    }

    static void clearConsole() {

        for (int i = 0; i < 40; i++) System.out.println();
    }
}
