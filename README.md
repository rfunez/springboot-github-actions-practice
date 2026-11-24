# Spring Boot - GitHub Actions Practice

Proyecto de ejemplo para practicar CI/CD con GitHub Actions.

## Stack

- Java 21
- Spring Boot 3.5.0
- Maven
- JUnit 5 / Spring Boot Test
- Docker

## Endpoint

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/hello` | Devuelve un saludo en JSON |

Ejemplo de respuesta:

```json
{
  "message": "Hello from Spring Boot!"
}
```

## Ejecutar localmente

Requisitos: Java 21 y Maven instalados.

```bash
mvn spring-boot:run
```

Probar el endpoint:

```bash
curl http://localhost:8080/api/hello
```

## Ejecutar tests

```bash
mvn clean verify
```

## Crear el JAR

```bash
mvn clean package
```

El artefacto se genera en `target/`.

## Construir y ejecutar con Docker

Primero genera el JAR:

```bash
mvn clean package
```

Construye la imagen:

```bash
docker build -t springboot-github-actions-practice:0.0.1 .
```

Ejecuta el contenedor:

```bash
docker run --rm -p 8080:8080 springboot-github-actions-practice:0.0.1
```

Y prueba el endpoint:

```bash
curl http://localhost:8080/api/hello
```

## Workflow inicial

El workflow `.github/workflows/ci.yml` se ejecuta al hacer push a `main` o al abrir/actualizar un Pull Request dirigido a `main`.

Actualmente:
1. Descarga el repositorio.
2. Configura Java 21.
3. Cachea dependencias de Maven.
4. Ejecuta `mvn clean verify` (compilación y tests).

Lo iremos ampliando como práctica: triggers, jobs, steps, variables, secrets, artifacts, matrices, Docker, publicación en GHCR y despliegue.
