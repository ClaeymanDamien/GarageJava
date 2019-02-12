package automobile;

public class Compteur {
    private int totaliseur;
    private int partiel;

    private static final int MAX_PARTIEL = 1000;

    public Compteur()
    {

    }

    public void resetPartiel()
    {
        partiel = 0;
    }

    public void add(final int km)
    {
        totaliseur = totaliseur + km;
        partiel = partiel + km;
    }

    @Override
    public String toString()
    {
        return "compteur = [totalisateur = " + totaliseur + " | partiel = " + partiel + " ]";
    }
    //SETTER

    public void setPartiel(final int partiel) {
        this.partiel = partiel;
    }


    public void setTotaliseur(final int totaliseur) {
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
