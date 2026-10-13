# Microservice Stock 📦

Este repositorio contiene el **Microservicio de Stock**, encargado de la gestión integral de categorías, marcas y artículos dentro de un ecosistema de microservicios basado en una arquitectura orientada a dominios y principios de **Arquitectura Hexagonal**.

El microservicio está desarrollado bajo una estrategia de seguridad robusta basada en **Spring Security** con **JWT (JSON Web Token) sin estado (stateless)**, validando permisos y roles directamente a través del contexto del token recibido en cada petición.

![Arquitectura](microservice_stock.jfif)

---

## 🚀 Tecnologías y Versiones

* **Java:** 17
* **Spring Boot:** 3.5.3
* **Spring Cloud:** (Integración con Eureka y Gateway)
* **Spring Security & JWT:** Autenticación y Autorización sin estado.
* **Base de Datos:** MySQL (Configuración centralizada gestionada externamente).
* **Patrón de Arquitectura:** Arquitectura Hexagonal (Ports and Adapters).

---

## 🏗️ Arquitectura del Ecosistema

Este microservicio forma parte de un proyecto padre multimodular/ecosistema. Las configuraciones de conexión a base de datos y perfiles están centralizadas en el servidor de configuraciones.

El orden recomendado para levantar el ecosistema completo es el siguiente:
1. **`microservice-eureka`** (Servidor de descubrimiento de servicios)
2. **`microservice-config`** (Servidor de configuraciones centralizadas en `.yaml`)
3. **`microservice-gateway`** (Punto de entrada y enrutamiento hacia el ecosistema)
4. **`microservice-user`** (Microservicio de usuarios encargado de la autenticación y emisión de tokens JWT)
5. **Microservicios de negocio** (como este **`microservice-stock`**, transacciones, etc.)

---

## 🔒 Seguridad y Control de Accesos

El microservicio implementa una política de seguridad estricta mediante Spring Security filtrando las peticiones HTTP según los roles del usuario autenticado vía JWT.

### Tabla de Endpoints y Permisos

| Método HTTP | Ruta Endpoint | Nivel de Acceso / Permiso Requerido | Descripción |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/category/all` | `permitAll()` (Público) | Obtiene el listado de todas las categorías. |
| `GET` | `/api/brand/all` | `permitAll()` (Público) | Obtiene el listado de todas las marcas. |
| `GET` | `/api/article/all` | `permitAll()` (Público) | Obtiene el listado de todos los artículos. |
| `POST` | `/api/category/create` | Administradores (`CategoryBusinessRules.ACCESS_ROL`) | Creación de una nueva categoría. |
| `POST` | `/api/brand/create` | Administradores (`CategoryBusinessRules.ACCESS_ROL`) | Creación de una nueva marca. |
| `POST` | `/api/article/**` | `ROLE_CELLAR_ASSISTANT` | Endpoints de creación y gestión avanzados de artículos para asistentes de bodega. |

---

## 📂 Estructura Hexagonal del Proyecto

El código fuente de este microservicio está desacoplado siguiendo las capas de la arquitectura hexagonal:
* **`domain`**: Modelos de negocio puros y reglas de negocio independientes de frameworks.
* **`application`**: Casos de uso y lógica de orquestación de la aplicación.
* **`infrastructure`**: Adaptadores de entrada (Controladores REST, filtros de seguridad) y adaptadores de salida (Persistencia JPA con MySQL, repositorios).

---

## ⚙️ Configuración y Ejecución

Dado que las configuraciones de base de datos residen en el **`microservice-config`**, asegúrate de que el servidor de configuración esté activo y apuntando correctamente a tu instancia de MySQL antes de levantar este microservicio.

1. Clona el repositorio principal y asegúrate de tener Java 17 instalado.
2. Levanta los servicios base en el orden indicado en la sección de Arquitectura.
3. Compila y ejecuta el microservicio de Stock mediante Maven:
   ```bash
   ./mvnw clean spring-boot:run
   ```
## 🧩 Ecosistema de Microservicios
* [👤 Microservicio de Usuarios](https://github.com/JEMEDINAL/EMAZON-MicroService-User) - Autenticación, registro y JWT.
