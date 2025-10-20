# 🧉 Puros Mates - Back-End (Aplicaciones Interactivas)

Este proyecto corresponde a la materia **Aplicaciones Interactivas**.  
Se trata de desarrollar el **back-end** de un e-commerce de mates, con los endpoints funcionales y testeados en **Insomnia** o **Postman**, conectados a una base de datos **MySQL**.

📌 **Importante:** en esta etapa **solo desarrollamos el back-end**.  
Más adelante se integrará un front-end y se hará una última iteración del proyecto.

---

## 📖 Descripción del Proyecto
El sistema debe permitir gestionar un e-commerce de mates.  
Se trabajará con **endpoints REST** que permitan manejar:

- **Productos**
  - Alta, baja y modificación de productos (solo admin).
  - Listado de productos.
  - Búsqueda de productos por categoría.
- **Categorías**
  - Creación y listado de categorías.
- **Usuarios**
  - Registro y login de usuarios.
  - Visualización de perfil.
- **Administradores**
  - Gestión de productos (crear, modificar, eliminar).
  - Visualización de usuarios.

Todos los endpoints deben estar **funcionales y probados** con **Insomnia o Postman**, garantizando su correcto funcionamiento.

---

## 🔗 Endpoints a definir (ejemplo inicial)

> ⚠️ Estos son tentativos, pueden ajustarse durante el desarrollo.

### Productos
- `GET /productos` → Listar todos los productos.
- `GET /productos/:id` → Obtener un producto por ID.
- `POST /productos` → Crear producto (admin).
- `PUT /productos/:id` → Editar producto (admin).
- `DELETE /productos/:id` → Eliminar producto (admin).

### Categorías
- `GET /categorias` → Listar categorías.
- `POST /categorias` → Crear categoría.

### Usuarios
- `POST /usuarios/register` → Registrar usuario.
- `POST /usuarios/login` → Login de usuario.
- `GET /usuarios/:id` → Ver perfil de usuario.

---

## 🛠️ Tecnologías
- **Lenguaje**: Java 
- **Framework Back-End**: Spring Boot (Java)
- **Base de Datos**: MySQL.
- **Herramientas de prueba de endpoints**: Postman / Insomnia.
- **Control de versiones**: Git + GitHub.
- **Comunicación y asignación de tareas**: ClickUp

---

## 🌱 Flujo de trabajo con Git

Este es el flujo de trabajo que **todos los integrantes deben seguir** para colaborar en el proyecto.  

### 🔹 Ramas principales
- `main` → Rama estable. Solo se mergea acá lo que está probado y aprobado.
- `dev` → Rama de desarrollo. Acá se integran las nuevas features antes de pasar a `main`.

### 🔹 Cómo trabajar paso a paso

1. **Clonar el repo (solo la primera vez)**
   ```bash
   git clone <URL_DEL_REPO>
   cd puros-mates-backend

2. **Cambiar a la rama dev**
    git checkout dev
    git pull

3. **Desde la rama dev, crear tu propia rama de trabajo**
    git checkout -b feature/nombre-de-la-feature

4. **Hacer tus cambios, agregar y commitear**
    git add .
    git commit -m "feat: agregar endpoint de productos"

5. **Subir tu rama el repositorio remoto**
    git push -u origin feature/nombre-de-la-feature

6. **Crear un Pull Request (PR) en GitHub**
    Desde tu rama feature/... hacia dev.
    Otro compañero revisa y aprueba antes de mergear.

**Comentarios**
Mantener tu rama actualizada: cada vez que empieces a trabajar, asegurate de traer lo último de dev a tu rama feature con git merge dev de la siguiente manera:
    git checkout dev
    git pull
    git checkout feature/mi-feature
    git merge dev


👥 Equipo
    Nicolás Blanco
    Valentin Rocca
    Mateo Leonel Gayo
    Tomas Gonzalez Humphreys
