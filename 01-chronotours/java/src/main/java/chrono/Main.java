package chrono;

import java.util.logging.Logger;

public class Main {
    private static Logger log;

    public static void main(String[] args) {
        log = ConsoleLogger.create("chrono.scenario");
        var marty = new Voyageur("Marty", 2026, 100);
        var doc = new Voyageur("Doc", 2026, 200);
        log.info("1. Arrivée à l'agence de ChronoTour");
        var cabine = new Machine("Cabine", 1, 100);
        var delorean = new MachineInfinie("DeLorean", 30);

        log.info("" + marty.demanderdevismachineinfinie(1955, delorean));
        log.info("" + marty.voyager(1955, delorean));
        // Rejouez ici le scénario de l'énoncé, en affichant chaque étape avec log.info(...)
    }
}
