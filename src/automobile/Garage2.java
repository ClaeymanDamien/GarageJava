package automobile;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import sun.reflect.generics.tree.Tree;

import java.util.*;


public class Garage2 implements Iterable{

    private Set<Vehicule> vehiculeList;

    public Garage2(){
        vehiculeList = new TreeSet<Vehicule>();
    }

    public Garage2(CompteurComparator compteurComparator)
    {
        this.vehiculeList = new TreeSet<Vehicule>(compteurComparator);
    }

    public Iterator <Vehicule> iterator()
    {
        return this.vehiculeList.iterator();
    }

    /** Les actions **/

    public void add(Vehicule vehicule)
    {
        vehiculeList.add(vehicule);
    }

    /** Les tries **/

    public void sortNoImmatriculation()
    {

    }

    public void sortCompteur()
    {

    }


    /** Les overrides **/

    @Override
    public String toString() {
        Vehicule vehicule = null;
        Iterator<Vehicule> iterator = vehiculeList.iterator();
        String output = "[";

        while (iterator.hasNext())
        {
            vehicule = iterator.next();
            output += "Vehicule "+ vehicule.getNoImmatriculation()+" : "+ vehicule.getCompteur()+"; jauge = "+ vehicule.getJauge()+ " Consommation = " + vehicule.getConsommation() +",\n";
        }

        output += "]";

        return output;
    }

    class noImmatriculationComparator implements Comparator<Vehicule>{

        @Override
        public int compare(Vehicule o1, Vehicule o2) {
            return o1.getNoImmatriculation()-o2.getNoImmatriculation();
        }
    }
}
