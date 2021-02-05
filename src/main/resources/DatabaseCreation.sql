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
    idParentEleve VARCHAR(100) NULL REFERENCES ParentEleve(idEleve),
    idClasseEleve VARCHAR(100) NULL REFERENCES ClasseEleve(idEleve),
    idMotEleve VARCHAR(100) NULL REFERENCES MotEleve(idEleve)
);

CREATE TABLE IF NOT EXISTS Parent (
    nomPrenom VARCHAR(100) NOT NULL PRIMARY KEY REFERENCES Utilisateur(nom,prenom),
    idMotParent VARCHAR(100) NULL REFERENCES MotParent(idParent),
    idParentEleve VARCHAR(100) NULL REFERENCES ParentEleve(idParent)
);

CREATE TABLE IF NOT EXISTS Devoir (
    id SERIAL NOT NULL PRIMARY KEY,
    texte TEXT,
    documents TEXT,
    liens TEXT,
    dateButoir DATETIME,
    idEleve VARCHAR(100) REFERENCES Eleve(nomPrenom),
    idEnseignant VARCHAR(100) NOT NULL REFERENCES Enseignant(nomPrenom),
    idClasse INT REFERENCES Classe(id)
);

CREATE TABLE IF NOT EXISTS Classe (
    id SERIAL NOT NULL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    idClasseEleve INT NOT NULL REFERENCES ClasseEleve(idClasse),
    idClasseEnseignant INT NOT NULL REFERENCES ClasseEnseignant(idClasse),
    idMotClasse INT NULL REFERENCES MotClasse(idClasse)
);

CREATE TABLE IF NOT EXISTS Mot (
    id SERIAL NOT NULL PRIMARY KEY,
    texte TEXT NOT NULL,
    idEnseignant VARCHAR(100) NOT NULL REFERENCES Enseignant(nomPrenom),
    idMotEleve INT NULL REFERENCES MotEleve(idMot),
    idMotParent INT NULL REFERENCES MotParent(idMot),
    idMotClasse INT NULL REFERENCES MotClasse(idMot)
);

CREATE TABLE IF NOT EXISTS Rendu (
    id SERIAL NOT NULL PRIMARY KEY,
    contenu TEXT,
    dateRendu DATETIME,
    idEleve VARCHAR(100) REFERENCES Eleve(nomPrenom),
    idDevoir INT REFERENCES Devoir(id)
);

CREATE TABLE IF NOT EXISTS MotEleve (
    id SERIAL NOT NULL PRIMARY KEY,
    idMot INT NOT NULL REFERENCES Mot(id),
    idEleve VARCHAR(100) NOT NULL REFERENCES Eleve(nomPrenom)
);

CREATE TABLE IF NOT EXISTS MotParent (
    id SERIAL NOT NULL PRIMARY KEY,
    idMot INT NOT NULL REFERENCES Mot(id),
    idParent VARCHAR(100) NOT NULL REFERENCES Parent(nomPrenom)
);

CREATE TABLE IF NOT EXISTS MotClasse (
    id SERIAL NOT NULL PRIMARY KEY,
    idMot INT NOT NULL REFERENCES Mot(id),
    idClasse INT NOT NULL REFERENCES Classe(id)
);

CREATE TABLE IF NOT EXISTS ParentEleve (
    id SERIAL NOT NULL PRIMARY KEY,
    idParent VARCHAR(100) NOT NULL REFERENCES Parent(nomPrenom),
    idEleve VARCHAR(100) NOT NULL REFERENCES Eleve(nomPrenom)
);

CREATE TABLE IF NOT EXISTS ClasseEleve (
    id SERIAL NOT NULL PRIMARY KEY,
    idClasse INT NOT NULL REFERENCES Classe(id),
    idEleve VARCHAR(100) NOT NULL REFERENCES Eleve(nomPrenom)
);

CREATE TABLE IF NOT EXISTS ClasseEnseignant (
    id SERIAL NOT NULL PRIMARY KEY,
    idClasse INT NOT NULL REFERENCES Classe(id),
    idEnseignant VARCHAR(100) NOT NULL REFERENCES Enseignant(nomPrenom)
);