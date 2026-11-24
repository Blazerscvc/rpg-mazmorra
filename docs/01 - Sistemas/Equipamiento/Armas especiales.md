# Armas especiales

**Estado:** Implementadas como subclase.

`SpecialWeapon extends Weapon` pasa `Double.POSITIVE_INFINITY` como durabilidad máxima a `super(...)`. El desgaste finito no consume esa durabilidad. Sobrescribe `setName()` para imprimir un mensaje y devolver false. Conserva las validaciones de daño, fuerza, nombre y tipo de Weapon.

Durabilidad infinita no significa daño infinito. Fists también tiene durabilidad infinita sin ser SpecialWeapon. El yunque y el botín especial son planes, no sistemas existentes.

**Fuente:** `rpg/items/SpecialWeapon.java; Weapon.java`.

## Notas relacionadas

- [[Sistema de armas]]
- [[Durabilidad y reparación]]
- [[Fragmentación de armas]]
- [[Herencia y clases abstractas]]
- [[Polimorfismo y Override]]
