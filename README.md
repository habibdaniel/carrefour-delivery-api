
## Resolution
Pour implémenter la solution, j'ai mis en place:
- la partie entitée avec la création de 4 entitées(Delivery,Order,role,user)
- la partie sécurité avec la mise en place de Spring security et jwt (package security)
- la mise en du dockerfile pour l'exécution dans un conteneur docker
- Utilisation de H2 avec persistance dans un fichier data/db
- une capture du mcd nommé mcd.png se trouve à la racine du projet
## Build

The application can be built using the following command:

```
mvnw clean package
```

```
java  -jar ./target/delivery-0.0.1-SNAPSHOT.jar
```

If required, a Docker image can be created with the Spring Boot plugin.

```
mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=com.carrefour/delivery
```
