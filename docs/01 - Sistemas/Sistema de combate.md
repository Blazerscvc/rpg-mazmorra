# Sistema de combate

**Estado:** Funcional en consola; probado manualmente.

`CombatEngine` coordina dos listas `ArrayList<Combatant>` y ejecuta ataques automáticamente hasta que un equipo no tiene combatientes vivos.

## Mapa del sistema

- [[Máquina de estados del combate]]: READY, RUNNING y FINISHED.
- [[Ciclo de vida del combate]]: preparación, ejecución y limpieza.
- [[Reloj de simulación]]: instantes de 10 ms; reloj por instancia y avance independiente implementados.
- [[Programación de ataques]]: cadencia individual.
- [[Formaciones automáticas]] y [[Selección de objetivos]]: orden lógico y objetivos vivos.
- [[Bloqueo de equipamiento]]: impide cambiar armas durante la batalla.
- [[Registro de combate]]: mensajes actuales y desacoplamiento pendiente.
- [[Pruebas de combate]]: resultados registrados y casos pendientes.

## Prioridad

La separación del ciclo de vida está implementada y la ejecución completa se verificó en consola. Siguiente objetivo: desacoplar los registros de combate de System.out. JavaFX representará el estado, sin decidir las reglas.

**Fuente:** `rpg/combat/CombatEngine.java`, `CombatState.java` y `rpg/entities/Combatant.java`.

## Relacionado

- [[Sistema de armas]]
- [[Sistema de entidades]]
- [[Arquitectura del RPG]]
- [[Inicio - RPG Mazmorra]]
