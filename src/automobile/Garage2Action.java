package automobile;

import java.util.Set;

public class Garage2Action implements Map{

    private Set<Vehicule> garage;

    Garage2Action(Set<Vehicule> garage){
        this.garage = garage;
    }

    public void map(Function f){

        for(Vehicule vehicule : garage) {
            f.applyIt(vehicule);
        }
    }
}
