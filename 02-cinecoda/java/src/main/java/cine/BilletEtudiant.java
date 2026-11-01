package cine;

public class BilletEtudiant implements Billet {
    @Override
    public double calculerPrix(double tarifBase) {
        return tarifBase * 0.75;
    }
}
