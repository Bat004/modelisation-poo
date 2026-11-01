package cine;

public class Support {
    private final Film film;

    public Support(Film film) {
        if (film == null) {
            throw new IllegalArgumentException("Le film ne peut pas être null.");
        }
        this.film = film;
    }

    public Film getFilm() {
        return film;
    }
}