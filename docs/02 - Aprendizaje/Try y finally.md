# Try y finally

**Estado:** Concepto aplicado.

finally ejecuta limpieza al salir del bloque try, tanto en salida normal como cuando se propaga una excepción, bajo condiciones normales de ejecución. No captura la excepción ni garantiza que la limpieza misma sea exitosa. CombatEngine lo utilizó originalmente para desactivar inCombat y asignar FINISHED al salir del bucle completo. Tras separar los ticks, la limpieza se realiza mediante finishCombat() en la finalización normal o en los catch de RuntimeException. Un finally incondicional en cada tick finalizaría la batalla prematuramente. Ver [[Try y catch]].

**Fuente:** `rpg/combat/CombatEngine.java`.

## Notas relacionadas

- [[Máquina de estados del combate]]
- [[Bloqueo de equipamiento]]
- [[Ciclo de vida del combate]]
- [[Conceptos de Java]]
