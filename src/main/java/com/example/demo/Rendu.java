package com.example.demo;

import org.w3c.dom.Text;

import java.sql.Date;
import java.util.ArrayList;

public class Rendu {
    private Text contenu;
    private Date dateRendu;

    private Eleve eleve;
    private Devoir devoir;

    public Rendu(Text contenu, Date dateRendu)
    {
        this.contenu = contenu;
        this.dateRendu = dateRendu;
    }

    public String toString() {
        return devoir.toString() + " // Devoir " + contenu + " rendu le : " + dateRendu;
    }

    public Text getContenu()
    {
        return contenu;
    }

    public Date getDateRendu()
    {
        return dateRendu;
    }

    public Eleve getEleve()
    {
        return eleve;
    }

    public Devoir getDevoir()
    {
        return devoir;
    }

    public void setContenu(Text _contenu)
    {
        this.contenu = _contenu;
    }

    public void setDateRendu(Date _dateRendu)
    {
        this.dateRendu = _dateRendu;
    }

    public void setEleve(Eleve _eleve)
    {
        this.eleve = _eleve;
    }

    public void setDevoir(Devoir _devoir)
    {
        this.devoir = _devoir;
    }
}
