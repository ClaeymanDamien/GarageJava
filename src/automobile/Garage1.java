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

    /** Les actions **/

    public void add(final Vehicule vehicule)
    {
        vehiculeList.add(vehicule);
    }

    /** Les tries **/

    public void sortNoImmatriculation()
    {
        if(ifSortByNoImmatriculation())
            System.out.println("Véhicules déjà triés par ordre d'immatriculation");
        else
            vehiculeList.sort(null);
    }

    public void sortCompteur()
    {
        if(ifSortByCompteur())
            System.out.println("Véhicules déjà triés par ordre de compteur");
        else
            vehiculeList.sort(new CompteurComparator());
    }

    public boolean ifSortByNoImmatriculation()
    {
        Vehicule vehicule1;
        Vehicule vehicule2;

        vehicule1 = vehiculeList.get(0);

        for(int i = 1; i < vehiculeList.size(); i++)
        {
            vehicule2 = vehiculeList.get(i);

            if(vehicule1.compareTo(vehicule2) > 0)
                return false;

            vehicule1 = vehicule2;
        }
        return true;
    }

    public boolean ifSortByCompteur()
    {
        Vehicule vehicule1;
        Vehicule vehicule2;
        CompteurComparator compteurComparator = new CompteurComparator();

        vehicule1 = vehiculeList.get(0);

        for(int i = 1; i < vehiculeList.size(); i++)
        {
            vehicule2 = vehiculeList.get(i);

            if(compteurComparator.compare(vehicule1,vehicule2) > 0)
                return false;

            vehicule1 = vehicule2;
        }
        return true;
    }

    /** Les overrides */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage1 vehicules = (Garage1) o;
        return Objects.equals(vehiculeList, vehicules.vehiculeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehiculeList);
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

