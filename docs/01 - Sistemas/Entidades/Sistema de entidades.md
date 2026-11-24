# Sistema de entidades

**Estado:** Implementado.

`Entity` es una clase abstracta con nombre, salud, salud máxima y resistencia. Valida nombre no vacío, salud máxima positiva finita y resistencia no negativa finita. `doDamage()` aplica mitigación y limita salud a cero; `doHeal()` limita salud al máximo e ignora cantidades negativas o no finitas. `isAlive()` comprueba health > 0.

`Combatant extends Entity` añade estadísticas y equipamiento. No hay una restricción explícita contra curar una entidad con salud cero.

**Fuente:** `rpg/entities/Entity.java; Combatant.java`.

## Notas relacionadas

- [[Estadísticas de personajes]]
- [[Mitigación de daño]]
- [[Precisión decimal]]
- [[Herencia y clases abstractas]]
- [[Arquitectura del RPG]]
- [[Inicio - RPG Mazmorra]]
