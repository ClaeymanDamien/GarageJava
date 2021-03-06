package automobile;

import java.util.Comparator;
import java.util.Objects;

public class Vehicule implements Comparable<Vehicule>{

    private int noImmatriculation;
    private static int REGISTRE;
    private Compteur compteur;
    private double jauge;
    private double consommation;

    private static final int CAPACITE_RESERVOIR = 50;

    public Vehicule(final double consommation)
    {
        compteur = new Compteur();
        noImmatriculation = REGISTRE;
        REGISTRE++;
        this.consommation = consommation;
        jauge = 0;
    }

    /** Action du vehicule **/

    public void mettreDeLessence(int litre) throws CapaciteDepasseeException
    {
        if(litre+jauge <= CAPACITE_RESERVOIR)
        {
            jauge += litre;
        }
        else
        {
            throw new CapaciteDepasseeException();
        }
    }


    public void faireLePlein()
    {
        jauge = CAPACITE_RESERVOIR;
    }


    public int rouler(final int distance)
    {
        double consommationParKm = consommation/100;

        double distanceMax = jauge/consommationParKm;


        if(distanceMax>distance)
        {
            jauge -= distance*consommationParKm;
            compteur.add(distance);
            return distance;
        }
        else
        {
            jauge = 0;

            int distancePossible = (int)distanceMax;

            compteur.add(distancePossible);
            return distancePossible;
        }
    }

    /** Les overrides **/

    @Override
    public String toString() {
        String output;

        output = "Immatriculation = " + noImmatriculation + ", ";
        output += "Consommation = " + consommation + ", ";
        output += "Jauge = " + jauge + ", ";
        output += compteur + "\n";

        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return noImmatriculation == vehicule.noImmatriculation &&
                Double.compare(vehicule.jauge, jauge) == 0 &&
                Double.compare(vehicule.consommation, consommation) == 0 &&
                Objects.equals(compteur, vehicule.compteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noImmatriculation, compteur, jauge, consommation);
    }



    @Override
    public int compareTo(final Vehicule vehicule2)
    {
        return this.noImmatriculation - vehicule2.noImmatriculation;
    }

    //SETTER

    public void setJauge(double jauge) {
        if(jauge>CAPACITE_RESERVOIR)
            this.jauge = CAPACITE_RESERVOIR;
        else
            this.jauge = jauge;
    }

    public void setNoImmatriculation(int noImmatriculation) {
        this.noImmatriculation = noImmatriculation;
    }

    public static void setREGISTRE(int REGISTRE) {
        Vehicule.REGISTRE = REGISTRE;
    }



    public void setConsommation(double consommation) {
        this.consommation = consommation;
    }

    //GETTER


    public Compteur getCompteur() {
        return compteur;
    }

    public int getNoImmatriculation() {
        return noImmatriculation;
    }

    public static int getREGISTRE() {
        return REGISTRE;
    }

    public double getJauge() {
        return jauge;
    }

    public double getConsommation() {
        return consommation;
    }
}

class CompteurComparator implements Comparator<Vehicule> {
    public int compare(Vehicule vehicule1, Vehicule vehicule2)
    {
        int compteur1 = vehicule1.getCompteur().getTotaliseur();
        int compteur2 = vehicule2.getCompteur().getTotaliseur();

        return compteur1-compteur2;
    }
}

class NoImmatriculationComparator implements Comparator<Vehicule>{

    @Override
    public int compare(Vehicule o1, Vehicule o2) {
        return o1.getNoImmatriculation()-o2.getNoImmatriculation();
    }
}