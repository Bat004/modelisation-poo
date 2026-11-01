package cine;

import java.time.LocalDate;

public class Copie35mm extends Support {
    private int nombreProjections;

    public Copie35mm(Film film, int nombreProjections) {
        super(film);
        if (nombreProjections < 0) {
            throw new IllegalArgumentException("Le nombre de projections ne peut pas être négatif.");
        }
        this.nombreProjections = nombreProjections;
    }

    @Override
    public void verifierProjectabilite(Projecteur projecteur, LocalDate date) {
        if (projecteur == null) {
            throw new IllegalArgumentException("Le projecteur ne peut pas être null.");
        }
        if (date == null) {
            throw new IllegalArgumentException("La date de projection ne peut pas être null.");
        }
        if (!(projecteur instanceof ProjecteurArgentique)) {
            throw new IllegalStateException("Une copie 35 mm ne peut pas être lue par un projecteur numérique.");
        }
        if (nombreProjections >= 50) {
            throw new IllegalStateException("La copie 35 mm de « " + getFilm().getTitre() + " » est usée (" + nombreProjections + " projections).");
        }
    }

    @Override
    public void enregistrerProjection() {
        nombreProjections++;
    }

    public int getNombreProjections() {
        return nombreProjections;
    }
}
