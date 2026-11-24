# Selección de objetivos

**Estado:** Implementada.

`findLivingTarget()` recorre la lista del equipo contrario y devuelve el primer personaje vivo, o `null` si no hay ninguno. `processTick()` evita atacar si no hay objetivo válido. El motor procesa enemigos antes que aliados; un personaje que deja de estar vivo antes de su turno no actúa.

La prioridad depende de la formación lógica. No existen coordenadas, alcance espacial ni selección avanzada de objetivos. El combate continúa mientras ambos equipos tienen al menos un combatiente vivo.

**Fuente:** `rpg/combat/CombatEngine.java`.

## Notas relacionadas

- [[Sistema de combate]]
- [[Formaciones automáticas]]
- [[Programación de ataques]]
- [[Sistema de entidades]]
- [[Comparator y ordenación]]
