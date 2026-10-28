package rpg.entities;

import rpg.items.TypeWeapon;
import rpg.items.Weapon;

public class CharacterPVP extends Entity { //Entidad PvE & PVP
    private double mana;
    private double maxMana;
    private double agility;
    private double strength;
    private Weapon equippedWeapon;


    public CharacterPVP(String name, double maxHealth, double maxMana, double agility, double strength, double resistance) {
        super(name, maxHealth, resistance); //Herencia de Entity
        this.maxMana = maxMana;
        this.mana = maxMana;
        this.agility = agility;
        this.strength = strength;
        this.equippedWeapon = new Weapon("Fists", 1, Double.POSITIVE_INFINITY, TypeWeapon.PHYSICAL);
    }

    //GETTER
    public Weapon getEquippedWeapon() {
         return this.equippedWeapon;
    }

    //ACTIONS
    public void attack(Entity target) {
        double totalDamage = this.equippedWeapon.getDamage();
                target.doDamage(totalDamage);

    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }
}
