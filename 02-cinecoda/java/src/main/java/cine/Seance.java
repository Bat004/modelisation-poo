package cine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Seance {
    private Salle salle;
    private Support support;
    private LocalDate date;
    private double tarifBase;
    private List<Billet> billets;

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
        this.billets = new ArrayList<>();
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

    public int getPlacesRestantes() {
        return salle.getCapacite() - billets.size();
    }

    public double getTauxRemplissage() {
        return billets.size() * 100.0 / salle.getCapacite();
    }

    public double getRecette() {
        double recette = 0;
        for (Billet billet : billets) {
            recette += billet.calculerPrix(tarifBase);
        }
        return recette;
    }

    public void vendreBillet(Billet billet) {
        if (billet == null) {
            throw new IllegalArgumentException("Le billet ne peut pas être null.");
        }
        if (billets.size() >= salle.getCapacite()) {
            throw new IllegalStateException("la séance est complète (" + salle.getCapacite() + " places)");
        }
        billets.add(billet);
    }

    public void demarrer() {
        salle.verifierLibre();
        support.verifierProjectabilite(salle.getProjecteur(), date);
        salle.demarrerSeance();
    }

    public void terminer() {
        salle.terminerSeance();
        support.enregistrerProjection();
    }
}
