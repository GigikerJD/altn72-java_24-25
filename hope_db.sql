CREATE DATABASE hope_db;

use hope_db;

CREATE TABLE Utilisateur(
   email VARCHAR(150),
   motDePasse VARCHAR(100),
   prenom VARCHAR(100),
   nom VARCHAR(100),
   DOB DATE,
   isAdmin LOGICAL,
   isStudent LOGICAL,
   isTeacher LOGICAL,
   PRIMARY KEY(email)
);

CREATE TABLE Feedback(
   idFeedback INT,
   textFeedback VARCHAR(50),
   dateFeedback DATETIME,
   PRIMARY KEY(idFeedback)
);

CREATE TABLE Outil(
   titre VARCHAR(150),
   domaine VARCHAR(100),
   simpleDesc VARCHAR(500),
   detailledDesc VARCHAR(500),
   lienURL VARCHAR(100),
   acces VARCHAR(350),
   PRIMARY KEY(titre)
);

CREATE TABLE Consulte(
   email VARCHAR(150),
   titre VARCHAR(150),
   PRIMARY KEY(email, titre),
   FOREIGN KEY(email) REFERENCES Utilisateur(email),
   FOREIGN KEY(titre) REFERENCES Outil(titre)
);

CREATE TABLE Enveloppe(
   idFeedback INT,
   titre VARCHAR(150),
   PRIMARY KEY(idFeedback, titre),
   FOREIGN KEY(idFeedback) REFERENCES Feedback(idFeedback),
   FOREIGN KEY(titre) REFERENCES Outil(titre)
);
