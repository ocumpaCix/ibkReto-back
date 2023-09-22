# Utiliza una imagen base de Java para tu aplicación
FROM openjdk:11-jre-slim

# Copia el archivo JAR de la aplicación al contenedor
COPY target/conversormoneda-1.0.jar /app.jar

# Expone el puerto en el que tu aplicación Spring Boot escucha
EXPOSE 4112

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "/app.jar"]