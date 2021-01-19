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
    id serial NOT NULL PRIMARY KEY,
    nomPrenom VARCHAR(100) NOT NULL REFERENCES Utilisateur(nom,prenom)
);

CREATE TABLE IF NOT EXISTS Eleve(
    id serial NOT NULL PRIMARY KEY,
    idParent INT REFERENCES Parent(id),
    nomPrenom VARCHAR(100) NOT NULL REFERENCES Utilisateur(nom,prenom),
    idParentEleve INT NULL REFERENCES ParentEleve(id),
    idClasseEleve INT NULL REFERENCES ClasseEleve(id),
    idMotEleve INT NULL REFERENCES MotEleve(id)
);

CREATE TABLE IF NOT EXISTS Parent (
    id SERIAL NOT NULL PRIMARY KEY,
    nomPrenom VARCHAR(100) NOT NULL REFERENCES Utilisateur(nom,prenom),
    idMotParent INT NULL REFERENCES MotParent(id),
    idParentEleve INT NULL REFERENCES ParentEleve(id)
);

CREATE TABLE IF NOT EXISTS Devoir (
    id SERIAL NOT NULL PRIMARY KEY,
    texte TEXT,
    documents TEXT,
    liens TEXT,
    dateButoir DATETIME,
    idEleve INT REFERENCES Eleve(id),
    idEnseignant INT NOT NULL REFERENCES Enseignant(id),
    idClasse INT REFERENCES Classe(id)
);

CREATE TABLE IF NOT EXISTS Classe (
    id SERIAL NOT NULL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    idClasseEleve INT NOT NULL REFERENCES ClasseEleve(id),
    idClasseEnseignant INT NOT NULL REFERENCES ClasseEnseignant(id),
    idMotClasse INT NULL REFERENCES MotClasse(id)
);

CREATE TABLE IF NOT EXISTS Mot (
    id SERIAL NOT NULL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    nbEleves INT NULL,
    idEnseignant INT NOT NULL REFERENCES Enseignant(id),
    idMotEleve INT NULL REFERENCES MotEleve(id),
    idMotParent INT NULL REFERENCES MotParent(id),
    idMotClasse INT NULL REFERENCES MotClasse(id)
);

CREATE TABLE IF NOT EXISTS MotEleve (
    id SERIAL NOT NULL PRIMARY KEY,
    idMot INT NOT NULL REFERENCES Mot(id),
    idEleve INT NOT NULL REFERENCES Eleve(id)
);

CREATE TABLE IF NOT EXISTS MotParent (
    id SERIAL NOT NULL PRIMARY KEY,
    idMot INT NOT NULL REFERENCES Mot(id),
    idParent INT NOT NULL REFERENCES Parent(id)
);

CREATE TABLE IF NOT EXISTS MotClasse (
    id SERIAL NOT NULL PRIMARY KEY,
    idMot INT NOT NULL REFERENCES Mot(id),
    idClasse INT NOT NULL REFERENCES Classe(id)
);

CREATE TABLE IF NOT EXISTS ParentEleve (
    id SERIAL NOT NULL PRIMARY KEY,
    idParent INT NOT NULL REFERENCES Parent(id),
    idEleve INT NOT NULL REFERENCES Eleve(id)
);

CREATE TABLE IF NOT EXISTS ClasseEleve (
    id SERIAL NOT NULL PRIMARY KEY,
    idClasse INT NOT NULL REFERENCES Classe(id),
    idEleve INT NOT NULL REFERENCES Eleve(id)
);

CREATE TABLE IF NOT EXISTS ClasseEnseignant (
    id SERIAL NOT NULL PRIMARY KEY,
    idClasse INT NOT NULL REFERENCES Classe(id),
    idEnseignant INT NOT NULL REFERENCES Enseignant(id)
);

/*


INSERT INTO Utilisateur(nom, prenom, login, motDePasse)
VALUES ('eazaezae','etrzt', 'Tezst','fds'), ('fdsfsdf','sfddssdfsd', 'fdsfs','fsdfsd'),
       ('fdsfsdfezrez','rfgjtyj', 'jytj','drfhger'), ('luiltyu','aezaetgf', 'fzert','razezeaz');

INSERT INTO Eleve(idParent, nomPrenom, idParentEleve, idClasseEleve, idMotEleve)
VALUES (null ,'eazaezaeetrzt', null, null, null), (null,'fdsfsdfsfddssdfsd', null, null, null);

*/



/*
EXEMPLE POUR PLUS TARD
INSERT INTO user_details (id, weight, height)
     VALUES ((SELECT id FROM user WHERE name='John Smith'), 83, 185);

*/
