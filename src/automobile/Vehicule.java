package automobile;

import java.util.Comparator;
import java.util.Objects;

public class Vehicule implements Comparable<Vehicule>{

    private int noImmatriculation;
    private static int registre;
    private Compteur compteur;
    private double jauge;
    private double consommation;

    private static final int CAPACITE_RESERVOIR = 50;

    public Vehicule(final double consommation)
    {
        compteur = new Compteur();
        noImmatriculation = registre;
        registre++;
        this.consommation = consommation;
        jauge = 0;
    }

    /** Action du vehicule **/

    public void mettreDeLessence(final int litre)
    {
        if(litre+jauge <= CAPACITE_RESERVOIR)
        {
            jauge += litre;
        }
        else
        {
            System.out.println("Votre réservoir a une capacité insuffisante pour mettre "+ litre +" d'essence");
        }
    }

    public void faireLePlein()
    {
        jauge = CAPACITE_RESERVOIR;
    }


    public int rouler(final int distance)
    {
        double consomationParKm = consommation/100;

        double ditanceMax = jauge/consomationParKm;


        if(ditanceMax>distance)
        {
            jauge -= distance*consomationParKm;
            compteur.add(distance);
            return distance;
        }
        else
        {
            jauge = 0;

            Double d = new Double(ditanceMax);
            int distancePossible = d.intValue();

            compteur.add(distancePossible);
            return distancePossible;
        }
    }

    /** Les overrides **/

    @Override
    public String toString() {
        String output;

        output = "Immatriculation = " + noImmatriculation + "\n";
        output += "Consommation = " + consommation + "\n";
        output += "Jauge = " + jauge + "\n";
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

    public static void setRegistre(int registre) {
        Vehicule.registre = registre;
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

    public static int getRegistre() {
        return registre;
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