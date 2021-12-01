# TLC Project

[[_TOC_]]

## Introduction

Ce projet présente des APIs de base permettant la **gestion de rendez-vous** entre utilisateur et professionnel (ex:
doctissimo ou rendez-vous prof-élève).

## Features importantes

Afin d’avoir plus de contrôle sur nos données, et de flexibilité sur la manière dont les traitements sont réalisés, une
attention toute particulière à été accordée à:

- la création de DTOs, pour faciliter la réception et envoie des données choisies
- la création d’une couche de service intermédiaire, entre le repository et le controller

## Prérequis

Pour la base des donnée  :

1. Démarrer docker compose avec

```bash
docker-compose up
```

2. Se connecter sur phpMyAdmin à [**localhost:8080**](localhost:8080)
3. Créer la BDD **taa_project**

## Documentation des apis - Swagger 2.0

http://localhost:8081/swagger-ui/

## Test des APIs - Postman

Le fichier [**TAA.postman_collection.json**](./TAA.postman_collection.json) ( à la racine du projet “scheduler”)
est la dernière version de notre collection Postman.

## Déploiement

1. Créer le jar et l’image docker avec le script [**packageJarAndBuildImage.cmd**](./packageJarAndBuildImage.cmd)

```bash
./packageJarAndBuildImage.cmd
```

2. Décommenter la partie **rest-api** du [**docker-compose.yml**](./docker-compose.yml) et relancer la commande

```bash
docker-compose up
```

N’oubliez pas de changer les variables d’url, d’utilisateur de de mot de passe pour la base de donnée si nécessaire.

## Points d'améliorations

### Meilleure gestion des créneaux

Le model **FreeSlots <-> créneaux de rendez-vous** est assez difficile à manipuler.  
Il aurait pu être repensé afin de mieux gérer les créneaux pour palier à certaines difficultés fonctionnelles (par
exemple le chevauchement de rendez-vous).

### La gestion des exceptions

Minimaliste, nous pourrions créer un type d’exception personnalisé ou utiliser les exceptions du framework afin de
rendre plus propre et claire.

### Programmation par aspects

Elle aurait pu être utilisée pour générer des logs sur le serveur.

### Authentification

Les ressources de l’API ne sont pas restreintes en accès aux différents rôles (professionnel / user).  
Nous aurions aussi pu rajouter un compte admin qui aurait accès à toutes les ressources de l’API.


