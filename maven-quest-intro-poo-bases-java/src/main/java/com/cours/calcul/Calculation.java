/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.calcul;

/**
 *
 * @author elhad
 */
public class Calculation implements ICalculation {

    @Override
    public int addition(int value1, int value2) {
        return value1 + value2;
    }

    @Override
    public int[] initMyArray(int taille) {
        int[] tabMagique = new int[taille];

        int randomNb;

        for (int i = 0; i < taille; i++) {
            randomNb = 1 + (int) (Math.random() * (101 - 1));
            tabMagique[i] = randomNb;
            System.out.println(randomNb);
        }
        return tabMagique;
    }

    @Override
    public int[] sortMyArray(int[] arrayToSort) {
        int n = arrayToSort.length - 1;
        boolean notSorted = true;
        int tmp;

        for (int k = 0; k < n; k++) {
            System.out.println(arrayToSort[k]);
        }

        while (notSorted) {
            notSorted = false;

            for (int i = 0; i < n; i++) {
                if (arrayToSort[i] > arrayToSort[i + 1]) {
                    tmp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = tmp;
                    notSorted = true;
                }
            }
        }
        for (int l = 0; l < n; l++) {
        }

        return arrayToSort;
    }

    @Override
    public int factorielItterative(int number) {
        int factoriel = number;

        if (number == 0) {
            factoriel = 1;
        }
        
        if (number > 0 && number <= 16) {
            while (number != 1) {
                factoriel = factoriel * (number - 1);
                number = number - 1;
            }
        }
        return factoriel;
    }

    @Override
    public int factorielRecursive(int number) {
        if (number > 1) {
            return number * factorielRecursive(number - 1);
        }
        return 1;
    }

    /**
     * renvois 0 si les deux chaines de caractères sont identiques, 1 si la
     * premiere chaine est supérieur à la seconde chaine (en terme de code
     * ASCII), -1 si la premiere chaine est inférieur à la seconde chaine (en
     * terme de code ASCII)
     *
     * @param firstChaine
     * @param secondeChaine
     * @return result
     */
    @Override
    public int compareChaines(String firstChaine, String secondeChaine) {
        int lenStr1 = firstChaine.length();
        int lenStr2 = secondeChaine.length();
        int lencomp = lenStr1 < lenStr2 ? lenStr2 : lenStr1;

        for (int i = 0; i < lencomp; i++) {
            if(i >= lenStr1 || i >= lenStr2){
                return lenStr1 > lenStr2 ? 1 : -1;
            }
            if (firstChaine.charAt(i) == secondeChaine.charAt(i)) {
                continue;
            }
            if (firstChaine.charAt(i) > secondeChaine.charAt(i)) {
                System.out.println("La première chaine est supérieure à la deuxième");
                return 1;
            }
            if (firstChaine.charAt(i) < secondeChaine.charAt(i)) {
                System.out.println("La deuxième chaine est supérieure à la première");
                return -1;
            }
        }
        System.out.println("Les deux chaines sont identiques");
        return 0;
    }

    /**
     * renvois 0 si le nombre est égale à 0, 1 s’il est pair et positif, 2 s’il
     * est négatif et paire, 3 s’il est impair et positif et 4 s’il est négatif
     * et impair
     *
     * @param chaine
     * @return result
     */
    @Override
    public int verifyParite(String chaine) {
        int nb = Integer.parseInt(chaine);
        System.out.println(nb);
        int result = 0;

        if (nb == 0) {
            System.out.println("Le nombre est égal à zéro");
            result = 0;
        }
        if (nb % 2 == 0 && nb > 0) {
            System.out.println("Le nombre est positif et pair");
            result = 1;
        }
        if (nb % 2 == 0 && nb < 0) {
            System.out.println("Le nombre est négatif et pair");
            result = 2;
        }
        if (nb % 2 != 0 && nb > 0) {
            System.out.println("Le nombre est positif et impair");
            result = 3;
        }
        if (nb % 2 != 0 && nb < 0) {
            System.out.println("Le nombre est négatif et impair");
            result = 4;
        }
        return result;
    }

    @Override
    public int nombreMagique(int[] array) {
        int result;
        int min = 100;
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }

            if (array[i] > max) {
                max = array[i];
            }
        }

        result = (min + max) / 2;
        System.out.println(min + " + " + max);
        System.out.println("Le résultat final est " + result);
        return result;
    }
}
