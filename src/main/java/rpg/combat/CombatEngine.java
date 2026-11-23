package rpg.combat;

import rpg.entities.Combatant;
import rpg.items.TypeWeapon;
import java.util.Comparator;
import java.util.ArrayList;

public class CombatEngine {
    private CombatState state = CombatState.READY;
    private ArrayList<Combatant> allies;
    private ArrayList<Combatant> enemies;

    public CombatEngine(ArrayList<Combatant> allies, ArrayList<Combatant> enemies) {
        this.allies = allies;
        this.enemies = enemies;
    }

    public void startCombat() {
        if(state != CombatState.READY) {
            throw new IllegalStateException("El combate solo puede iniciarse en estado READY.");
        }

        allies.sort(Comparator.comparingInt(character -> getFormationPriority(character)));
        enemies.sort(Comparator.comparingInt(character -> getFormationPriority(character)));

       try {
           setTeamCombatState(allies, true);
           setTeamCombatState(enemies, true);

           double tiempo = 0;

           state = CombatState.RUNNING;

           while (combatantsTeamAlive(allies) && combatantsTeamAlive(enemies)) {

               processTick(tiempo);
               tiempo += 100;
           }
       } finally {
           setTeamCombatState(allies, false);
           setTeamCombatState(enemies, false);
           state = CombatState.FINISHED;
       }

        if (combatantsTeamAlive(enemies)){
            System.out.println("El ganador es el equipo enemigo");
        } else if (combatantsTeamAlive(allies)) {
            System.out.println("El ganador es el equipo aliado");
        }

    }

    private void processTick(double tiempo) {
        for (Combatant enemy : enemies) {

            if(enemy.isAlive() && enemy.canAttack(tiempo)) {
                Combatant target = findLivingTarget(allies); //Locate Target
                if(target == null) { //if NO VALID TARGET
                    continue;
                }
                double attack = enemy.attack(target); //Attack Target
                enemy.scheduleNextAttack();
                System.out.printf("[%.0f ms] %s ataca a %s: %.2f de daño.%n", //Same Target
                        tiempo, enemy.getName(), target.getName(), attack);
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
                System.out.printf("[%.0f ms] %s ataca a %s: %.2f de daño.%n",
                        tiempo, ally.getName(), target.getName(), attack);
            }
        }
    }

    public CombatState getState() {
        return state;
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

    private void setTeamCombatState(ArrayList<Combatant> team, boolean inCombat) {
        for(Combatant character : team) {
            character.setInCombat(inCombat);
        }
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
