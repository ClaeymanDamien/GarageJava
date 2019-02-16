package automobile;

public class CapaciteDepasseeException extends Exception {
    public CapaciteDepasseeException(){
        super();
    }

    public String getMessage(){
        return "Votre réservoir a une capacité insuffisante";
    }
}
