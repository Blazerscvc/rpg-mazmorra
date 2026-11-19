package rpg.main;

import rpg.combat.CombatEngine;
import rpg.entities.Combatant;
import rpg.entities.Team;
import rpg.items.TypeWeapon;
import rpg.items.Weapon;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Combatant> allies = new ArrayList<>();
        ArrayList<Combatant> enemies = new ArrayList<>();

        // EQUIPO ALIADO
        Combatant warrior = new Combatant("Warrior", 150, 30, 25, 100, 1.2, 50, Team.ALLY);
        Combatant archer = new Combatant("Archer", 95, 50, 95, 40, 1.8, 20, Team.ALLY);
        Combatant mage = new Combatant("Mage", 75, 130, 40, 15, 1.0, 15, Team.ALLY);

        // EQUIPO ENEMIGO
        Combatant bandit = new Combatant("Bandit", 130, 20, 35, 70, 1.3, 40, Team.ENEMY);
        Combatant hunter = new Combatant("Hunter", 90, 40, 80, 35, 1.7, 15, Team.ENEMY);
        Combatant sorcerer = new Combatant("Sorcerer", 80, 120, 30, 15, 1.1, 10, Team.ENEMY);

        // ARMAS ALIADAS
        Weapon ironSword = new Weapon("Iron Sword", 16, 100, 60, TypeWeapon.PHYSICAL);
        Weapon longBow = new Weapon("Long Bow", 12, 100, 20, TypeWeapon.RANGED);
        Weapon magicStaff = new Weapon("Magic Staff", 14, 100, 10, TypeWeapon.STAFF);


        // ARMAS ENEMIGAS
        Weapon battleAxe = new Weapon("Battle Axe", 15, 100, 45, TypeWeapon.PHYSICAL);
        Weapon crossbow = new Weapon("Crossbow", 11, 100, 25, TypeWeapon.RANGED);
        Weapon cursedStaff = new Weapon("Cursed Staff", 13, 100, 10, TypeWeapon.STAFF);

        //EQUIPAMIENTO
        warrior.equipWeapon(ironSword);
        archer.equipWeapon(longBow);
        mage.equipWeapon(magicStaff);

        bandit.equipWeapon(battleAxe);
        hunter.equipWeapon(crossbow);
        sorcerer.equipWeapon(cursedStaff);

        //AGREGACION A EQUIPOS
        allies.add(mage);
        allies.add(archer);
        allies.add(warrior);

        enemies.add(sorcerer);
        enemies.add(hunter);
        enemies.add(bandit);

        CombatEngine pvp1 = new CombatEngine(allies, enemies);
        pvp1.startCombat();

    }
}