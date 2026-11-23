package rpg.entities;

import rpg.items.TypeWeapon;
import rpg.items.Weapon;

public class Combatant extends Entity { //Entidad PvE & PVP
    private double mana;
    private double maxMana;
    private double agility;
    private double strength;
    private double attackSpeed;
    private double nextAttackTime;
    private Team team;
    private boolean inCombat; //Se asume por logica con False/True


    private Weapon equippedWeapon;


    public Combatant(String name, double maxHealth, double maxMana, double agility, double strength, double attackSpeed, double resistance, Team team ) {
        super(name, maxHealth, resistance); //Herencia de Entity
        validMaxMana(maxMana);
        validAgility(agility);
        validStrength(strength);
        validAttackSpeed(attackSpeed);
        validTeam(team);
        this.maxMana = maxMana;
        this.mana = maxMana;
        this.agility = agility;
        this.strength = strength;
        this.attackSpeed = attackSpeed;
        this.nextAttackTime = 1000.0/attackSpeed;
        this.team = team;
        this.equippedWeapon = new Weapon("Fists", 1, Double.POSITIVE_INFINITY, 1, TypeWeapon.PHYSICAL);
    }

    //FILTROS CONSTRUCTOR

    private void validMaxMana(double maxMana) {
        if(maxMana < 0 || !Double.isFinite(maxMana)) {
            throw new IllegalArgumentException("Este valor no es valido en su asignacion.");
        }
    }

    private void validAgility(double agility) {
        if(agility < 0 || !Double.isFinite(agility)) {
            throw new IllegalArgumentException("Este valor no es valido en su asignacion.");
        }
    }

    private void validStrength(double strength) {
        if(strength < 0 || !Double.isFinite(strength)) {
            throw new IllegalArgumentException("Este valor no es valido en su asignacion.");
        }
    }

    private void validAttackSpeed(double attackSpeed) {
        if(attackSpeed <= 0 || !Double.isFinite(attackSpeed)) {
            throw new IllegalArgumentException("Este valor no es valido en su asignacion.");
        }
    }

    private void validTeam(Team team) {
        if(team == null) {
            throw new IllegalArgumentException("El Enum asignado no puede ser declarado");
        }
    }

    private void validEquippedWeapon(Weapon weapon) {
        if(weapon == null) {
            throw new IllegalArgumentException("El Weapon asignado no puede ser declarado");
        }
    }

    //GETTER

    public boolean isInCombat() { return inCombat; }
    public double getAttackSpeed() {
        return attackSpeed;
    }

    public Weapon getEquippedWeapon() {
         return this.equippedWeapon;
    }

    public Team getTeam() {
        return team;
    }

    //ACTIONS
    public double attack(Entity target) {
        double totalDamage = this.equippedWeapon.getDamage();
        double damage = target.doDamage(totalDamage);
        return damage;
    }

    public boolean canAttack(double currentTime) {
        if (currentTime < nextAttackTime) {
            return false;
        }
        return true;
    }

    public void setInCombat(boolean inCombat) {
        this.inCombat = inCombat;
    }

    public void scheduleNextAttack() {
        nextAttackTime += 1000/attackSpeed;
    }

    public void equipWeapon(Weapon weapon) {
        validEquippedWeapon(weapon);
        if(weapon.getReqStrength() > strength || inCombat) {
            return;
        }
        this.equippedWeapon = weapon;
    }
}
