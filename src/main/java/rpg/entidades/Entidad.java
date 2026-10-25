package rpg.entidades;


public abstract class Entidad {
    private String nombre;
    private double vida;
    private double vidaMax;

    public Entidad(String nombre, double vidaMax) { //Constructor
        this.nombre = nombre;
        this.vidaMax = vidaMax;
        this.vida = vidaMax;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public double getVida() {
        return vida;
    }

    public double getVidaMax() {
        return vidaMax;
    }

    public void doDamage(double damage) {
        if (damage < 0) {
            return;
        }
        vida = vida - damage;
        vida = Math.max(0, vida);
    }

    public void doHeal(double heal) {
        if (heal < 0) {
            return;
        }
        vida = vida + heal;
        vida = Math.min(vidaMax, vida);
    }

    public boolean isAlive() {
        return vida > 0;
    }
}
