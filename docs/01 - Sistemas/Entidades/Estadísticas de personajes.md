# Estadísticas de personajes

**Estado:** Atributos implementados; uso parcial en combate.

`Combatant` tiene maná, maná máximo, agilidad, fuerza, velocidad de ataque, instante del siguiente ataque y Team. El constructor valida valores finitos, velocidad estrictamente positiva y equipo no nulo. Salud y resistencia se heredan de Entity.

La fuerza habilita el equipamiento; la velocidad programa ataques. El daño proviene del arma. Maná y agilidad todavía no influyen en el combate; no hay consumo de maná ni habilidades implementadas.

**Fuente:** `rpg/entities/Combatant.java; Team.java`.

## Notas relacionadas

- [[Sistema de entidades]]
- [[Requisitos de equipamiento]]
- [[Programación de ataques]]
- [[Enumeraciones]]
- [[Sistema de combate]]
