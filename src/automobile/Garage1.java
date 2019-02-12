package automobile;


import java.util.*;
import java.lang.Iterable;

public class Garage1 implements Iterable<Vehicule>{


    private List <Vehicule> vehiculeList;

    public Garage1()
    {
            vehiculeList = new ArrayList<Vehicule>();
    }

    public Garage1(List<Vehicule> vehiculeList)
    {
        this.vehiculeList = vehiculeList;
    }

    public Iterator <Vehicule> iterator()
    {
        return this.vehiculeList.iterator();
    }

    public void add(final Vehicule vehicule)
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

        return compteur1-compteur2;
    }
}