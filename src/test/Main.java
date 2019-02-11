package test;

import automobile.Garage;
import automobile.Vehicule;

import java.util.Collections;



public class Main {


    public static void main(String[] args) {


        Vehicule bmw = new Vehicule(15);
        Vehicule merco = new Vehicule(20);
        Vehicule peugeot = new Vehicule(5);

        Garage pointS = new Garage();

        bmw.faireLePlein();
        merco.faireLePlein();

        bmw.rouler(400);
        merco.rouler(20);
        peugeot.rouler(30);



        pointS.add(merco);
        pointS.add(bmw);
        pointS.add(peugeot);

        pointS.noImmatriculationSort();

        System.out.println(bmw);
        System.out.println(merco);
        System.out.println(pointS);
    }
}
