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
