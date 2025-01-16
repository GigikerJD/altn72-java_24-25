Outils & technologies utilisées :

IDE : Visual Studio Code
      Pour une meilleure expérience avec l'application, installez l'extension Spring Boot Extension Pack, utile pour générer nos projets, build et exécuter ces derniers.
      Une interface a été conçue pour afficher tous nos Beans et Endpoints

SBGD : MariaDB 11.6

Dépendences implémentées :

Lombok :
Lombok est une bibliothèque qui permet de simplifier l'écriture du code en réduisant le code boilerplate. 
Par exemple, elle génère automatiquement des getters, setters, constructeurs, méthodes equals, hashCode, et toString via des annotations. 
Cela améliore la lisibilité et la maintenabilité du code.

MariaDB Driver :
Ce pilote est utilisé pour permettre à votre application Java de se connecter à une base de données MariaDB. 
Il fournit les outils nécessaires pour exécuter des requêtes SQL et interagir avec la base de données.

Spring Data JPA :
Spring Data JPA simplifie l'accès à la base de données en offrant un framework basé sur JPA (Java Persistence API). 
Il permet de gérer les entités et leurs relations, tout en facilitant la création des repositories grâce à des interfaces et des méthodes prêtes à l'emploi.

Spring Web :
Spring Web est une dépendance de Spring Boot qui permet de créer des applications web, y compris des API RESTful. 
Elle intègre des fonctionnalités pour la gestion des requêtes HTTP, des contrôleurs, et des vues.

Thymeleaf :
Thymeleaf est un moteur de templates qui permet de générer dynamiquement du contenu HTML. 
Il est souvent utilisé pour construire des interfaces utilisateur, avec une intégration fluide des données provenant du backend.

NB : Le dossier config contient 2 classes qui nous permet de générer le Swagger de notre application et 
     l'autre qui nous permet de désactiver la sécurité lors de la dépendance de hashage qui nous servira à hasher nos mots de passe.

Spring Boot DevTools :
Spring Boot DevTools est une dépendance qui améliore l'expérience de développement en activant le rechargement automatique des changements de code. 
Cela permet d'accélérer les cycles de développement et de tester les modifications en temps réel sans redémarrer l'application.

Les jeux de login et mot de passe se pratiquent avec le pseudo et mot de passe de tout utilisateur, dans notre base de données, les mots de passe sont hashés 
afin de ne pas connaître le vrai mot de passe pour une meilleure sécurité lors d'une injection SQL extérieure
