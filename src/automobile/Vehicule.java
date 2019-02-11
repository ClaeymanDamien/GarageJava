package automobile;

import java.util.Comparator;

public class Vehicule implements Comparable<Vehicule>{

    private int noImmatriculation;
    private static int registre;
    private Compteur compteur;
    private double jauge;
    private double consommation;

    private static final int CAPACITE_RESERVOIR = 50;

    public Vehicule(double consommation)
    {
        compteur = new Compteur();
        noImmatriculation = registre;
        registre++;
        this.consommation = consommation;
        jauge = 0;
    }

    @Override
    public String toString() {
        String output;

        output = "Immatriculation = " + noImmatriculation + "\n";
        output += "Consommation = " + consommation + "\n";
        output += "Jauge = " + jauge + "\n";
        output += compteur + "\n";

        return output;
    }

    public int compareTo(Vehicule vehicule2)
    {
        if(this.noImmatriculation == vehicule2.noImmatriculation)
        {
            return 0;
        }
        else if(this.noImmatriculation > vehicule2.noImmatriculation)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public void mettreDeLessence(int litre)
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


    public double rouler(int distance)
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
            compteur.add(ditanceMax);
            return ditanceMax;
        }
    }

    //SETTER

    public void setNoImmatriculation(int noImmatriculation) {
        this.noImmatriculation = noImmatriculation;
    }

    public static void setRegistre(int registre) {
        Vehicule.registre = registre;
    }

    public void setJauge(double jauge) {
        if(jauge>CAPACITE_RESERVOIR)
            this.jauge = CAPACITE_RESERVOIR;
        else
            this.jauge = jauge;
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
