DROP DATABASE Ecole;  
CREATE DATABASE Ecole;
USE Ecole;

CREATE TABLE IF NOT EXISTS Utilisateur (
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    login VARCHAR(50) NOT NULL,
    motDePasse VARCHAR(50) NOT NULL,
    PRIMARY KEY (nom, prenom)
);

CREATE TABLE IF NOT EXISTS Enseignant(
    nomPrenom VARCHAR(100) NOT NULL PRIMARY KEY REFERENCES Utilisateur(nom,prenom)
);

CREATE TABLE IF NOT EXISTS Eleve(
    nomPrenom VARCHAR(100) NOT NULL PRIMARY KEY REFERENCES Utilisateur(nom,prenom),
    idParentEleve INT NULL REFERENCES ParentEleve(id),
    idClasseEleve INT NULL REFERENCES ClasseEleve(id),
    idMotEleve INT NULL REFERENCES MotEleve(id)
);

CREATE TABLE IF NOT EXISTS Parent (
    nomPrenom VARCHAR(100) NOT NULL PRIMARY KEY REFERENCES Utilisateur(nom,prenom),
    idMotParent INT NULL REFERENCES MotParent(id),
    idParentEleve INT NULL REFERENCES ParentEleve(id)
);

CREATE TABLE IF NOT EXISTS Devoir (
    id AUTO_INCREMENT NOT NULL PRIMARY KEY,
    texte TEXT,
    documents TEXT,
    liens TEXT,
    dateButoir DATETIME,
    idEleve VARCHAR(100) REFERENCES Eleve(nomPrenom),
    idEnseignant VARCHAR(100) NOT NULL REFERENCES Enseignant(nomPrenom),
    idClasse INT REFERENCES Classe(id)
);

CREATE TABLE IF NOT EXISTS Classe (
    id AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    idClasseEleve INT NOT NULL REFERENCES ClasseEleve(id),
    idClasseEnseignant INT NOT NULL REFERENCES ClasseEnseignant(id),
    idMotClasse INT NULL REFERENCES MotClasse(id)
);

CREATE TABLE IF NOT EXISTS Mot (
    id AUTO_INCREMENT NOT NULL PRIMARY KEY,
    texte TEXT NOT NULL,
    idEnseignant VARCHAR(100) NOT NULL REFERENCES Enseignant(nomPrenom),
    idMotEleve INT NULL REFERENCES MotEleve(id),
    idMotParent INT NULL REFERENCES MotParent(id),
    idMotClasse INT NULL REFERENCES MotClasse(id)
);

CREATE TABLE IF NOT EXISTS Rendu (
    id AUTO_INCREMENT NOT NULL PRIMARY KEY,
    contenu TEXT,
    dateRendu DATETIME,
    idEleve VARCHAR(100) REFERENCES Eleve(nomPrenom),
    idDevoir INT REFERENCES Devoir(id)
);

CREATE TABLE IF NOT EXISTS MotEleve (
    id AUTO_INCREMENT NOT NULL PRIMARY KEY,
    idMot INT NOT NULL REFERENCES Mot(id),
    idEleve VARCHAR(100) NOT NULL REFERENCES Eleve(nomPrenom)
);

CREATE TABLE IF NOT EXISTS MotParent (
    id AUTO_INCREMENT NOT NULL PRIMARY KEY,
    idMot INT NOT NULL REFERENCES Mot(id),
    idParent VARCHAR(100) NOT NULL REFERENCES Parent(nomPrenom)
);

CREATE TABLE IF NOT EXISTS MotClasse (
    id AUTO_INCREMENT NOT NULL PRIMARY KEY,
    idMot INT NOT NULL REFERENCES Mot(id),
    idClasse INT NOT NULL REFERENCES Classe(id)
);

CREATE TABLE IF NOT EXISTS ParentEleve (
    id AUTO_INCREMENT NOT NULL PRIMARY KEY,
    idParent VARCHAR(100) NOT NULL REFERENCES Parent(nomPrenom),
    idEleve VARCHAR(100) NOT NULL REFERENCES Eleve(nomPrenom)
);

CREATE TABLE IF NOT EXISTS ClasseEleve (
    id AUTO_INCREMENT NOT NULL PRIMARY KEY,
    idClasse INT NOT NULL REFERENCES Classe(id),
    idEleve VARCHAR(100) NOT NULL REFERENCES Eleve(nomPrenom)
);

CREATE TABLE IF NOT EXISTS ClasseEnseignant (
    id AUTO_INCREMENT NOT NULL PRIMARY KEY,
    idClasse INT NOT NULL REFERENCES Classe(id),
    idEnseignant VARCHAR(100) NOT NULL REFERENCES Enseignant(nomPrenom)
);
INSERT INTO Utilisateur(nom, prenom, login, motDePasse)
VALUES ('lo','az', 'Tezst','fds'), ('gt','yt', 'fdsfs','fsdfsd'),
('ds','fd', 'jytj','drfhger'), ('df','gf', 'fzert','razezeaz');

INSERT INTO Parent(nomPrenom, idMotParent, idParentEleve)
VALUES ('dfgf',null, null), ('dsfd',null, null);


INSERT INTO Eleve(idParent, nomPrenom, idParentEleve, idClasseEleve, idMotEleve)
VALUES ('dsfd' ,'loaz', null, null, null), ('dfgf','gtyt', null, null, null);

/*
INSERT INTO Ensignant(id, libelle, coach_nom) 
VALUES (1,'Coaching Standard', 'Dupond'), (2,'Coaching Fitness', 'Duchamp');

INSERT INTO Parent(id, libelle, id_cours) 
VALUES (1,'Remise en forme', 1), (2,'Perdre du poids', 1), (3, 'Gain de masse musculaire', 2);


INSERT INTO Classe(id, libelle, id_cours) 
VALUES (1,'Remise en forme', 1), (2,'Perdre du poids', 1), (3, 'Gain de masse musculaire', 2);
*/
INSERT INTO Utilisateur(nom, prenom, login, motDePasse)
VALUES ('Plaisant','Patrick','PPlaisant','0000');

INSERT INTO Enseignant(nomprenom)
VALUES ('PlaisantPatrick');

SELECT * FROM Enseignant;
SELECT * FROM Eleve;
SELECT * FROM Parent;



/*INSERT INTO user_details (id, weight, height)
     VALUES ((SELECT id FROM user WHERE name='John Smith'), 83, 185);*/