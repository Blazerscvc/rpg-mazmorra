# Sistema de armas

**Estado:** Mecánicas principales implementadas; desgaste automático integrado; inventario pendiente.

`Weapon` representa nombre, daño, durabilidad actual y máxima, fuerza requerida y TypeWeapon. El constructor inicia la durabilidad en su máximo.

| Tipo | Formación |
|---|---|
| PHYSICAL | Primera línea |
| RANGED | Segunda línea |
| STAFF | Retaguardia |

## Mapa del sistema

- [[Requisitos de equipamiento]]: fuerza mínima y arma inicial.
- [[Bloqueo de equipamiento]]: restricción durante la batalla.
- [[Durabilidad y reparación]]: reglas de desgaste y reparación.
- [[Fragmentación de armas]]: consecuencias al llegar a cero.
- [[Armas especiales]]: durabilidad infinita y nombre protegido.
- [[Validaciones de armas]]: datos válidos y rechazados.

## Límites

`attack()` aplica el daño y después solicita [[Desgaste al atacar]] de un punto. El yunque, inventario y efectos especiales son planes, no sistemas implementados.

**Fuente:** `rpg/items/Weapon.java`, `SpecialWeapon.java`, `TypeWeapon.java`, `rpg/entities/Combatant.java`.

## Relacionado

- [[Sistema de combate]]
- [[Formaciones automáticas]]
- [[Inicio - RPG Mazmorra]]
