package cine;

public class BilletEnfant implements Billet {
    @Override
    public double calculerPrix(double tarifBase) {
        return 5.0;
    }
}
