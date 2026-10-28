package rpg.main;

import rpg.entities.CharacterPVP;
import rpg.items.TypeWeapon;
import rpg.items.Weapon;

public class Main {
    public static void main(String[] args) {

        //TEST V1
        CharacterPVP hero = new CharacterPVP("Brayan",100,100,10,1,5);
        CharacterPVP villain = new CharacterPVP("El papu :v",100,100,10,1,100);
        Weapon bow = new Weapon("Matapapus3000", 10,100, TypeWeapon.RANGED);



        System.out.println("Vida inicial de " + villain.getName() + ": " + villain.getHealth()); //ANTES




        hero.attack(villain);//Se Ataca a Villain su vida deberia bajar


        System.out.println("¡" + hero.getName() + " atacó a " + villain.getName() + " con un " +hero.getEquippedWeapon().getName()+"!");
        System.out.println("Vida actual de " + villain.getName() + ": " + villain.getHealth()); //Despues

        hero.equipWeapon(bow); //Se equipa arco
        hero.attack(villain); //Se ataca por una segunda vez con una nueva arma

        System.out.println("¡" + hero.getName() + " atacó a " + villain.getName() + " con un " +hero.getEquippedWeapon().getName()+"!");
        System.out.println("Vida actual de " + villain.getName() + ": " + villain.getHealth()); //Despues V2


    }
}
