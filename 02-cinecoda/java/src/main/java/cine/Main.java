package cine;

import java.time.LocalDate;
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
    }
}
