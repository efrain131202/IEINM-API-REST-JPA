# Endpoints de Alumnos

## Configuración de Acceso
- **Puerto:** 7676
- **Bases de URL:**
  - Local: `http://localhost:7676`

## 1. Listar Alumnos
- **Método:** GET
- **Ruta:** `/alumnos/listar`
- **Descripción:** Recupera todos los alumnos registrados
- **Ejemplo Postman:**
  - Método: GET
  - URL: `http://localhost:7676/alumnos/listar`

## 2. Obtener Alumno por ID
- **Método:** GET
- **Ruta:** `/alumnos/{id}`
- **Descripción:** Recupera un alumno específico por su identificador
- **Ejemplo Postman:**
  - Método: GET
  - URL: `http://localhost:7676/alumnos/1`

## 3. Crear Alumno
- **Método:** POST
- **Ruta:** `/alumnos`
- **Descripción:** Registra un nuevo alumno
- **Ejemplo Body JSON:**
```json
{
  "nombre": "Juan Pérez",
  "edad": 20
}
```
- **Ejemplo Postman:**
  - Método: POST
  - URL: `http://localhost:7676/alumnos`
  - Body: Raw JSON

## 4. Actualizar Alumno
- **Método:** PUT
- **Ruta:** `/alumnos/{id}`
- **Descripción:** Modifica los datos de un alumno existente
- **Ejemplo Body JSON:**
```json
{
  "nombre": "Juan Martínez", 
  "edad": 21
}
```
- **Ejemplo Postman:**
  - Método: PUT
  - URL: `http://localhost:7676/alumnos/1`
  - Body: Raw JSON

## 5. Eliminar Alumno
- **Método:** DELETE
- **Ruta:** `/alumnos/{id}`
- **Descripción:** Elimina un alumno de la base de datos
- **Ejemplo Postman:**
  - Método: DELETE
  - URL: `http://localhost:7676/alumnos/1`
