package rpg.entities;


public abstract class Entity { //Abstract como referencia general del comportamiento de una entidad
    private String name;
    private double health;
    private double maxHealth;
    private double resistance;

    public Entity(String name, double maxHealth, double resistance) { //Constructor
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.resistance = resistance;
    }

    //Getters
    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getResistance() {
        return  resistance;
    }

    // Metodos utiles, filtros basicos aplicados (invalidacion de numeros negativos)
    public void doDamage(double rawDamage) {
        if (rawDamage < 0 || resistance < 0) { //Filtro numeros negativos
            return;
        }
        double damageMultiplicator = 100.0 / (100.0 + this.resistance); //Sistema de reduccion de daño estilo LoL
        double finalDamage = rawDamage * damageMultiplicator;
        health = health - finalDamage;
        health = Math.max(0, health);
    }

    public void doHeal(double heal) {
        if (heal < 0) {
            return;
        }
        health = health + heal;
        health = Math.min(maxHealth, health);
    }


    //Realmente la entidad esta viva?
    public boolean isAlive() {
        return health > 0;
    }
}
