package rpg.main;

import rpg.entities.Combatant;
import rpg.entities.Team;
import rpg.items.TypeWeapon;
import rpg.items.Weapon;

public class Main {
    public static void main(String[] args) {

        Combatant badGuy = new Combatant("BadGuy", 100, 100, 100, 50,1.0, 50, Team.ENEMY);
        Combatant goodGuy = new Combatant("GoodGuy", 100, 100, 100, 100,2.0, 100, Team.ALLY);
        Weapon swordG = new Weapon("Sword", 12,100,5,TypeWeapon.PHYSICAL);
        Weapon swordB = new Weapon("Sword", 12,100,5,TypeWeapon.PHYSICAL);
        goodGuy.equipWeapon(swordG);
        badGuy.equipWeapon(swordB);

        double tiempo = 0;
       while (badGuy.isAlive() && goodGuy.isAlive()) {

           if(badGuy.isAlive() && badGuy.canAttack(tiempo)) {

               double attack = badGuy.attack(goodGuy);
               badGuy.scheduleNextAttack();
               System.out.println("["+tiempo+" ms] "+ badGuy.getName()+" ataca a "+ goodGuy.getName() +": "+ attack+" de daño." );
           }



           if (goodGuy.isAlive() && goodGuy.canAttack(tiempo)) {
               double attack = goodGuy.attack(badGuy);
               goodGuy.scheduleNextAttack();
               System.out.println("["+tiempo+" ms] "+ goodGuy.getName()+" ataca a "+ badGuy.getName() +": "+ attack+" de daño." );
           }
           tiempo += 100;
       }

        if (badGuy.isAlive()){
            System.out.println("El ganador es "+badGuy.getName());
        } else if (goodGuy.isAlive()) {
            System.out.println("El ganador es "+goodGuy.getName());
        }
    }
}