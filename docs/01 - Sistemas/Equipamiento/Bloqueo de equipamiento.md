# Bloqueo de equipamiento

**Estado:** Implementado; probado manualmente.

`Combatant` tiene el atributo privado `inCombat`, un getter `isInCombat()` y un setter público `setInCombat(boolean)`. `equipWeapon()` conserva el arma anterior cuando el flag es verdadero. `CombatEngine.setTeamCombatState()` actualiza ambos equipos: true durante `initCombat()`, false mediante `finishCombat()` tanto al finalizar normalmente como ante RuntimeException dentro del bloque protegido, si la limpieza se completa.

Prueba histórica: Warrior conservó Iron Sword al intentar equipar Long Bow durante el bloqueo; fuera de combate pudo equiparlo. Se corrigió una llamada recursiva accidental en isInCombat().

La limpieza se adaptó al ciclo por ticks. Pendiente: mejorar encapsulación del setter y verificar específicamente los fallos de ejecución.

**Fuente:** `rpg/entities/Combatant.java; rpg/combat/CombatEngine.java`.

## Notas relacionadas

- [[Sistema de armas]]
- [[Sistema de combate]]
- [[Try y catch]]
- [[Encapsulación]]
- [[Ciclo de vida del combate]]
- [[Pruebas de combate]]
