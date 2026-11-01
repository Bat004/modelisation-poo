package cine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String nom;
    private List<Salle> salles;
    private List<Seance> seances;

    public Cinema(String nom) {
        if (nom == null) {
            throw new IllegalArgumentException("Le nom du cinéma ne peut pas être vide.");
        }
        this.nom = nom;
        this.salles = new ArrayList<>();
        this.seances = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterSalle(Salle salle) {
        if (salle == null) {
            throw new IllegalArgumentException("La salle ne peut pas être null.");
        }
        if (chercherSalle(salle.getNumero()) != null) {
            throw new IllegalArgumentException("Le cinéma " + nom + " possède déjà une salle " + salle.getNumero() + ".");
        }
        salles.add(salle);
    }

    public Seance programmerSeance(int numeroSalle, Support support, LocalDate date, double tarifBase) {
        Salle salle = chercherSalle(numeroSalle);
        if (salle == null) {
            throw new IllegalArgumentException("Le cinéma " + nom + " n'a pas de salle " + numeroSalle + ".");
        }

        Seance seance = new Seance(salle, support, date, tarifBase);
        seances.add(seance);
        return seance;
    }

    public Salle chercherSalle(int numeroSalle) {
        for (Salle salle : salles) {
            if (salle.getNumero() == numeroSalle) {
                return salle;
            }
        }
        return null;
    }

    public List<Salle> getSalles() {
        return new ArrayList<>(salles);
    }

    public List<Seance> getSeances() {
        return new ArrayList<>(seances);
    }
}
