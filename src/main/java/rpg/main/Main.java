package rpg.main;

import rpg.items.TypeWeapon;
import rpg.items.Weapon;

public class Main {
    public static void main(String[] args) {

        Weapon longSword = new Weapon("Long Sword", 50, 100, 10, TypeWeapon.PHYSICAL);
        Weapon bow = new Weapon("bow", 25, 150, 10, TypeWeapon.RANGED);

        //Mostrar DATOS Antes
        System.out.println("------------------------------");
        System.out.println("Nombre actual: "+longSword.getName());
        System.out.println("Durabilidad actual: "+longSword.getDurability());
        System.out.println("Daño actual: "+longSword.getDamage());



        //Reducir durabilidad
        longSword.reduceDurability(120);

        System.out.println("------------------------------");

        //Revisar si se ha fragmentado
        if (longSword.isBroken()) {
            System.out.println("Tu arma se ha fragmentado");
        } else {
            System.out.println("Tu arma no se ha fragmentado");
        }

        System.out.println("------------------------------");
        // Mostrar DATOS Despues
        System.out.println("Nombre actual: "+longSword.getName());
        System.out.println("Durabilidad actual: "+longSword.getDurability());
        System.out.println("Daño actual: "+longSword.getDamage());
        System.out.println("------------------------------");

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("TEST REPARAR ARMA");
        System.out.println("------------------------------");
        System.out.println("Nombre actual: "+ bow.getName());
        System.out.println("Durabilidad actual: "+ bow.getDurability());
        System.out.println("Daño actual: "+ bow.getDamage());
        System.out.println("------------------------------");

        //Reducir durabilidad al arma
        bow.reduceDurability(50);
        System.out.println("Tu arma ha sufrido 50 de daño en durabilidad");
        System.out.println("------------------------------");
        System.out.println("Nombre actual: "+ bow.getName());
        System.out.println("Durabilidad actual: "+ bow.getDurability());
        System.out.println("------------------------------");

        //Reparar arma
        bow.repair(30);
        System.out.println("Tu arma se ha reparado 30 de durabilidad");
        System.out.println("------------------------------");

        //Mostrar la reparacion
        System.out.println("Nombre actual: "+ bow.getName());
        System.out.println("Durabilidad actual: "+ bow.getDurability());
        System.out.println("------------------------------");

        //Fragmentar el arma
        bow.reduceDurability(130);

        //Revisar si se ha fragmentado
        if (bow.isBroken()) {
            System.out.println("Tu arma se ha fragmentado");
        } else {
            System.out.println("Tu arma no se ha fragmentado");
        }
        System.out.println("------------------------------");
        System.out.println("Nombre actual: "+ bow.getName());
        System.out.println("Durabilidad actual: "+ bow.getDurability());
        System.out.println("------------------------------");
        //Reparar arma
        bow.repair(30);
        System.out.println("Tu arma no se ha reparado");
        System.out.println("------------------------------");
        System.out.println("Nombre actual: "+ bow.getName());
        System.out.println("Durabilidad actual: "+ bow.getDurability());
        System.out.println("Daño actual: "+ bow.getDamage());
        System.out.println("------------------------------");
    }
}