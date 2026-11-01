package cine;

public class Projecteur {
    private String numeroSerie;

    protected Projecteur(String numeroSerie) {
        if (numeroSerie == null) {
            throw new IllegalArgumentException("Le numéro de série ne peut pas être vide.");
        }
        this.numeroSerie = numeroSerie;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }
}