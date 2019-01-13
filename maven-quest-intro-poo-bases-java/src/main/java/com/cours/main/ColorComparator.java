package com.cours.main;

import com.cours.calcul.Calculation;
import com.cours.entities.Animal;

import java.util.Comparator;

public class ColorComparator implements Comparator<Animal> {

    public int compare(Animal animal1, Animal animal2) {
        Calculation calc = new Calculation();
        //System.out.println(animal1.getCouleur());
        return calc.compareChaines(animal1.getCouleur(), animal2.getCouleur());
    }
}