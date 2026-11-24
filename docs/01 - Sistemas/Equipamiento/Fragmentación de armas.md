# Fragmentación de armas

**Estado:** Implementada en Weapon.

Al llegar a durabilidad cero, `isBroken()` identifica el arma rota. `getName()` devuelve `Shard of ` seguido del nombre original, sin modificar el atributo name. `getDamage()` devuelve el 10 % del daño base (penalización del 90 %). `repair()` y `setName()` rechazan modificaciones de armas rotas.

La fragmentación es permanente bajo las operaciones actuales. No hay sustitución automática del objeto. `attack()` ya integra [[Desgaste al atacar]]: el ataque que rompe el arma conserva el daño previo y los siguientes reciben la penalización. Falta una prueba aislada registrada.

**Fuente:** `rpg/items/Weapon.java`.

## Notas relacionadas

- [[Sistema de armas]]
- [[Durabilidad y reparación]]
- [[Armas especiales]]
- [[Mitigación de daño]]
