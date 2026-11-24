# Ciclo de vida del combate

**Estado:** Refactorización implementada; combate completo verificado manualmente.

- `initCombat()` (público): exige READY, reinicia reloj, ordena equipos, reinicia temporizadores individuales, bloquea equipamiento y establece RUNNING.
- `advanceTick()` (público): exige RUNNING, procesa un tick, incrementa reloj y finaliza si algún equipo no tiene supervivientes.
- `finishCombat()` (privado): desbloquea equipamiento y establece FINISHED.
- `announceWinner()` (privado): comunica el equipo superviviente al terminar normalmente.
- `startCombat()` (público): prepara y repite advanceTick() mientras RUNNING.

Las validaciones de estado quedan fuera de los bloques try. Los catch de RuntimeException en initCombat() y advanceTick() llaman a finishCombat() y relanzan la excepción original sin anunciar un ganador por el fallo. Esto supone que la limpieza puede completarse; si también falla, podría ocultar el error original. El motor conserva FINISHED para terminaciones normales e interrumpidas. Siguiente objetivo: eventos sin consola.

**Fuente:** `rpg/combat/CombatEngine.java`.

## Notas relacionadas

- [[Arquitectura del RPG]]
- [[Máquina de estados del combate]]
- [[Reloj de simulación]]
- [[Bloqueo de equipamiento]]
- [[Try y catch]]
- [[Separación de responsabilidades]]
- [[Pruebas de combate]]
