# Constantes static y final

**Estado:** Concepto aplicado.

`private static final int TICK_DURATION = 10` declara una constante de clase de 10 ms. static indica que se comparte entre instancias; final impide reasignar el valor. El reloj `currentTime` no usa static ni final porque cada motor tiene su propio tiempo mutable. Las constantes suelen nombrarse en UPPER_SNAKE_CASE.

## Notas relacionadas

- [[Variables locales y de instancia]]
- [[Reloj de simulación]]
- [[Conceptos de Java]]
