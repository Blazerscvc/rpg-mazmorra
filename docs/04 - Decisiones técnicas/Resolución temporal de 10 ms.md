# Resolución temporal de 10 ms

**Estado:** Adoptada e implementada.

Se sustituyeron los pasos de 100 ms por 10 ms para reducir el retraso de discretización. Se mantiene una simulación de paso fijo por simplicidad del MVP; una cola de eventos temporales queda aplazada. La frecuencia efectiva sigue limitada a un ataque por personaje por tick.

Ver [[Reloj de simulación]], [[Programación de ataques]] y [[Decisiones técnicas]].
