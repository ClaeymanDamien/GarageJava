package automobile;

public class Compteur {
    private double totaliseur;
    private double partiel;

    private static final int MAX_PARTIEL = 1000;

    public Compteur()
    {
        totaliseur = 0;
        partiel = 0;
    }

    public void resetPartiel()
    {
        partiel = 0;
    }

    public void add(double km)
    {
        totaliseur = totaliseur + km;
        partiel = partiel + km;
    }

    //compteur = [ totalisateur = 500 | partiel = 108 ]
    public String toString()
    {
        return "compteur = [totalisateur = " + totaliseur + " | partiel = " + partiel + " ]";
    }
    //SETTER

    public void setPartiel(double partiel) {
        this.partiel = partiel;
    }


    public void setTotaliseur(double totaliseur) {
        this.totaliseur = totaliseur;
    }

    //GETTER


    public double getTotaliseur() {
        return totaliseur;
    }

    public double getPartiel() {
        return partiel;
    }
}
