/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.process;

import com.cours.entities.Animal;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cours.main.ColorComparator;
import com.cours.main.IdComparator;
import com.cours.main.NameComparator;
import com.cours.main.WeightComparator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.management.StringValueExp;
import java.util.List;

import static javax.swing.UIManager.get;

/**
 *
 * @author elhad
 */
public class ProcessAnimal implements IProcessAnimal {

    private static final Log log = LogFactory.getLog(ProcessAnimal.class);
    private List<Animal> animals = new ArrayList<>();
    private final DateFormat dateFormat = null;

    @Override
    public List<Animal> loadAnimalsManually() {
        animals.clear();
        animals.add(new Animal(1, "Lion", 200, new Date("23/12/1988"), "Maron", 4, true));
        animals.add(new Animal(2, "Elephant", 700, new Date("23/12/1978"), "Noir", 4, true));
        animals.add(new Animal(3, "Tigre", 150, new Date("23/12/1998"), "Blanc", 4, true));
        animals.add(new Animal(4, "Requin", 10, new Date("23/12/1978"), "Blanc", 0, true));
        animals.add(new Animal(5, "Chat", 5, new Date("23/12/2000"), "Noir", 4, true));
        animals.add(new Animal(6, "Mouton", 25, new Date("23/12/2001"), "Blanc", 4, false));
        animals.add(new Animal(7, "Chevre", 35, new Date("23/12/2012"), "Noir", 4, false));
        animals.add(new Animal(8, "Poule", 1, new Date("23/12/2009"), "Maron", 2, false));
        animals.add(new Animal(9, "Porc", 20, new Date("23/12/2003"), "Blanc", 4, true));
        animals.add(new Animal(10, "Singe", 25, new Date("23/12/2004"), "Noir", 4, false));
        animals.add(new Animal(11, "Giraffe", 175, new Date("23/12/2013"), "Maron et Noir", 4, false));

        return animals;
    }
    @Override
    public List<Animal> loadAnimalsFile() {
        animals.clear();
        File file = new File("animaux.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String[] animaux = st.split(",", 7);
                for(int i = 0; i < animaux.length; i++){
                    animaux[i] = animaux[i].trim();
                        System.out.println(animaux[i]);
                    }
                System.out.println("\n");

                //System.out.println(animaux);
                Animal animal = new Animal();
                //System.out.println("nouvel animal");
                animal.setIdAnimal(Integer.parseInt(animaux[0]));
                animal.setNom(animaux[1]);
                animal.setPoids(Double.parseDouble(animaux[2]));
                animal.setDateNaissance(new Date(animaux[3]));
                animal.setCouleur(animaux[4]);

                String nbpat = (animaux[5]).trim();
                int nbPattes = Integer.parseInt(nbpat);
                animal.setNombrePattes(nbPattes);
                if ("true".equals(animaux[6])) {
                    animal.setEstCarnivore(true);
                } else {
                    animal.setEstCarnivore(false);
                }
                animals.add(animal);
                //System.out.println("animal par animal" + animal + "\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProcessAnimal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProcessAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(" taille " + animals.size());
        return animals;
    }

    @Override
    public Double calculMoyennePoidsAnimaux() {
        animals = loadAnimalsFile();
        int sizeAnimalsList = animals.size();
        double sumPoids = 0.0;

        for (Animal ani : animals) {
            double poids = ani.getPoids();
            sumPoids += poids;
        }
        double total = sumPoids / sizeAnimalsList;
        return total;
    }

      @Override
    public Double calculEcartTypePoidsAnimaux() {
        animals = loadAnimalsFile();
        int animalSize = animals.size();
        double moyenne = calculMoyennePoidsAnimaux();
        double ecart = 0.0;
        double sumEcartMoyen = 0.0;
        double ecartAuCarre;
        double result;

        for (Animal ani : animals) {
            double poids = ani.getPoids();
            if (poids > moyenne) {
                ecart = poids - moyenne;
            } else if (poids < moyenne) {
                ecart = (moyenne - poids);
            }
            ecartAuCarre = ecart * ecart;
            sumEcartMoyen += ecartAuCarre;
        }
        result = (sumEcartMoyen / animalSize);
        result = Math.sqrt(result);
        return result;
    }


    @Override
    public List<Animal> sortAnimalsById() {
        animals = loadAnimalsFile();
        Collections.sort(animals, new IdComparator());
        return animals;
    }

    @Override
    public List<Animal> sortAnimalsByName() {
        animals = loadAnimalsFile();
        Collections.sort(animals, new NameComparator());
        return animals;
    }

    @Override
    public List<Animal> sortAnimalsByWeight() {
        animals = loadAnimalsFile();
        Collections.sort(animals, new WeightComparator());
        return animals;
    }

    @Override
    public List<Animal> sortAnimalsByColor() {
        animals = loadAnimalsFile();
        Collections.sort(animals, new ColorComparator());
        return animals;
    }

    @Override
    public void generateFileByName() throws IOException {

        List<Animal> animals = sortAnimalsByName();

        FileWriter fichier = null;
        try {
            fichier = new FileWriter("animauxParNom.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        toFile(animals, fichier);

    }

    private void toFile(List<Animal> animals, FileWriter fichier) throws IOException {
        String str = "";
        for(Animal animal : animals){

            String idAnimal = Integer.toString(animal.getIdAnimal());
            str += idAnimal + ", ";
            String nom = animal.getNom();
            str += nom + ", ";
            String poids = Double.toString((animal.getPoids()));
            str += poids + ", ";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dateNaissance = sdf.format(animal.getDateNaissance());
            str += dateNaissance + ", ";
            String couleur = animal.getCouleur();
            str += couleur + ", ";
            String pattes = Integer.toString(animal.getNombrePattes());
            str += pattes + ", ";
            String isCarnivore = Boolean.toString(animal.isEstCarnivore());
            str += isCarnivore;
            str += "\n";
        }
        fichier.write (str);
        fichier.close();
    }

    @Override
    public void generateFileByWeight() throws IOException {
        List<Animal> animals = sortAnimalsByWeight();

        FileWriter fichier = null;
        try {
            fichier = new FileWriter("animauxParPoids.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        toFile(animals, fichier);
    }

    @Override
    public List<Animal> getAnimals() {
        return animals;
    }
}
