package rpg.combat;

import rpg.entities.Combatant;
import rpg.items.TypeWeapon;
import java.util.Comparator;
import java.util.ArrayList;

public class CombatEngine {
    private ArrayList<Combatant> allies;
    private ArrayList<Combatant> enemies;

    public CombatEngine(ArrayList<Combatant> allies, ArrayList<Combatant> enemies) {
        this.allies = allies;
        this.enemies = enemies;
    }

    public void startCombat() {
        allies.sort(Comparator.comparingInt(character -> getFormationPriority(character)));
        enemies.sort(Comparator.comparingInt(character -> getFormationPriority(character)));

        double tiempo = 0;
        while (combatantsTeamAlive(allies) && combatantsTeamAlive(enemies)) {
            for (Combatant enemy : enemies) {
                if(enemy.isAlive() && enemy.canAttack(tiempo)) {

                    Combatant target = findLivingTarget(allies);
                    if(target == null) {
                        continue;
                    }
                    double attack = enemy.attack(target);
                    enemy.scheduleNextAttack();
                    System.out.println("["+tiempo+" ms] "+ enemy.getName()+" ataca a "+ target.getName() +": "+ attack+" de daño." );
                }
            }

            for (Combatant ally : allies) {
                if(ally.isAlive() && ally.canAttack(tiempo)) {

                    Combatant target = findLivingTarget(enemies);
                    if(target == null) {
                        continue;
                    }
                    double attack = ally.attack(target);
                    ally.scheduleNextAttack();
                    System.out.println("["+tiempo+" ms] "+ ally.getName()+" ataca a "+ target.getName() +": "+ attack+" de daño." );
                }
            }
            tiempo += 100;
        }

        if (combatantsTeamAlive(enemies)){
            System.out.println("El ganador es el equipo enemigo");
        } else if (combatantsTeamAlive(allies)) {
            System.out.println("El ganador es el equipo aliado");
        }

    }
    private boolean combatantsTeamAlive(ArrayList<Combatant> team) {
        for (Combatant character : team) {
            if (character.isAlive()){
                return  true;
            }
        }
        return false;
    }

    private Combatant findLivingTarget(ArrayList<Combatant> team) {
        for (Combatant character : team) {
            if (character.isAlive()) {
                return  character;
            }
        }
        return null;
    }

    private int getFormationPriority(Combatant character) {
        if (character.getEquippedWeapon().getType() == TypeWeapon.PHYSICAL) {
            return 0;
        } else if (character.getEquippedWeapon().getType() == TypeWeapon.RANGED) {
            return 1;
        } else if (character.getEquippedWeapon().getType() == TypeWeapon.STAFF) {
            return 2;
        }
        throw new IllegalStateException("Tipo de arma no reconocida.");
    }
}
