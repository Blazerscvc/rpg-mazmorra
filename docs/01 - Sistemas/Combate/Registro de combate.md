# Registro de combate

**Estado:** Implementado en consola; desacoplamiento pendiente.

`processTick()` usa `System.out.printf()` con `[%.0f ms]`, nombre del atacante, objetivo y `%.2f` para el daño. El daño devuelto por `attack()` proviene de la diferencia de salud del objetivo; los dos decimales son formato de presentación, no una modificación del valor interno.

Al finalizar normalmente, el motor anuncia al equipo superviviente. Para JavaFX se plantea emitir datos/eventos independientes de la consola; todavía no existe ese mecanismo.

**Fuente:** `rpg/combat/CombatEngine.java; rpg/entities/Entity.java`.

## Notas relacionadas

- [[Sistema de combate]]
- [[Precisión decimal]]
- [[Arquitectura del RPG]]
- [[Ciclo de vida del combate]]
