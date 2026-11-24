# Reinicio de temporizadores de ataque

**Estado:** Implementado; reutilización en otra batalla pendiente de prueba específica.

`Combatant.resetAttackTime()` asigna `nextAttackTime = 1000 / attackSpeed`. `CombatEngine.resetTeamAttackTimes()` recorre el equipo y llama al método para cada personaje; `initCombat()` lo ejecuta para aliados y enemigos después de ordenar y antes de bloquear el equipamiento. Así el reloj del motor y los temporizadores individuales parten de la misma referencia temporal. Salud, maná y durabilidad no se restauran por esta operación.

## Notas relacionadas

- [[Programación de ataques]]
- [[Reloj de simulación]]
- [[Ciclo de vida del combate]]
