# Encapsulación

**Estado:** Concepto aplicado; mejora pendiente.

Proteger el estado de un objeto y ofrecer operaciones que mantengan sus reglas. Un atributo privado no garantiza encapsulación si un setter público permite cambiarlo arbitrariamente. Weapon controla su durabilidad; Combatant mantiene inCombat privado pero su setter es público.

Pregunta: ¿quién debería controlar el estado de combate y qué cambios deben permitirse?

**Fuente:** `rpg/entities/Combatant.java; rpg/items/Weapon.java`.

## Notas relacionadas

- [[Bloqueo de equipamiento]]
- [[Validaciones de armas]]
- [[Conceptos de Java]]
