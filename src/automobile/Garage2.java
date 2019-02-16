package automobile;

import java.util.*;


public class Garage2 implements Iterable<Vehicule>{

    private Set<Vehicule> vehiculeList;

    public Garage2(){
        vehiculeList = new TreeSet<Vehicule>();
    }

    public Garage2(CompteurComparator compteurComparator)
    {
        this.vehiculeList = new TreeSet<Vehicule>(compteurComparator);
    }

    public Garage2(NoImmatriculationComparator noImmatriculationComparator)
    {
        this.vehiculeList = new TreeSet<Vehicule>(noImmatriculationComparator);
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

    public void resetPartielAll() {
        Map garage = new Garage2Action(vehiculeList);
        Function reset = new ResetCompteurPartiel();
        garage.map(reset);
    }

    public void faireLePleinAll() {
        Map garage = new Garage2Action(vehiculeList);
        Function faireLePlein = new FaireLePlein();
        garage.map(faireLePlein);
    }

    /** Les tries **/

    public void sortNoImmatriculation()
    {

        if(ifSortByNoImmatriculation()) {
            System.out.println("Véhicules déjà triés par ordre d'immatriculation");
        }
        else {
            TreeSet<Vehicule> newVehiculeList = new TreeSet<Vehicule>(new NoImmatriculationComparator());
            newVehiculeList.addAll(vehiculeList);
            vehiculeList.clear();
            vehiculeList = newVehiculeList;
        }
    }

    public void sortCompteur()
    {
        if(ifSortByCompteur()) {
            System.out.println("Véhicules déjà triés par ordre de compteur");
        }
        else {
            TreeSet<Vehicule> newVehiculeList = new TreeSet<Vehicule>(new CompteurComparator());
            newVehiculeList.addAll(vehiculeList);
            vehiculeList.clear();
            vehiculeList = newVehiculeList;
        }
    }

    public boolean ifSortByNoImmatriculation()
    {
        Vehicule vehicule1;
        Vehicule vehicule2;
        Iterator<Vehicule> iterator = vehiculeList.iterator();

        vehicule1 = iterator.next();

        while (iterator.hasNext())
        {
            vehicule2 = iterator.next();

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
        Iterator<Vehicule> iterator = vehiculeList.iterator();
        CompteurComparator compteurComparator = new CompteurComparator();

        vehicule1 = iterator.next();

        while (iterator.hasNext())
        {
            vehicule2 = iterator.next();

            if(compteurComparator.compare(vehicule1,vehicule2) > 0)
                return false;

            vehicule1 = vehicule2;
        }

        return true;
    }

    /** Les overrides **/

    @Override
    public String toString() {

        String output = "[";

        for (Vehicule vehicule : vehiculeList){
            output += "Vehicule "+ vehicule.getNoImmatriculation()+" : "+ vehicule.getCompteur()+"; jauge = "+ vehicule.getJauge()+ " Consommation = " + vehicule.getConsommation() +",\n";
        }

        output += "]";

        return output;
    }
}
