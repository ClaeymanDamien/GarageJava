package automobile;


import java.util.ArrayList;
import java.util.Collections;

public class Garage {


    private ArrayList<Vehicule> vehiculeList;

    public Garage()
    {
            vehiculeList = new ArrayList<Vehicule>();

            //vehiculeList.sort(CompteurComparator);

    }

    public void add(Vehicule vehicule)
    {
        vehiculeList.add(vehicule);
    }

    public void noImmatriculationSort()
    {
        vehiculeList.sort(null);
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
