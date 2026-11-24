# Requisitos de equipamiento

**Estado:** Implementados.

`Combatant.equipWeapon()` valida que el arma no sea nula, mediante IllegalArgumentException. Si su fuerza requerida supera la fuerza del personaje o está en combate, retorna sin reemplazar el arma. Cada personaje comienza con Fists: arma física de daño 1, durabilidad infinita y requisito 1. La asignación inicial no pasa por equipWeapon().

La fuerza habilita el equipamiento; no multiplica el daño. Inventario y preparación interactiva pendientes.

**Fuente:** `rpg/entities/Combatant.java; rpg/items/Weapon.java`.

## Notas relacionadas

- [[Sistema de armas]]
- [[Bloqueo de equipamiento]]
- [[Estadísticas de personajes]]
- [[Validaciones de armas]]
