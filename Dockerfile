# Imagen base con Java 17
FROM openjdk:17-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR al contenedor (ajusta el nombre según tu JAR final)
COPY target/LAB6_GTICS_20251_20211602-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080
EXPOSE 8080

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
