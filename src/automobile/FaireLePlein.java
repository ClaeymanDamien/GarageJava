package automobile;

public class FaireLePlein implements Function<Vehicule>{

    private static int ESSENCE_MINIMUM = 10;
    @Override
    public void applyIt(Vehicule vehicule) {
        if(vehicule.getJauge()<ESSENCE_MINIMUM)
            vehicule.faireLePlein();
    }
}
