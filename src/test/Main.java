package test;

import automobile.Garage1;
import automobile.Vehicule;

import java.util.Collections;



public class Main {


    public static void main(String[] args) {


        Vehicule bmw = new Vehicule(15);
        Vehicule merco = new Vehicule(20);
        Vehicule peugeot = new Vehicule(5);

        Garage1 pointS = new Garage1();

        bmw.faireLePlein();
        merco.faireLePlein();
        peugeot.faireLePlein();

        bmw.rouler(400);
        merco.rouler(20);
        peugeot.rouler(30);



        pointS.add(merco);
        pointS.add(bmw);
        pointS.add(peugeot);

        pointS.compteurSort();

        System.out.println(bmw);
        System.out.println(merco);
        System.out.println(peugeot);
        System.out.println(pointS);

        pointS.noImmatriculationSort();


        System.out.println(pointS);

        for(Vehicule vehicule : pointS) {
            vehicule.faireLePlein();
            vehicule.rouler(20);
        }

        System.out.println(pointS);

        
    }
}
