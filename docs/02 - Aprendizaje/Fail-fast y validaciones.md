# Fail-fast y validaciones

**Estado:** Concepto aplicado.

Detectar entradas inválidas cerca de su origen impide propagar estados incorrectos. Weapon valida su constructor y lanza IllegalArgumentException si un argumento obligatorio es incorrecto. validateType() ya rechaza null. CombatEngine usa IllegalStateException cuando no permite iniciar desde el estado actual. No todas las operaciones necesitan lanzar excepciones: algunas reglas retornan sin modificar el objeto.

**Fuente:** `rpg/items/Weapon.java; rpg/combat/CombatEngine.java`.

## Notas relacionadas

- [[Validaciones de armas]]
- [[Máquina de estados del combate]]
- [[Conceptos de Java]]
