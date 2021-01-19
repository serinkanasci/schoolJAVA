package com.example.demo;

public class Utilisateur {

    private String nom;
    private String prenom;
    private String login;
    private String motDePasse;


    public Utilisateur(String nom, String prenom, String login, String motDePasse)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.motDePasse = motDePasse;
    }

    public String getToString() {
        return "Nom : " + nom + " Prenom : " + prenom + " Login : " + login + " Mot de passe : " + motDePasse;
    }

    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public String getLogin()
    {
        return login;
    }
    public String getMotDePasse()
    {
        return motDePasse;
    }

    public void setNom(String _nom)
    {
        this.nom = _nom;
    }

    public void setPrenom(String _prenom)
    {
        this.prenom = _prenom;
    }

    public void setLogin(String _login)
    {
        this.login = _login;
    }

    public void setMotDePasse(String _motDePasse)
    {
        this.motDePasse = _motDePasse;
    }

}
