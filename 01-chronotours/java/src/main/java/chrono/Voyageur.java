package chrono;

public class Voyageur {
    private final String nom;
    private final int anneeCourante;
    private final int chronotons;
    private int anneeCible;
    private MachineInfinie delorean;

    public Voyageur(String nom, int anneeCourante, int chronotons) {
        this.nom = nom;
        this.anneeCourante = anneeCourante;
        this.chronotons = chronotons;
    }

    public int getChronotons() {
        return chronotons;
    }

    public int demanderdevismachineinfinie(int anneeCible, MachineInfinie delorean) {
        return delorean.cout();
    }

    public String voyager(int anneeCible, MachineInfinie delorean) {
        return "Reste: "+(this.getChronotons() - delorean.cout()) + "";
    }
}
