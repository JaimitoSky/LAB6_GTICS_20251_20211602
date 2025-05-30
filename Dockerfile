# Imagen base con Java 17
FROM openjdk:17-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

COPY target/gtics_lab_6-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto donde corre la app
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
