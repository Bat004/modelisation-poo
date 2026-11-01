package cine;

public class Film {
    private final String titre;
    private final int duree;

    public Film(String titre, int duree) {
        if (titre == null) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide.");
        }
        if (duree <= 0) {
            throw new IllegalArgumentException("La durée doit être positive.");
        }

        this.titre = titre;
        this.duree = duree;
    }

    public String getTitre() {
        return titre;
    }

    public int getDuree() {
        return duree;
    }
}