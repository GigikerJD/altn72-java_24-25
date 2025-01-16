CREATE DATABASE hope_db;

use hope_db;

CREATE TABLE Utilisateur(
   email VARCHAR(150),
   pseudo VARCHAR(100),
   motDePasse VARCHAR(100),
   prenom VARCHAR(100),
   nom VARCHAR(100),
   genre VARCHAR(10),
   statut VARCHAR(50)
   DOB DATE,
   nombreFeedbacks INT,
   PRIMARY KEY(email, pseudo)
);

CREATE TABLE Feedback(
   idFeedback VARCHAR(100),
   textFeedback VARCHAR(500),
   dateFeedback DATETIME,
   pseudoUser VARCHAR(100),
   PRIMARY KEY(idFeedback)
);

CREATE TABLE Outil(
   titre VARCHAR(150),
   domaine VARCHAR(100),
   simpleDesc VARCHAR(500),
   detailledDesc VARCHAR(5000),
   lienURL VARCHAR(1000),
   acces VARCHAR(350),
   PRIMARY KEY(titre)
);

CREATE TABLE Consulte(
   email VARCHAR(150),
   pseudo VARCHAR(100),
   titre VARCHAR(150),
   PRIMARY KEY(email, pseudo, titre),
   FOREIGN KEY(email, pseudo) REFERENCES Utilisateur(email, pseudo),
   FOREIGN KEY(titre) REFERENCES Outil(titre)
);

CREATE TABLE Enveloppe(
   idFeedback VARCHAR(100),
   titre VARCHAR(150),
   PRIMARY KEY(idFeedback, titre),
   FOREIGN KEY(idFeedback) REFERENCES Feedback(idFeedback),
   FOREIGN KEY(titre) REFERENCES Outil(titre)
);