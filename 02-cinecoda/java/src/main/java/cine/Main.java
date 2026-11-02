package cine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Logger;

public class Main {
    private static Logger log;
    public static void main(String[] args) {
        log = ConsoleLogger.create("cine.scenario");
        LocalDate date = LocalDate.of(2026, 10, 15);

        log.info("=== 1. Création du cinéma CinéCoda ===");
        Cinema cinema = new Cinema("CinéCoda");
        Salle salle1 = new Salle(1, 100, new ProjecteurNumerique("NUM-001"));
        Salle salle2 = new Salle(2, 3, new ProjecteurArgentique("ARG-001"));
        cinema.ajouterSalle(salle1);
        cinema.ajouterSalle(salle2);
        log.info("Salle 1 : 100 places, projecteur numérique");
        log.info("Salle 2 : 3 places, projecteur argentique");
        log.info("Salles libres : Salle 1, Salle 2");
        log.info("");

        log.info("=== 2. Films et supports ===");
        Film dune = new Film("Dune 3", 166);
        Film avengers = new Film("Avengers: Doomsday", 119);
        Film rocky = new Film("I Play Rocky", 103);
        LocalDate expirationDune = LocalDate.of(2026, 10, 30);
        LocalDate expirationAvengers = LocalDate.of(2026, 10, 14);
        FichierNumerique supportDune = new FichierNumerique(dune, expirationDune);
        FichierNumerique supportAvengers = new FichierNumerique(avengers, expirationAvengers);
        Copie35mm supportRocky = new Copie35mm(rocky, 49);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        log.info("Dune 3 (166 min) : fichier numérique, clé valable jusqu'au " + expirationDune.format(dateFormat));
        log.info("Avengers: Doomsday (119 min) : fichier numérique, clé valable jusqu'au " + expirationAvengers.format(dateFormat));
        log.info("I Play Rocky (103 min) : copie 35 mm, " + supportRocky.getNombreProjections() + " projections");
        log.info("");

        log.info("=== 3. Dune 3 en Salle 1 le 15/10/2026 (tarif de base 10,00 €) ===");
        Seance seanceDune = cinema.programmerSeance(1, supportDune, date, 10);
        vendreEtAfficher(seanceDune, new BilletPleinTarif(), "plein tarif");
        vendreEtAfficher(seanceDune, new BilletPleinTarif(), "plein tarif");
        vendreEtAfficher(seanceDune, new BilletEtudiant(), "étudiant");
        vendreEtAfficher(seanceDune, new BilletEnfant(), "enfant");
        log.info("Places restantes : " + seanceDune.getPlacesRestantes());
        log.info("Taux de remplissage : " + String.format(Locale.FRANCE, "%.0f %%", seanceDune.getTauxRemplissage()));
        log.info("Recette : " + montant(seanceDune.getRecette()));
        log.info("");

        log.info("=== 4. Avengers: Doomsday en Salle 1 le 15/10/2026 (tarif de base 10,00 €) ===");
        Seance seanceAvengers = cinema.programmerSeance(1, supportAvengers, date, 10);
        try {
            seanceAvengers.demarrer();
        } catch (IllegalStateException e) {
            log.info("Démarrage refusé : " + e.getMessage());
        }
        log.info("");

        log.info("=== 5. I Play Rocky en Salle 1 le 15/10/2026 (tarif de base 10,00 €) ===");
        Seance seanceRockySalle1 = cinema.programmerSeance(1, supportRocky, date, 10);
        try {
            seanceRockySalle1.demarrer();
        } catch (IllegalStateException e) {
            log.info("Démarrage refusé : " + e.getMessage());
        }
        log.info("État de la Salle 1 : " + salle1.getEtat());
        log.info("");

        log.info("=== 6. I Play Rocky en Salle 2 le 15/10/2026 (tarif de base 8,00 €) ===");
        Seance seanceRockySalle2 = cinema.programmerSeance(2, supportRocky, date, 8);
        vendreEtAfficher(seanceRockySalle2, new BilletEtudiant(), "étudiant");
        vendreEtAfficher(seanceRockySalle2, new BilletEtudiant(), "étudiant");
        vendreEtAfficher(seanceRockySalle2, new BilletEtudiant(), "étudiant");
        try {
            seanceRockySalle2.vendreBillet(new BilletEtudiant());
        } catch (IllegalStateException e) {
            log.info("Vente refusée : " + e.getMessage());
        }
        log.info("Places restantes : " + seanceRockySalle2.getPlacesRestantes());
        log.info("Taux de remplissage : " + String.format(Locale.FRANCE, "%.0f %%", seanceRockySalle2.getTauxRemplissage()));
        seanceRockySalle2.demarrer();
        log.info("Séance démarrée");
        seanceRockySalle2.terminer();
        log.info("Séance terminée");
        log.info("État de la Salle 2 : NETTOYAGE");
        log.info("Salles libres : Salle 1");
        log.info("Projections de la copie de « I Play Rocky » : " + supportRocky.getNombreProjections());
        log.info("");

        log.info("=== 7. I Play Rocky en Salle 2 le 15/10/2026 (tarif de base 8,00 €) ===");
        Seance seanceRockySuivante = cinema.programmerSeance(2, supportRocky, date, 8);
        try {
            seanceRockySuivante.demarrer();
        } catch (IllegalStateException e) {
            log.info("Démarrage refusé : " + e.getMessage());
        }
        salle2.terminerNettoyage();
        log.info("Nettoyage de la Salle 2 terminé");
        try {
            seanceRockySuivante.demarrer();
        } catch (IllegalStateException e) {
            log.info("Démarrage refusé : " + e.getMessage());
        }
        log.info("");

        log.info("=== 8. Programmation en Salle 3 ===");
        try {
            cinema.programmerSeance(3, supportDune, date, 10);
        } catch (IllegalArgumentException e) {
            log.info("Programmation refusée : " + e.getMessage());
        }
        log.info("");

        log.info("=== 9. Bilan du 15/10/2026 ===");
        for (Seance seance : cinema.getSeances(date)) {
            String titre = seance.getSupport().getFilm().getTitre();
            int numeroSalle = seance.getSalle().getNumero();
            int billetsVendus = seance.getSalle().getCapacite() - seance.getPlacesRestantes();
            log.info(titre + ", Salle " + numeroSalle + " : " + billetsVendus + " billet(s), recette " + montant(seance.getRecette()));
        }
        log.info("Recette du jour : " + montant(cinema.getRecetteDuJour(date)));
    }

    private static void vendreEtAfficher(Seance seance, Billet billet, String type) {
        seance.vendreBillet(billet);
        log.info("Billet " + type + " vendu : " + montant(billet.calculerPrix(seance.getTarifBase())));
    }

    private static String montant(double valeur) {
        return String.format(Locale.FRANCE, "%.2f €", valeur);
    }
}
