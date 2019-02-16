package automobile;

import java.util.List;

public class Garage1Action implements Map{

    private List<Vehicule> garage;

    Garage1Action(List<Vehicule> garage){
        this.garage = garage;
    }

    public void map(Function f) {
        for(Vehicule vehicule : garage){
            f.applyIt(vehicule);
        }
    }
}
