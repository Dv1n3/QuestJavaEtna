/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.entities;

import java.util.Date;

/**
 *
 * @author elhad
 */
public class Animal {
    public int idAnimal;
    
    public String nom;
    
    public double poids;
    
    public java.util.Date dateNaissance;
    
    public String couleur;
    
    public int nombrePattes;
    
    public boolean estCarnivore;

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getNombrePattes() {
        return nombrePattes;
    }

    public void setNombrePattes(int nombrePattes) {
        this.nombrePattes = nombrePattes;
    }

    public boolean isEstCarnivore() {
        return estCarnivore;
    }

    public Animal() {
    }

    public void setEstCarnivore(boolean estCarnivore) {
        this.estCarnivore = estCarnivore;
    }
    
    
    public void marcher(){
        System.out.println("L'animal " + this.getNom() + " marche avec "+ this.getNombrePattes() + " pattes");
    }
    
    public void description(){
        String str = "est carnivore";
        
        if(this.estCarnivore == false){
            str = "n'est pas carnivore";
        }

        System.out.println("L'animal " + this.getNom() + " est né le " + this.getDateNaissance() + ", il pèse " + this.getPoids()
                + ", il est de couleur " + this.getCouleur() + ", il a " + this.getNombrePattes() + " pattes, il " + str + ".");
    }

    public Animal(int idAnimal, String nom, double poids, Date dateNaissance, String couleur, int nombrePattes, boolean estCarnivore) {
        this.idAnimal = idAnimal;
        this.nom = nom;
        this.poids = poids;
        this.dateNaissance = dateNaissance;
        this.couleur = couleur;
        this.nombrePattes = nombrePattes;
        this.estCarnivore = estCarnivore;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idAnimal;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.idAnimal != other.idAnimal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "idAnimal=" + idAnimal + ", nom=" + nom + ", poids=" + poids + ", dateNaissance=" + dateNaissance + ", couleur=" + couleur + ", nombrePattes=" + nombrePattes + ", estCarnivore=" + estCarnivore + '}';
    }


    
}
