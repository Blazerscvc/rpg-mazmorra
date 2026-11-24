# Precisión decimal

**Estado:** Corrección implementada.

Las operaciones repetidas con double pueden dejar residuos positivos diminutos cuando la salud debería ser cero. En `Entity`, EPSILON vale 1e-9. Después de aplicar daño y limitar salud a cero, si `0 < health < EPSILON`, la salud se fija en cero. Así `isAlive()` no mantiene vivo a un personaje por un residuo numérico.

La presentación con dos decimales no cambia el valor almacenado. Pruebas manuales previas registraron la corrección; una suite automatizada aún está pendiente.

**Fuente:** `rpg/entities/Entity.java`.

## Notas relacionadas

- [[Sistema de entidades]]
- [[Mitigación de daño]]
- [[Punto flotante en Java]]
- [[Pruebas de combate]]
- [[Registro de combate]]
