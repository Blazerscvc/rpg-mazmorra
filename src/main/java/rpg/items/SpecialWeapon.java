package rpg.items;

public class SpecialWeapon extends Weapon { //Creada para drops especiales

    public SpecialWeapon(String name, double damage, int reqStrength, TypeWeapon type) {
        super(name, damage, Double.POSITIVE_INFINITY, reqStrength, type); //Herencia de Weapon & Resistencia infinita
    }

    @Override //Invalida el cambio de nombre
    public boolean setName(String name) {
        System.out.println("El alma del portador de esta arma protege su nombre, no se puede modificar.");
        return false;
    }
}
