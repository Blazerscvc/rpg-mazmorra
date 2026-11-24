# Máquina de estados del combate

**Estado:** Implementada; pruebas manuales registradas.

`CombatState` define `READY`, `RUNNING` y `FINISHED`. `CombatEngine` comienza en READY. `initCombat()` exige READY y establece RUNNING tras preparar equipos. `advanceTick()` exige RUNNING. Las llamadas inválidas lanzan IllegalStateException antes del try, sin cambiar el estado. `finishCombat()` desbloquea equipos y establece FINISHED. Los catch de RuntimeException de los métodos públicos realizan esa limpieza y relanzan la excepción si la limpieza termina. `getState()` permite consultar el estado.

Pruebas históricas: READY al inicio, FINISHED después, rechazo del segundo inicio. La adaptación a ticks independientes está implementada. Pendiente: distinguir final normal de fallo y verificar los casos de excepción específicamente.

**Fuente:** `rpg/combat/CombatEngine.java; CombatState.java`.

## Notas relacionadas

- [[Sistema de combate]]
- [[Ciclo de vida del combate]]
- [[Enumeraciones]]
- [[Fail-fast y validaciones]]
- [[Try y catch]]
- [[Pruebas de combate]]
