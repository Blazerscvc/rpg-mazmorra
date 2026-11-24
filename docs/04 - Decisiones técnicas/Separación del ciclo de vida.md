# Separación del ciclo de vida

**Estado:** Adoptada e implementada.

Se separaron inicio, avance, limpieza y anuncio del ganador para permitir control externo y conservar la ejecución completa en consola. Se prefirió reutilizar finishCombat() para limpiar sin anunciar un ganador ante fallos. Las precondiciones quedan fuera del try.

Ver [[Ciclo de vida del combate]], [[Try y catch]] y [[Decisiones técnicas]].
