# Durabilidad y reparación

**Estado:** Métodos y desgaste automático implementados.

`Weapon` inicia `durability` en `maxDurability`. `reduceDurability(wear)` ignora valores negativos o no finitos y limita el resultado a cero con `Math.max`. `repair(amount)` ignora cantidades negativas, NaN y armas rotas; limita el resultado al máximo mediante `Math.min`. Actualmente admite reparación infinita positiva. `isBroken()` comprueba durabilidad menor o igual a cero.

`Combatant.attack()` llama a `reduceDurability(1)` después de aplicar el daño. No necesita un condicional adicional porque Weapon controla el límite inferior. La durabilidad máxima admite infinito positivo. Ver [[Desgaste al atacar]].

**Fuente:** `rpg/items/Weapon.java; rpg/entities/Combatant.java`.

## Notas relacionadas

- [[Sistema de armas]]
- [[Fragmentación de armas]]
- [[Armas especiales]]
- [[Validaciones de armas]]
- [[Punto flotante en Java]]
