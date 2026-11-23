package rpg.items;

public class Weapon { //Estructura de un arma
    private String name;
    private double durability;
    private double maxDurability;
    private double damage;
    private final int reqStrength;
    private final TypeWeapon type; //Uso de Enum TypeWeapon

    public Weapon(String name, double damage, double maxDurability, int reqStrength, TypeWeapon type) { //Constructor
        if(!isValidName(name)) { throw new IllegalArgumentException("Nombre Invalido"); }
        validateDamage(damage);
        validateDurability(maxDurability);
        validateStrength(reqStrength);
        validateType(type);

        this.name = name;
        this.damage = damage;
        this.durability = maxDurability;
        this.maxDurability = maxDurability;
        this.type = type;
        this.reqStrength = reqStrength;
    }

   //Getters & Setters
    public String getName() {
        if(isBroken()) {
            return "Shard of "+ name;
        }
        return name;
    }

    public double getDamage() {
        if(isBroken()) {
            return damage * 0.1;
        }
        return damage;
    }

    public TypeWeapon getType() {
        return type;
    }

    public double getDurability() {
        return durability;
    }

    public double getMaxDurability() {
        return maxDurability;
    }

    public int getReqStrength() { return reqStrength; }

    public boolean setName(String name) {
        if (isBroken() || this.name.equals(name) || !isValidName(name)) {
            return false;
        }
        this.name = name;
        return true;
    }

    //ACTIONS

    private void validateDurability(double durability) {
        if(Double.isNaN(durability) || durability < 0 ) {
            throw new IllegalArgumentException("La resistencia asignada no puede ser declarado");
        }
    }

    private void validateDamage(double damage) {
        if(!Double.isFinite(damage) || damage < 0) {
            throw new IllegalArgumentException("El daño asignado no puede ser declarado");
        }
    }

    private void validateStrength(int strength) {
        if(strength < 0) {
            throw new IllegalArgumentException("La fuerza requerida no puede ser negativa");
        }
    }

    private void validateType(TypeWeapon type) {
        if(type == null) {
            throw new IllegalArgumentException("El tipo de arma no puede ser null.");
        }
    }

    private boolean isValidName(String name) {
        if(name == null || name.isBlank()) {
            return false;
        }
        return true;
    }

    public void reduceDurability(double wear) {
        if (!Double.isFinite(wear) || wear < 0) { return; }
        durability = durability - wear;
       durability = Math.max(0, durability);
    }

    public void repair(double amount) {
        if (Double.isNaN(amount)||amount < 0 || isBroken()) { return; }
        durability = durability + amount;
        durability = Math.min(maxDurability, durability);
    }

    public boolean isBroken() {
        return durability <= 0;
    }
}
