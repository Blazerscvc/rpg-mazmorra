package rpg.items;

public class Weapon { //Estructura de un arma
    private String name;
    private double durability;
    private double damage;
    private TypeWeapon type; //Uso de Enum TypeWeapon

    public Weapon(String name, double damage, double durability, TypeWeapon type) { //Constructor
        this.name = name;
        this.damage = damage;
        this.durability = durability;
        this.type = type;
    }

   //Getters & Setters
    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }

    public double getDurability() {
        return durability;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public boolean isBroken() {
        return durability <= 0;
    }
}
