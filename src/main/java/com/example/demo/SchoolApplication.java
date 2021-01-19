package com.example.demo;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.BeanFactory;
import java.util.Properties;
import java.sql.*;
import java.io.FileInputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class SchoolApplication {

    public static void main(String[] args) {

        Properties props = new Properties();
        try(FileInputStream fis = new FileInputStream("demo\\conf.properties")) {
            props.load(fis);
        } catch (Exception e) {
            System.out.println(e);
        }
        // CREATION DE LA CONNEXION
        Connection conn = null;
        try {
            Class.forName(props.getProperty("jdbc.driver.class"));
            String url = props.getProperty("jdbc.url");
            String login = props.getProperty("jdbc.login");
            String password = props.getProperty("jdbc.password");
            String serverTimezone = props.getProperty("jdbc.serverTimezone");
            String connURL = url + "?user=" + login + "&password=" + password + "&serverTimezone=" + serverTimezone;
            conn = DriverManager.getConnection(connURL);
            System.out.println("Database connection established");
        } catch (Exception e) {
            System.out.println(e);
        }

        // RECUPERATION DES BEANS CREER DANS LE XML
        Resource r = new ClassPathResource("applicationContext.xml");
        BeanFactory fac = new XmlBeanFactory(r);

        Classe classe1 = (Classe)fac.getBean("Classe1");
        Classe classe2 = (Classe)fac.getBean("Classe2");

        Enseignant prof1 = (Enseignant)fac.getBean("Enseignant1");
        Enseignant prof2 = (Enseignant)fac.getBean("Enseignant2");

        Parent parent1 = (Parent)fac.getBean("Parent1");
        Parent parent2 = (Parent)fac.getBean("Parent2");
        Parent parent3 = (Parent)fac.getBean("Parent3");

        Eleve eleve1 = (Eleve)fac.getBean("Eleve1");
        Eleve eleve2 = (Eleve)fac.getBean("Eleve2");
        Eleve eleve3 = (Eleve)fac.getBean("Eleve3");

        eleve1.addParent(parent1);
        eleve1.addParent(parent2);
        eleve1.addClasse(classe1);

        eleve2.addParent(parent1);
        eleve2.addParent(parent2);
        eleve2.addClasse(classe2);

        eleve3.addParent(parent3);
        eleve3.addClasse(classe2);

        parent1.addEleve(eleve1);
        parent1.addEleve(eleve2);

        parent2.addEleve(eleve1);
        parent2.addEleve(eleve2);

        parent3.addEleve(eleve3);

        prof1.addClasse(classe1);

        prof2.addClasse(classe2);

        System.out.println(prof1.toString());
        System.out.println(prof2.toString());

        System.out.println(parent1.toString());
        System.out.println(parent2.toString());
        System.out.println(parent3.toString());

        System.out.println(eleve1.toString());
        System.out.println(eleve2.toString());
        System.out.println(eleve3.toString());

        System.out.println(classe1.toString());
        System.out.println(classe2.toString());

        /* Classe CM1 = new Classe("CM1 A");
        Classe CP = new Classe("CP A");
        Enseignant prof1 = new Enseignant("Jean", "Louis", "JLouis", "0000");
        Enseignant prof2 = new Enseignant("Jean", "Fonsi", "JFonsi", "0000");

        Parent parent1 = new Parent("Marc", "Dupond", "MDupond", "0000");
        Parent parent2 = new Parent("Louise", "Dupond", "LDupond", "0000");
        Parent parent3 = new Parent("Samantha", "Depardieu", "SDepardieu", "0000");

        Eleve eleve1 = new Eleve("Gabriel", "Dupond", "GDupond", "0000");
        Eleve eleve2 = new Eleve("Gabrielle", "Dupond", "GaDupond", "0000");
        Eleve eleve3 = new Eleve("Franck", "Depardieu", "FDepardieu", "0000");
        */


        //SpringApplication.run(SchoolApplication.class, args);

    }

}
