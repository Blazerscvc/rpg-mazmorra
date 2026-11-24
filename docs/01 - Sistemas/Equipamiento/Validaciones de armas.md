# Validaciones de armas

**Estado:** Implementadas; prueba específica de tipo nulo pendiente de registrar.

| Dato | Condición válida |
|---|---|
| Nombre | No nulo ni en blanco |
| Daño | Finito y no negativo |
| Durabilidad máxima | No negativa ni NaN; admite infinito positivo |
| Fuerza requerida | Entero no negativo |
| Tipo | TypeWeapon no nulo |

`validateType()` se corrigió: ahora lanza IllegalArgumentException si recibe null; antes el bloque estaba vacío. `setName()` retorna false para nombres inválidos, iguales al actual o armas rotas. Las operaciones de durabilidad ignoran entradas no permitidas en lugar de lanzar excepciones.

**Fuente:** `rpg/items/Weapon.java`.

## Notas relacionadas

- [[Sistema de armas]]
- [[Fail-fast y validaciones]]
- [[Enumeraciones]]
- [[Pruebas de combate]]
- [[Durabilidad y reparación]]
