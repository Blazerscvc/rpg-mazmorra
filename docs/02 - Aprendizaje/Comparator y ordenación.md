# Comparator y ordenación

**Estado:** Concepto aplicado.

Comparator establece un criterio de comparación. `Comparator.comparingInt()` construye un comparador a partir de una clave entera. En CombatEngine, getFormationPriority() aporta la clave y ArrayList.sort() ordena de menor a mayor. La operación modifica las listas recibidas; la ordenación es estable para elementos con igual prioridad.

**Fuente:** `rpg/combat/CombatEngine.java`.

## Notas relacionadas

- [[Formaciones automáticas]]
- [[Selección de objetivos]]
- [[Conceptos de Java]]
