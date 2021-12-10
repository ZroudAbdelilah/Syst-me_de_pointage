# Syst-me_de_pointage

Project context
ForAcademy est une fabrique de reconversion et insertion professionnelle, son but principal est de former les étudiant dans le domaine de IT. ForAcademy veut numériser son système de pointage , pour cela il demande votre expertise pour mettre en place une application desktop. Cette dernière offre la possibilité de visualiser et recapitulariser le taux de présence de chaque acteur (chef fabrique, étudiants, formateurs, secrétaire) et de gérer les évenements de l'academy.

votre tache en tant que développeur Full Stack Java est participé au développement de l'application. votre première mission est collaboré avec l'équipe et développé l'application en mode console avant de toucher la partie interface avec javaFx.

A partir de l’application, après l'authentification l’administrateur doit pouvoir gérer les :

​

Spécialité
Utilisateurs (de type Etudiant ou Formateur)
Pointages des utilisateurs(Etudiant, Formateur, Secrétaire ou chef de fabrique)
Mots de passe
Les journaux d’événements (ajout, modification, suppression et date de l'événement) effectués par les différents acteurs de votre application.
Promotion
Classe
​

Un chef de fabrique et secrétaire sont caractérisés par : son nom ,prénom, adresse, numéro de téléphone, email, mot de passe, date d'entrée à la fabrique

​

Un étudiant est caractérisé par : son nom , prénom, adresse, numéro de téléphone, email, mot de passe, sa promotion et sa classe, leur spécialité.

​

Un Formateur est caractérisé par : son nom ,prénom, adresse, numéro de téléphone, email, mot de passe, spécialité, la classe et la liste de ses étudiants.

​

Une promotion est caractérisée par: nom, année, date début , date de fin, effectif total d’étudiants, nombre de filles, nombre de garçons.

​

Une classe est caractérisée par: nom, horaire de début de journée, horaire de fin de journée, et effectif d’étudiants

​

Un pointage sera déterminé par: heure d'arrivée, heure de départ, et l’utilisateur

​

Les administrateurs peuvent changer leurs propres mot de passe ainsi que celui de chaque utilisateur et désactiver les comptes de chaque utilisateur.

​

Un utilisateur simple ne peut changer que son propre mot de passe.

Un utilisateur ne fait son pointage que deux (2) fois par jour et par conséquent ne peut accéder qu'à ses propres données de pointages.

​

Un administrateur et chef de fabrique ont accès aux données de pointages de tous les utilisateurs (de manière individuel et en groupe par promotion) et peut télécharger les données de pointages aux formats de fichier (Excel et PDF) - Bonus 😉.

​

L’utilisateur de l’application se connecte tant que : administrateur, secrétaire, formateur, étuduants, chef de fabrique.

​

Chef de fabrique aura le droit créer un secrétaire, formateur, et évenement .

​

Secrétaire aura le droit de créer un étudiant, classe et spécialité, et aussi accepter les évenements proposés par les étudiants ou formateur

​

Contrainte :

​

- Utiliser Maven.

- Utiliser DAO Design Pattern.

- Utiliser JDBC

- Base de données MySQL or Postgress

Procédure :

- Utiliser JIRA SOFTWARE pour établir USER STORY MAP du projet.

- Proposez un diagramme de classes

- Concevoir et implémenter les fonctionnalités coté Backend