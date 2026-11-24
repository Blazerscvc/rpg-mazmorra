# Desgaste al atacar

**Estado:** Implementado en código; prueba aislada pendiente de registro.

`Combatant.attack()` obtiene el daño del arma, aplica `target.doDamage(totalDamage)` y después llama a `equippedWeapon.reduceDurability(1)`. Si aplicar daño lanza una excepción, no se ejecuta esa reducción. Weapon limita durabilidad a cero; un desgaste finito conserva durabilidad infinita. El ataque que agota la durabilidad utiliza el daño previo; el siguiente utiliza el 10 %.

## Notas relacionadas

- [[Durabilidad y reparación]]
- [[Fragmentación de armas]]
- [[Sistema de armas]]
