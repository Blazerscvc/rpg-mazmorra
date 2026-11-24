# Formaciones automáticas

**Estado:** Implementadas; comparación manual registrada.

Al iniciar, CombatEngine ordena ambos equipos por tipo de arma equipada mediante `Comparator.comparingInt()` y `getFormationPriority()`.

| Tipo | Prioridad | Posición lógica |
|---|---:|---|
| PHYSICAL | 0 | Primera línea |
| RANGED | 1 | Segunda línea |
| STAFF | 2 | Retaguardia |

`findLivingTarget()` selecciona al primer rival vivo. No existen coordenadas ni movimiento físico en una arena.

## Experimento histórico

Mismos personajes y estadísticas, distinto orden de formación:

| Formación | Duración registrada | Resultado | Supervivientes aliados |
|---|---:|---|---:|
| Magos delante | 15 100 ms | Victoria aliada | 1 |
| Guerreros delante | 8 900 ms | Victoria aliada | 2 |

El orden afectó duración y supervivencia en estas pruebas; no implica que una formación sea siempre óptima. Cambiar de arma antes del combate puede cambiar la prioridad. Durante la batalla el equipamiento está bloqueado.

**Futuro:** formaciones personalizadas, movimiento 2D y estrategias de objetivos.

**Fuente:** `rpg/combat/CombatEngine.java` y experimentos conservados de la nota original.

## Relacionado

- [[Sistema de combate]]
- [[Selección de objetivos]]
- [[Bloqueo de equipamiento]]
- [[Comparator y ordenación]]
- [[Sistema de armas]]
- [[Arquitectura del RPG]]
- [[Pruebas de combate]]
