package automobile;

public class Compteur {
    private int totaliseur;
    private int partiel;

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

    public void add(int km)
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

    public void setPartiel(int partiel) {
        this.partiel = partiel;
    }


    public void setTotaliseur(int totaliseur) {
        this.totaliseur = totaliseur;
    }

    //GETTER


    public int getTotaliseur() {
        return totaliseur;
    }

    public int getPartiel() {
        return partiel;
    }
}
