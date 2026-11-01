package cine;

import java.time.LocalDate;

public class Seance {
    private Salle salle;
    private Support support;
    private LocalDate date;
    private double tarifBase;

    public Seance(Salle salle, Support support, LocalDate date, double tarifBase) {
        if (salle == null) {
            throw new IllegalArgumentException("La salle ne peut pas être null.");
        }
        if (support == null) {
            throw new IllegalArgumentException("Le support ne peut pas être null.");
        }
        if (date == null) {
            throw new IllegalArgumentException("La date ne peut pas être null.");
        }
        if (tarifBase <= 0) {
            throw new IllegalArgumentException("Le tarif de base doit être positif.");
        }

        this.salle = salle;
        this.support = support;
        this.date = date;
        this.tarifBase = tarifBase;
    }

    public Salle getSalle() {
        return salle;
    }

    public Support getSupport() {
        return support;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTarifBase() {
        return tarifBase;
    }

    public void demarrer() {
        support.verifierProjectabilite(salle.getProjecteur(), date);
        salle.demarrerSeance();
    }

    public void terminer() {
        salle.terminerSeance();
        if (support instanceof Copie35mm) {
            ((Copie35mm) support).enregistrerProjection();
        }
    }
}
