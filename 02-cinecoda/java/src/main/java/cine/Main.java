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

        log.info("1");
        Cinema cinema = new Cinema("CinéCoda");
        Salle salle1 = new Salle(1, 100, new ProjecteurNumerique("NUM-001"));
        Salle salle2 = new Salle(2, 3, new ProjecteurArgentique("ARG-001"));
        cinema.ajouterSalle(salle1);
        cinema.ajouterSalle(salle2);
        log.info("Salle 1 : 100 places, projecteur numérique");
        log.info("Salle 2 : 3 places, projecteur argentique");
        log.info("Salles libres : Salle 1, Salle 2");
        log.info("");

        log.info("2");
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

        log.info("3");
        Seance seanceDune = cinema.programmerSeance(1, supportDune, date, 10);
        vendreEtAfficher(seanceDune, new BilletPleinTarif(), "plein tarif");
        vendreEtAfficher(seanceDune, new BilletEtudiant(), "étudiant");
        vendreEtAfficher(seanceDune, new BilletEnfant(), "enfant");
        log.info("Places restantes : " + seanceDune.getPlacesRestantes());
        log.info("Taux de remplissage : " + String.format(Locale.FRANCE, "%.0f %%", seanceDune.getTauxRemplissage()));
        log.info("Recette : " + montant(seanceDune.getRecette()));
        log.info("");

        log.info("4");
        Seance seanceAvengers = cinema.programmerSeance(1, supportAvengers, date, 10);
        try {
            seanceAvengers.demarrer();
        } catch (IllegalStateException e) {
            log.info("Démarrage refusé : " + e.getMessage());
        }
        log.info("");

        log.info("5");
        Seance seanceRockySalle1 = cinema.programmerSeance(1, supportRocky, date, 10);
        try {
            seanceRockySalle1.demarrer();
        } catch (IllegalStateException e) {
            log.info("Démarrage refusé : " + e.getMessage());
        }
        log.info("État de la Salle 1 : " + salle1.getEtat());
        log.info("");
    }

    private static void vendreEtAfficher(Seance seance, Billet billet, String type) {
        seance.vendreBillet(billet);
        log.info("Billet " + type + " vendu : " + montant(billet.calculerPrix(seance.getTarifBase())));
    }

    private static String montant(double valeur) {
        return String.format(Locale.FRANCE, "%.2f €", valeur);
    }
}
