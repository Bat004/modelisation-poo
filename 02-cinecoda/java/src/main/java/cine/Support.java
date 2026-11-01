package cine;

import java.time.LocalDate;

public abstract class Support {
    private Film film;

    public Support(Film film) {
        if (film == null) {
            throw new IllegalArgumentException("Le film ne peut pas être null.");
        }
        this.film = film;
    }

    public Film getFilm() {
        return film;
    }

    public abstract void verifierProjectabilite(Projecteur projecteur, LocalDate date);
}
