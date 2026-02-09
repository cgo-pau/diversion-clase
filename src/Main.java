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

// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", "Electrico", 10, 100);
        Pokemon charmander = new Pokemon("Charmander", "Fuego", 10, 100);

        pikachu.atacar("Impactrueno", charmander);
        charmander.recibirDanio(20);
    }
}
