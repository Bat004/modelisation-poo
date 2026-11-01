package cine;

public abstract class Projecteur {
    private final String numeroSerie;

    protected Projecteur(String numeroSerie) {
        if (numeroSerie == null || numeroSerie.isBlank()) {
            throw new IllegalArgumentException("Le numéro de série ne peut pas être vide.");
        }
        this.numeroSerie = numeroSerie;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }
}