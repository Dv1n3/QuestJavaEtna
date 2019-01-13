package com.cours.main;

import com.cours.calcul.Calculation;
import com.cours.entities.Animal;

import java.util.Comparator;

public class NameComparator implements Comparator<Animal> {

    public int compare(Animal animal1, Animal animal2) {
        Calculation calc = new Calculation();
         return calc.compareChaines(animal1.getNom(), animal2.getNom());
    }
    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
