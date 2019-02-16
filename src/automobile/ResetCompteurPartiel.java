package automobile;

public class ResetCompteurPartiel implements Function<Vehicule>{
    @Override
    public void applyIt(Vehicule vehicule) {
        vehicule.getCompteur().resetPartiel();
    }
}
