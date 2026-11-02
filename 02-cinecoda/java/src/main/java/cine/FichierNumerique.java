package cine;

import java.time.LocalDate;

public class FichierNumerique extends Support {
    private LocalDate expirationCle;

    public FichierNumerique(Film film, LocalDate expirationCle) {
        super(film);
        if (expirationCle == null) {
            throw new IllegalArgumentException("La date d'expiration ne peut pas être null.");
        }
        this.expirationCle = expirationCle;
    }

    @Override
    public void verifierProjectabilite(Projecteur projecteur, LocalDate date) {
        if (projecteur == null) {
            throw new IllegalArgumentException("Le projecteur ne peut pas être null.");
        }
        if (date == null) {
            throw new IllegalArgumentException("La date de projection ne peut pas être null.");
        }
        if (!(projecteur instanceof ProjecteurNumerique)) {
            throw new IllegalStateException("Un fichier numérique ne peut pas être lu par un projecteur argentique.");
        }
        if (date.isAfter(expirationCle)) {
            throw new IllegalStateException("la clé de lecture de « " + getFilm().getTitre() + " » a expiré le " + expirationCle.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }
}
