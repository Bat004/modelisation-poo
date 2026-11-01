package cine;

public class Salle {
    private int numero;
    private int capacite;
    private Projecteur projecteur;
    private EtatSalle etat;

    public Salle(int numero, int capacite, Projecteur projecteur) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Le numéro de salle doit être positif.");
        }
        if (capacite <= 0) {
            throw new IllegalArgumentException("La capacité doit être positive.");
        }
        if (projecteur == null) {
            throw new IllegalArgumentException("Le projecteur ne peut pas être null.");
        }

        this.numero = numero;
        this.capacite = capacite;
        this.projecteur = projecteur;
        this.etat = EtatSalle.LIBRE;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacite() {
        return capacite;
    }

    public Projecteur getProjecteur() {
        return projecteur;
    }

    public EtatSalle getEtat() {
        return etat;
    }

    public void demarrerSeance() {
        if (etat != EtatSalle.LIBRE) {
            throw new IllegalStateException("La salle " + numero + " n'est pas libre (état : " + etat + ").");
        }
        etat = EtatSalle.EN_SEANCE;
    }

    public void terminerSeance() {
        if (etat != EtatSalle.EN_SEANCE) {
            throw new IllegalStateException("La salle " + numero + " n'est pas en séance (état : " + etat + ").");
        }
        etat = EtatSalle.EN_NETTOYAGE;
    }

    public void terminerNettoyage() {
        if (etat != EtatSalle.EN_NETTOYAGE) {
            throw new IllegalStateException("La salle " + numero + " n'est pas en nettoyage (état : " + etat + ").");
        }
        etat = EtatSalle.LIBRE;
    }
}
