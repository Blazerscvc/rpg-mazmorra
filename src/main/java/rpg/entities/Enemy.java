package rpg.entities;

public class Enemy extends Entity {
    private double attackDamage;

    public Enemy(String name, double maxHealth, double attackDamage, double resistance) {
        super(name, maxHealth, resistance);
        this.attackDamage = attackDamage;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public double attack(Entity target){
         double damage = target.doDamage(attackDamage);
         return damage;
    }
}
