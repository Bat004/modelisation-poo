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
    }
}
