public class Juego {
    import java.util.*;

    class Pokemon {
        String nombre;
        int hp;
        int maxHp;
        int ataque;
        
        
        public Pokemon(String nombre, int hp, int ataque) {
            this.nombre = nombre;
            this.hp = hp;
            this.maxHp = hp;
            this.ataque = ataque;
        }

        public boolean estaVivo() {
            return hp > 0;
        }

        public void recibirDanio(int danio) {
            this.hp -= danio;
            if (this.hp < 0) this.hp = 0;
        }
    }

    public class PokemonBattle {
        private static final Scanner scanner = new Scanner(System.in);
        private static final Random random = new Random();

        // Pool de Pokémon disponibles
        private static final List<Pokemon> POKEDEX = Arrays.asList(
                new Pokemon("Charizard", 180, 45),
                new Pokemon("Blastoise", 200, 35),
                new Pokemon("Venusaur", 220, 30),
                new Pokemon("Pikachu", 120, 60),
                new Pokemon("Lucario", 150, 50),
                new Pokemon("Gengar", 130, 55),
                new Pokemon("Snorlax", 300, 25),
                new Pokemon("Mewtwo", 190, 70)
                
        );

        public static void main(String[] args) {
            System.out.println("--- BIENVENIDO AL TORNEO POKÉMON ---");

            List<Pokemon> equipoJugador = generarEquipoAleatorio();
            List<Pokemon> equipoCPU = generarEquipoAleatorio();

            int pokemonActualJugador = 0;
            int pokemonActualCPU = 0;

            while (pokemonActualJugador < 6 && pokemonActualCPU < 6) {
                Pokemon p1 = equipoJugador.get(pokemonActualJugador);
                Pokemon p2 = equipoCPU.get(pokemonActualCPU);

                System.out.println("\n------------------------------------");
                System.out.println("TU POKÉMON: " + p1.nombre + " (" + p1.hp + "/" + p1.maxHp + " HP)");
                System.out.println("POKÉMON CPU: " + p2.nombre + " (" + p2.hp + "/" + p2.maxHp + " HP)");
                System.out.println("------------------------------------");

                // Turno del Jugador
                System.out.print("¿Qué debe hacer " + p1.nombre + "? (1: Atacar, 2: Curar): ");
                int accion = scanner.nextInt();

                if (accion == 1) {
                    int danio = random.nextInt(p1.ataque) + 10;
                    p2.recibirDanio(danio);
                    System.out.println("¡" + p1.nombre + " atacó y causó " + danio + " de daño!");
                } else {
                    p1.hp = Math.min(p1.maxHp, p1.hp + 40);
                    System.out.println("¡" + p1.nombre + " se curó!");
                }

                if (!p2.estaVivo()) {
                    System.out.println("¡El " + p2.nombre + " enemigo se ha debilitado!");
                    pokemonActualCPU++;
                    continue;
                }

                // Turno de la CPU
                System.out.println("\nTurno del enemigo...");
                int danioCPU = random.nextInt(p2.ataque) + 10;
                p1.recibirDanio(danioCPU);
                System.out.println("¡" + p2.nombre + " enemigo usó un ataque y causó " + danioCPU + " de daño!");

                if (!p1.estaVivo()) {
                    System.out.println("¡Tu " + p1.nombre + " se ha debilitado!");
                    pokemonActualJugador++;
                }
            }

            if (pokemonActualJugador < 6) {
                System.out.println("\n¡FELICIDADES! Has derrotado a la CPU.");
            } else {
                System.out.println("\nHas sido derrotado... El equipo de la CPU fue superior.");
            }
        }

        private static List<Pokemon> generarEquipoAleatorio() {
            List<Pokemon> equipo = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                Pokemon base = POKEDEX.get(random.nextInt(POKEDEX.size()));
                // Clonamos el pokemon para que cada uno tenga su propia vida
                equipo.add(new Pokemon(base.nombre, base.hp, base.ataque));
            }
            return equipo;
        }
    }
}