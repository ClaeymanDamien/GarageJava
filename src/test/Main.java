package test;


import automobile.Garage1;
import automobile.Garage2;
import automobile.Vehicule;


public class Main {


    public static void main(String[] args) {


        Vehicule bmw = new Vehicule(15);
        Vehicule merco = new Vehicule(20);
        Vehicule peugeot = new Vehicule(5);

        Vehicule audi = new Vehicule(17);
        Vehicule jeep = new Vehicule(25);
        Vehicule ferrari = new Vehicule(27);


        Garage1 pointS = new Garage1();
        Garage2 feuVert = new Garage2();



        bmw.faireLePlein();
        merco.faireLePlein();
        peugeot.faireLePlein();

        bmw.rouler(400);
        merco.rouler(20);
        peugeot.rouler(30);



        pointS.add(merco);
        pointS.add(bmw);
        pointS.add(peugeot);

        feuVert.add(jeep);
        feuVert.add(ferrari);
        feuVert.add(audi);


        pointS.sortCompteur();

        System.out.println(bmw);
        System.out.println(merco);
        System.out.println(peugeot);
        System.out.println(pointS);

        pointS.sortNoImmatriculation();

        System.out.println(pointS);

        for(Vehicule vehicule : pointS) {
            vehicule.faireLePlein();
            vehicule.rouler(20);
        }

        System.out.println(pointS);


        System.out.println(feuVert);

    }


}
