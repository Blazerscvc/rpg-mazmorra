# Arquitectura del RPG

**Estado:** Arquitectura actual documentada; interfaz pendiente.

Proyecto Java con Maven. Paquetes: `rpg.entities` (Entity, Combatant, Team); `rpg.items` (Weapon, SpecialWeapon, TypeWeapon); `rpg.combat` (CombatEngine, CombatState); `rpg.main` (Main, escenario de prueba). El motor coordina los objetos del modelo; Main construye los equipos y ejecuta el combate.

Decisión implementada: el motor conserva las reglas y el reloj simulado. `initCombat()` y `advanceTick()` permiten control externo; `startCombat()` conserva la ejecución por consola. JavaFX será una representación y solicitará avances. Actualmente los mensajes de consola siguen dentro del motor. No existe una interfaz JavaFX implementada ni un sistema de eventos independiente. No se necesita una arquitectura compleja para el MVP.

**Fuente:** `src/main/java/rpg; pom.xml`.

## Notas relacionadas

- [[Sistema de combate]]
- [[Sistema de armas]]
- [[Sistema de entidades]]
- [[Ciclo de vida del combate]]
- [[Conceptos de Java]]
- [[Inicio - RPG Mazmorra]]
