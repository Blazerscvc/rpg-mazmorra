# Mitigación de daño

**Estado:** Implementada.

`Entity.doDamage(rawDamage)` rechaza cantidades negativas o no finitas. El multiplicador es `100.0 / (100.0 + resistance)`. Con resistencia 0 se recibe todo el daño; con 100 se recibe la mitad. La salud no puede quedar por debajo de cero. El método devuelve la diferencia real entre salud previa y posterior, no necesariamente todo el daño calculado.

La fuerza del atacante no multiplica el daño en el código actual.

**Fuente:** `rpg/entities/Entity.java; Combatant.java`.

## Notas relacionadas

- [[Sistema de entidades]]
- [[Precisión decimal]]
- [[Fragmentación de armas]]
- [[Registro de combate]]
- [[Estadísticas de personajes]]
