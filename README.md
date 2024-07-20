# Visor de Puntos Máximos de Fórmula 1
Esta aplicación Java utiliza JavaFX para mostrar tablas con los puntos máximos de pilotos y constructores de Fórmula 1, obteniendo los datos desde una base de datos MySQL.

## Descripción del Código
### Clase QueryRepositorio
La clase QueryRepositorio es responsable de conectarse a la base de datos MySQL y recuperar los datos necesarios para la aplicación. Contiene dos métodos principales: getDriversMaxPoint y getConstructorsMaxPoints.

### Método getDriversMaxPoint
Este método obtiene los puntos máximos de los pilotos desde la base de datos.
![image](https://github.com/user-attachments/assets/fbad1187-eefc-4bc5-9e5b-425456a5e665)


Definición de SQL: Define la consulta SQL para obtener los nombres de los pilotos concatenados y sus puntos totales, ordenados de mayor a menor, limitando los resultados a los 10 primeros.
Conexión a la Base de Datos: Establece una conexión con la base de datos utilizando DriverManager.
Ejecución de la Consulta: Prepara y ejecuta la consulta SQL.
Recuperación de Resultados: Itera sobre los resultados y crea instancias de DriverMaxPoint con los datos recuperados.
Manejo de Excepciones: Captura y maneja cualquier excepción de SQL.

### Método getConstructorsMaxPoints
Este método obtiene los puntos máximos de los constructores desde la base de datos.
![image](https://github.com/user-attachments/assets/3c730c2f-8595-4807-b431-fe567c01e2b9)


Definición de SQL: Define la consulta SQL para obtener los nombres de los constructores y sus puntos totales, ordenados de mayor a menor, limitando los resultados a los 10 primeros.
Conexión a la Base de Datos: Establece una conexión con la base de datos utilizando DriverManager.
Ejecución de la Consulta: Prepara y ejecuta la consulta SQL.
Recuperación de Resultados: Itera sobre los resultados y crea instancias de ConstructorMaxPoint con los datos recuperados.
Manejo de Excepciones: Captura y maneja cualquier excepción de SQL.

### MaxPointTableView
Obtener Datos: Se obtienen los datos de los pilotos desde la base de datos.
Crear Tabla: Se crea una tabla (TableView) y se agregan columnas para el nombre del piloto y los puntos.
Mostrar Ventana: Se configura y muestra una ventana con la tabla de pilotos.
Obtener Datos: Se obtienen los datos de los constructores desde la base de datos.
Crear Tabla: Se crea una tabla (TableView) y se agregan columnas para el nombre del constructor y los puntos.
Mostrar Ventana: Se configura y muestra una ventana con la tabla de constructores.

## CODIGO
![image](https://github.com/user-attachments/assets/dfafda1d-3c37-437d-8f30-9970334fba27)
![image](https://github.com/user-attachments/assets/5100eabb-6b3a-4d0e-8cb5-e9ddef857972)
![image](https://github.com/user-attachments/assets/95ae5e88-2605-4684-b7ca-d2cef24aa847)
![image](https://github.com/user-attachments/assets/4a168cc8-795d-48f5-9a35-7e4b9caf170b)
![image](https://github.com/user-attachments/assets/616eb0ee-bfa5-4f58-b8ef-7e638276a1eb)
![image](https://github.com/user-attachments/assets/52a991a1-c5b9-4b8b-b9c7-096916913979)

## EJECUCION
![image](https://github.com/user-attachments/assets/484f20c4-9fb7-4098-a8a7-2e9fbfffa41f)
![image](https://github.com/user-attachments/assets/3c428772-ed15-40a2-ab5f-6093f7e551a4)
