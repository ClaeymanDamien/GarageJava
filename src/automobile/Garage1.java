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
        vehiculeList.sort(null);
    }

    public void sortCompteur()
    {
        vehiculeList.sort(new CompteurComparator());
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

