package automobile;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Garage {


    private ArrayList<Vehicule> vehiculeList;

    public Garage()
    {
            vehiculeList = new ArrayList<Vehicule>();
    }

    public void add(Vehicule vehicule)
    {
        vehiculeList.add(vehicule);
    }

    public void noImmatriculationSort()
    {
        vehiculeList.sort(null);
    }

    public void compteurSort()
    {
        vehiculeList.sort(new CompteurComparator());
    }


    @Override
    public String toString() {

        Vehicule vehicule = null;
        String output = "[";

        for(int i = 0; i < vehiculeList.size(); i++)
        {
            vehicule = vehiculeList.get(i);
            output += "Vehicule "+ vehicule.getNoImmatriculation()+" : "+ vehicule.getCompteur()+"; jauge = "+ vehicule.getJauge()+ " Consommation = " + vehicule.getConsommation() +",\n";
        }
        output += "]";

        return output;
    }
}

class CompteurComparator implements Comparator<Vehicule> {
    public int compare(Vehicule vehicule1, Vehicule vehicule2)
    {
        int compteur1 = vehicule1.getCompteur().getTotaliseur();
        int compteur2 = vehicule2.getCompteur().getTotaliseur();

        if(compteur1>compteur2)
        {
            return 1;
        }

        if (compteur1<compteur2)
        {
            return -1;
        }

        return 0;
    }
}