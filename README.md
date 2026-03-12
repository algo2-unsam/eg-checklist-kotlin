## CheckList

[![build](https://github.com/algo2-unsam/eg-checklist-kotlin/actions/workflows/build.yml/badge.svg)](https://github.com/algo2-unsam/eg-checklist-kotlin/actions/workflows/build.yml) [![codecov](https://codecov.io/gh/algo2-unsam/eg-checklist-kotlin/branch/main/graph/badge.svg?token=qPo1ZrMPRq)](https://codecov.io/gh/algo2-unsam/eg-checklist-kotlin)

Queremos llevar el seguimiento de listas de tareas que pueden completarse de a poco. Cada tarea puede marcarse como hecha o deshacerse, y nos interesa saber en qué punto está la lista en su conjunto.

### Requerimientos

- Las tareas tienen una descripción y su estado debe poder cambiarse.
- Debe poder saberse si una lista todavía no arrancó, está siendo completada o ya terminó.
- Debe poder calcularse cuánto avanzó una lista en porcentaje.