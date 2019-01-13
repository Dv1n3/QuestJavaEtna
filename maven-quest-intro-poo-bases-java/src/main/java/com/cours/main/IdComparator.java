package com.cours.main;

import com.cours.entities.Animal;

import java.util.Comparator;

public class IdComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal animal1, Animal animal2) {
        if (animal1.getIdAnimal() == animal2.getIdAnimal()){
            return 0;
        }
        else if (animal1.getIdAnimal() > animal2.getIdAnimal()){
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
