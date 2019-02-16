package automobile;


public class Main {
    public static void main(String[] args) {

        System.out.println("######## TESTS DES COMPTEURS ########");
        Main.testCompteur();

        System.out.println("\n\n######## TESTS DES VEHICULES ########");
        Main.testVehicule();

        System.out.println("\n\n######## TESTS DU GARAGE Collection: List ########");
        Main.testGarage1();
        
        /*System.out.println("\n\n######## TESTS DU GARAGE Collection: List Mappings ########");
        Main.testMappings1();*/

        System.out.println("\n\n######## TESTS DU GARAGE Collection: Set Comparable########");
        Main.testGarage2();

        System.out.println("\n\n######## TESTS DU GARAGE Collection: Set CompteurComparator########");
        Main.testGarage2Bis();
/*
        System.out.println("\n\n######## TESTS DU GARAGE Collection: Set Mappings ########");
        Main.testMappings2();*/
    }

    public static void testCompteur() {
        Compteur compteur = new Compteur();

        System.out.println(compteur);
        compteur.add(200);
        System.out.println(compteur);
        compteur.add(300);
        System.out.println(compteur);
        compteur.resetPartiel();
        System.out.println(compteur);
        compteur.add(150);
        System.out.println(compteur);
    }

    public static void testVehicule() {
        Vehicule vehicule1 = new Vehicule(5.3);
        Vehicule vehicule2 = new Vehicule(8.7);
        System.out.println(vehicule1);

        double distanceParcourue = vehicule1.rouler(100);
        System.out.println("Le vehicule " + vehicule1.getNoImmatriculation() + " a parcouru " +
                ((int)( distanceParcourue* 100.0)) / 100.0 + "kms");
        System.out.println(vehicule1);

        distanceParcourue = vehicule1.rouler(300);
        System.out.println("Le vehicule " + vehicule1.getNoImmatriculation() + " a parcouru " +
                ((int)( distanceParcourue* 100.0)) / 100.0 + "kms");
        System.out.println(vehicule1);

        distanceParcourue = vehicule1.rouler(700);
        System.out.println("Le vehicule " + vehicule1.getNoImmatriculation() + " a parcouru " +
                ((int)( distanceParcourue* 100.0)) / 100.0 + "kms");
        System.out.println(vehicule1);

        distanceParcourue = vehicule1.rouler(200);
        System.out.println("Le vehicule " + vehicule1.getNoImmatriculation() + " a parcouru " +
                ((int)( distanceParcourue* 100.0)) / 100.0 + "kms");
        System.out.println(vehicule1);

        vehicule1.rouler(540);
        System.out.println(vehicule1);
        vehicule1.faireLePlein();
        System.out.println(vehicule1);
        vehicule1.rouler(260);
        System.out.println(vehicule1);


        try {
            vehicule1.mettreDeLessence(6);
        } catch (CapaciteDepasseeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(vehicule1);

        try {
            vehicule1.mettreDeLessence(16);
        } catch (CapaciteDepasseeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(vehicule1);


        System.out.println(vehicule2);
        System.out.println(vehicule1.compareTo(vehicule1));
        System.out.println(vehicule1.compareTo(vehicule2));

    }

    public static void testGarage1() {
        Garage1 garage = new Garage1();
        int randomNumber;
        garage.add(new Vehicule(5.7));
        garage.add(new Vehicule(6.2));
        garage.add(new Vehicule(8.5));
        garage.add(new Vehicule(5.9));
        garage.add(new Vehicule(4.5));
        System.out.println(garage);

        for(Vehicule vehicule : garage) {
            vehicule.faireLePlein();
            randomNumber = (int)(Math.random() * 1000);
            vehicule.rouler(randomNumber);
        }

        System.out.println(garage);

        for(Vehicule vehicule : garage) {
            try {
                vehicule.mettreDeLessence((int) (Math.random() * 100));
            } catch (CapaciteDepasseeException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(garage);

        Main.tri1(garage);
    }

    private static void tri1(Garage1 garage) {
        System.out.println("\n\n##Tri selon le no immatriculation ##");
        garage.sortNoImmatriculation();
        System.out.println(garage);
        garage.sortNoImmatriculation();

        System.out.println("\n\n##Tri selon le compteur km totalisateur ##");
        garage.sortCompteur();
        System.out.println(garage);
        garage.sortCompteur();

        System.out.println("\n\n##Tri selon le no immatriculation ##");
        garage.sortNoImmatriculation();
        System.out.println(garage);
    }

    // Garage Comparable
    public static void testGarage2() {
        Garage2 garage = new Garage2();

        garage.add(new Vehicule(5.8));
        garage.add(new Vehicule(6.3));
        garage.add(new Vehicule(8.4));
        garage.add(new Vehicule(5.9));
        garage.add(new Vehicule(4.5));
        System.out.println(garage);

        for(Vehicule vehicule : garage) {
            vehicule.faireLePlein();
            vehicule.rouler((int) (Math.random() * 1000));
        }
        System.out.println(garage);

        for(Vehicule vehicule : garage) {
            try {
                vehicule.mettreDeLessence((int) (Math.random() * 100));
            } catch (CapaciteDepasseeException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(garage);


        Main.tri2(garage);
    }

    /**
     * Garage CompteurComparateur
     * ATTENTION: il faut d'abord instancier un garage Comparable
     * l'on référence ensuite par un garage CompteurComparable
     * en effet, les véhicules ayant tous un compteur à 0 lors de leur instanciation ne seraient pas ajoutés
     * à un garage CompteurComparable, car un Set est sans doublon par rapport au critère de comparaison
     */
    public static void testGarage2Bis() {
        Garage2 garageTemp = new Garage2();

        garageTemp.add(new Vehicule(5.7));
        garageTemp.add(new Vehicule(6.2));
        garageTemp.add(new Vehicule(8.5));
        garageTemp.add(new Vehicule(5.9));
        garageTemp.add(new Vehicule(4.5));

        Garage2 garage = new Garage2(new CompteurComparator());
        garage = garageTemp;

        for(Vehicule vehicule : garage) {
            vehicule.faireLePlein();
            vehicule.rouler((int)(Math.random() * 1000));
        }
        System.out.println(garage);


        for(Vehicule vehicule : garage) {
            try {
                vehicule.mettreDeLessence((int) (Math.random() * 100));
            } catch (CapaciteDepasseeException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(garage);

        Main.tri2(garage);
    }

    private static void tri2(Garage2 garage) {
        System.out.println("\n\n##Tri selon le no immatriculation ##");
        garage.sortNoImmatriculation();
        System.out.println(garage);
        garage.sortNoImmatriculation();


        System.out.println("\n\n##Tri selon le compteur km totalisateur ##");
        garage.sortCompteur();
        System.out.println(garage);
        garage.sortCompteur();

        System.out.println("\n\n##Tri selon le no immatriculation ##");
        garage.sortNoImmatriculation();
        System.out.println(garage);
    }
}
