# Utiliser une image OpenJDK 21
FROM openjdk:21

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR dans le répertoire de travail
COPY target/delivery-0.0.1-SNAPSHOT.jar /app/delivery-0.0.1-SNAPSHOT.jar

# Exposer le port 8080
EXPOSE 8080

# Commande pour exécuter l'application au démarrage du conteneur
CMD ["java", "-jar", "delivery-0.0.1-SNAPSHOT.jar"]