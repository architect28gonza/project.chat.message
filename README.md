# Gestion de Usuarios para Chat

Este proyecto proporciona una solución para gestionar el ingreso de usuarios al chat.

## Descripción

Este proyecto está construido utilizando Spring Boot y Spring Data JPA para la capa de persistencia de datos. Proporciona endpoints RESTful para interactuar con la aplicación y gestionar los usuarios del chat. Además, se integra con Spring Security para la seguridad de la aplicación.

## Requisitos

- Java 17
- Maven
- PostgreSQL

## Configuración

Asegúrate de tener PostgreSQL instalado y configurado correctamente. Puedes modificar la configuración de la base de datos en el archivo `application.properties`.

## Ejecución

Para ejecutar la aplicación, puedes usar el plugin de Spring Boot Maven. Ejecuta el siguiente comando en la terminal:

```bash
mvn spring-boot:run
```

### Dependencias Principales
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot DevTools
- PostgreSQL Driver
- Lombok
- Spring Boot Starter Test
- ModelMapper
- Spring Boot Starter Security

# Servicio de Autenticación para Chat

Este microservicio se encarga de gestionar la autenticación de los usuarios para el chat. Además, proporciona funcionalidades para autenticarse mediante otras APIs como Google, Facebook y otras.

## Descripción

Este microservicio está construido utilizando Spring Boot y Spring Security para la autenticación y autorización de usuarios. Utiliza PostgreSQL como base de datos para almacenar la información de autenticación. También se integra con JSON Web Tokens (JWT) para la autenticación basada en tokens.

## Requisitos

- Java 17
- Maven
- PostgreSQL

## Configuración

Asegúrate de tener PostgreSQL instalado y configurado correctamente. Puedes modificar la configuración de la base de datos en el archivo `application.properties`. Además, asegúrate de configurar adecuadamente las claves y tokens de las APIs externas para la autenticación.

## Ejecución

Para ejecutar el microservicio, puedes utilizar el plugin de Spring Boot Maven. Ejecuta el siguiente comando en la terminal:

```bash
mvn spring-boot:run
```
### Dependencias Principales
- Spring Boot Starter Security
- Spring Boot Starter Web
- Spring Boot DevTools
- PostgreSQL Driver
- Lombok
- Spring Boot Starter Test
- Spring Security Test
- Spring Boot Starter Data JPA
- jjwt-api
- jjwt-impl
- jjwt-jackson
- Google API Client
- JSON

# backend.chat.sse

Este proyecto constituye el backend para un sistema de chat con soporte para Server-Sent Events (SSE).

## Descripción

Este proyecto utiliza AdonisJS como framework de desarrollo para Node.js. Proporciona una API para gestionar la comunicación en tiempo real entre los clientes del chat utilizando Server-Sent Events. Además, integra Adonis Lucid para la capa de acceso a datos y Adonis REPL para una interfaz interactiva de línea de comandos.

## Scripts de NPM

- `dev`: Inicia el servidor de desarrollo con reinicio automático en cambios en el código.
- `build`: Compila el proyecto para producción.
- `start`: Inicia el servidor en producción.
- `test`: Ejecuta pruebas unitarias.
- `lint`: Ejecuta ESLint para el análisis estático del código.
- `format`: Formatea el código utilizando Prettier.

## Requisitos

- Node.js
- TypeScript
- PostgreSQL

## Configuración

Asegúrate de tener Node.js y TypeScript instalados. También necesitarás configurar una base de datos PostgreSQL y ajustar la configuración en el archivo `config/database.ts`.

## Ejecución

Para ejecutar el servidor en modo de desarrollo, utiliza el siguiente comando:

```bash
npm run dev
```
```bash
npm run build
npm start
```

### Dependencias Principales
- AdonisJS Core
- Adonis Lucid
- Adonis REPL
- Socket.IO
- PostgreSQL Driver
- Source Map Support


# frontend.chat.app

Este proyecto constituye la aplicación frontend para un sistema de chat.

## Descripción

Este proyecto utiliza React como biblioteca principal para construir la interfaz de usuario de la aplicación de chat. Además, integra herramientas como Redux Toolkit para la gestión del estado de la aplicación, React Router DOM para la navegación entre páginas, y Ant Design para la interfaz de usuario con componentes predefinidos. También se incluyen otras bibliotecas como Axios para la comunicación con el backend a través de HTTP, y Socket.IO Client para la comunicación en tiempo real mediante websockets.

## Scripts de NPM

- `dev`: Inicia el servidor de desarrollo de Vite en el puerto 3000.
- `build`: Compila el proyecto utilizando TypeScript y Vite para producción.
- `lint`: Ejecuta ESLint para el análisis estático del código TypeScript y React.
- `preview`: Inicia una vista previa del proyecto compilado.

## Requisitos

- Node.js
- TypeScript

## Configuración

Asegúrate de tener Node.js instalado en tu sistema. Además, puedes ajustar la configuración del proyecto según tus necesidades en los archivos de configuración de Vite y ESLint.

## Ejecución

Para ejecutar el servidor de desarrollo, utiliza el siguiente comando:

```bash
npm run dev
```

### Dependencias Principales
- React
- React DOM
- Redux Toolkit
- Ant Design
- Axios
- React Router DOM
- Socket.IO Client
