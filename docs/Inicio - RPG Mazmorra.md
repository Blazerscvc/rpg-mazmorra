# ⚔️ RPG Mazmorra — Centro de desarrollo

> RPG de mazmorras con combate automático, desarrollado en Java.

**Estado:** Prototipo de combate funcional en consola; MVP jugable en desarrollo.

**Objetivo:** Preparación de personajes, combate automático, exploración básica e interfaz JavaFX. Escribir y comprender personalmente el código.

## Sistemas

- [[Sistema de combate]]
- [[Sistema de armas]]
- [[Sistema de entidades]]
- [[Arquitectura del RPG]]
- [[Conceptos de Java]]
- [[Roadmap del MVP]]
- [[Historial de desarrollo]]
- [[Decisiones técnicas]]
- [[Casos pendientes]]

## Prioridad actual

- [ ] Separar los registros de consola de las reglas del motor.
- [ ] Crear una primera interfaz sencilla con JavaFX.

Consultar [[Reloj de simulación]] y [[Ciclo de vida del combate]].

## Avances

- [x] [[Sistema de entidades]] y [[Estadísticas de personajes]].
- [x] [[Mitigación de daño]] y [[Precisión decimal]].
- [x] [[Sistema de armas]], durabilidad, reparación, fragmentación y armas especiales.
- [x] [[Bloqueo de equipamiento]].
- [x] [[Formaciones automáticas]] y [[Selección de objetivos]].
- [x] [[Máquina de estados del combate]] y procesamiento interno por ticks.
- [x] [[Registro de combate]] y determinación del ganador.
- [x] Validación del tipo de arma no nulo.
- [x] Combate 3 vs. 3 probado manualmente.
- [x] [[Reloj de simulación]] por instancia y resolución de 10 ms.
- [x] [[Ciclo de vida del combate]] con avance independiente mediante `advanceTick()`.
- [x] [[Reinicio de temporizadores de ataque]] al preparar una nueva batalla.
- [x] [[Desgaste al atacar]]: un punto tras aplicar el daño.
- [x] Manejo de errores mediante [[Try y catch]].

## Pruebas y límites

[[Pruebas de combate]] reúne los resultados históricos. No hay pruebas automatizadas verificadas.

- La ejecución completa refactorizada se verificó en consola: victoria aliada, último ataque a 8890 ms. Faltan pruebas específicas de avance externo, reutilización de combatientes y excepciones.
- FINISHED no distingue final normal de excepción dentro del bloque protegido.
- `setInCombat()` es público.
- Los registros utilizan System.out.
- El desgaste automático está implementado; falta registrar una prueba aislada de fragmentación durante un ataque.
- Maná y agilidad aún no intervienen en combate.

## Después de la prioridad actual

- [ ] Preparación e inventario básico.
- [ ] Exploración sencilla y ciclo jugable.
- [ ] Pruebas automatizadas.

Las expansiones futuras se reservan para después del MVP.

## Repositorio y reglas

[GitHub — RPG Mazmorra](https://github.com/Blazerscvc/rpg-mazmorra)

Las carpetas numeradas separan sistemas, aprendizaje, desarrollo, decisiones técnicas y pruebas. La carpeta local privada, la configuración de Obsidian y GEMINI.md se excluyen de Git.

1. Priorizar un MVP jugable.
2. El estudiante escribe Java; la IA orienta y revisa.
3. El código es la fuente de verdad; distinguir pruebas y planes.
4. Mantener notas breves, conectadas y sin duplicación innecesaria.
5. Registrar cambios importantes con Git.
