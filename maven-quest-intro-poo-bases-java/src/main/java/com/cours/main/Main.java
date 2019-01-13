/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.main;

import com.cours.calcul.Calculation;
import com.cours.calcul.ICalculation;
import com.cours.entities.Animal;
import com.cours.process.IProcessAnimal;
import com.cours.process.ProcessAnimal;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class Main {

    private static final Log log = LogFactory.getLog(Main.class);
    private static ICalculation calculation = null;
    private static IProcessAnimal processAnimal = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProcessAnimal pA = new ProcessAnimal();
        System.out.println("Calcul de la moyenne --------> " + pA.calculMoyennePoidsAnimaux());
        System.out.println("Calcul de l'ecart type--------> " + pA.calculEcartTypePoidsAnimaux());
        System.out.println("liste des animaux par id --------> " + pA.sortAnimalsById());
        System.out.println("liste des animaux par nom --------> " + pA.sortAnimalsByName());
        System.out.println("liste des animaux par couleur--------> " + pA.sortAnimalsByColor());
        System.out.println("liste des animaux par poids--------> " + pA.sortAnimalsByWeight());
        try {
            pA.generateFileByName();
            pA.generateFileByWeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //int i = calculation.compareChaines("maronetnoir", "maron");
        //System.out.println(animals);
        //testNombreMagique();
        //ProcessAnimal.testProcessAnimal();
        //pA.loadAnimalsFile();
        //System.out.println(list);
        /*int t = pA.loadAnimalsFile().size();
        System.out.println(t);*/
        //double t = pA.calculEcartTypePoidsAnimaux();
        //List<Animal> animals = pA.sortAnimalsByColor();
        //System.out.println(t);

        //System.out.println(animals);
        //pA.calculEcartTypePoidsAnimaux();
        // TODO code application logic here
        //testVerifyParite();
        //testCompareChaines();
         //testFactorielItterative();
         //testFactorielRecursive();
         //testSortMyArray();
         //testProcessAnimal();
    }

    public static void testVerifyParite() {
        Calculation calculation = new Calculation();
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un nombre entier: ");
        String str = sc.nextLine();
        calculation.verifyParite(str);
    }

    public static void testCompareChaines() {
        Calculation calculation = new Calculation();
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez une chaine de charactères: ");
        String str1 = sc.nextLine();
        System.out.println("Entrez une deuxième chaine de charactères: ");
        String str2 = sc.nextLine();
        calculation.compareChaines(str1, str2);
    }

    /**
     * Attention pour simplifier l'exercice on ne mettre que de petit nombre
     * entier inferieur à 17. Sinon on risque de depasser la limite prévu pour
     * le type int. Vous pouvez donc utiliser le type entier int.
     */
    public static void testFactorielItterative() {
        Calculation calculation = new Calculation();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Entrez un chiffre entre 0 et 16: ");
        int inputNb = Integer.parseInt(sc.nextLine());
        int result = calculation.factorielItterative(inputNb);
        System.out.println(result);
    }

    /**
     * Attention pour simplifier l'exercice on ne mettre que de petit nombre
     * entier inferieur à 17. Sinon on risque de depasser la limite prévu pour
     * le type int. Vous pouvez donc utiliser le type entier int.
     */
    public static void testFactorielRecursive() {
        Calculation calculation = new Calculation();
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un chiffre entre 0 et 16: ");
        int inputNb = Integer.parseInt(sc.nextLine());
        int result = calculation.factorielRecursive(inputNb);
        System.out.println(result);
    }

    public static void testNombreMagique() {
        Calculation calculation = new Calculation();
        int[] tab = calculation.initMyArray(100);
        calculation.sortMyArray(tab);
    }

    public static void testSortMyArray() {
        Calculation calculation = new Calculation();
        int[] tab = calculation.initMyArray(100);
        calculation.sortMyArray(tab);
    }

    public static void testProcessAnimal() {
        processAnimal.loadAnimalsManually();
        processAnimal.loadAnimalsFile();
        processAnimal.calculMoyennePoidsAnimaux();
        processAnimal.calculEcartTypePoidsAnimaux();
    }
}
