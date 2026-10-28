package rpg.items;

public class SpecialWeapon extends Weapon { //Creada para drops especiales

    public SpecialWeapon(String name, double damage, TypeWeapon type) {
        super(name, damage, Double.POSITIVE_INFINITY, type); //Herencia de Weapon & Resistencia infinita
    }

    @Override //Invalida el cambio de nombre
    public void setName(String name) {
        System.out.println("El alma del portador de esta arma protege su nombre, no se puede modificar.");
    }
}
