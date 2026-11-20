package rpg.entities;


public abstract class Entity { //Abstract como referencia general del comportamiento de una entidad
    private String name;
    private double health;
    private double maxHealth;
    private double resistance;
    private static final double EPSILON = 1e-9;

    public Entity(String name, double maxHealth, double resistance) { //Constructor
        validResistance(resistance);
        validMaxHealth(maxHealth);
        validName(name);
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



    //Filtraje para constructor

    private void validResistance(double resistance) {
        if (resistance < 0 || !Double.isFinite(resistance)) {
            throw new IllegalArgumentException("Este dato no es posible de aplicar");
        }
    }

    private void validMaxHealth(double maxHealth) {
        if (maxHealth <= 0 || !Double.isFinite(maxHealth)) {
            throw new IllegalArgumentException("Este dato no es posible de aplicar");
        }
    }

    private void validName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Este dato no es posible de aplicar");
        }
    }

    // Metodos utiles, filtros
    public double doDamage(double rawDamage) {
        if (rawDamage < 0 || !Double.isFinite(rawDamage)) { //Filtro numeros negativos
            throw new IllegalArgumentException("Los datos ingresados no son validos para la ejecucion.");
        }
        double damageMultiplicator = 100.0 / (100.0 + this.resistance); //Sistema de reduccion de daño estilo LoL
        double finalDamage = rawDamage * damageMultiplicator;
        double tempHealth = health;
        health = health - finalDamage;
        health = Math.max(0, health);
        if (health > 0 && health < EPSILON) { health = 0; }
        return tempHealth - health;
    }

    //Para q te cures wey
    public void doHeal(double heal) {
        if (heal < 0 || !Double.isFinite(heal)) {
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
