package com.cours.main;

import com.cours.entities.Animal;

import java.util.Comparator;

public class WeightComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal animal1, Animal animal2) {
        if (animal1.getPoids() == animal2.getPoids()){
            return 0;
        }
        else if (animal1.getPoids() > animal2.getPoids()){
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}