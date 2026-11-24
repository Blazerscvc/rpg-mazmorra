# Try y catch

**Estado:** Concepto aplicado.

`catch (RuntimeException e)` reacciona a una excepción de ejecución. `throw e` propaga la misma excepción; `throw new RuntimeException(e)` crea otra que la contiene. Las validaciones de estado quedan fuera del try para que las llamadas inválidas no disparen limpieza de un combate existente. En initCombat() y advanceTick(), finishCombat() limpia el estado antes de relanzar la excepción, siempre que la limpieza tenga éxito.

## Notas relacionadas

- [[Try y finally]]
- [[Ciclo de vida del combate]]
- [[Fail-fast y validaciones]]
- [[Conceptos de Java]]
