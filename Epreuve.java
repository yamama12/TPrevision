package TPRevision;

import java.util.Arrays;

public class Epreuve {
    private String denominantion;
    private Candidat[] tab;
    private int nbMax;
    private int nbEff;
    private boolean etat;

    public Epreuve(String denominantion, int nbMax) {
        this.denominantion = denominantion;
        this.nbMax = nbMax;
        this.tab = new Candidat[nbMax];
        this.nbEff = 0;
        this.etat = false;
    }

    @Override
    public String toString() {
        return "Epreuve [denominantion=" + denominantion + ", tab=" + Arrays.toString(tab) + ", etat=" + etat + "]";
    }

    public void ajoutCandidat(Candidat c) {
        if (nbEff < nbMax) { 
            tab[nbEff++] = c;
        } else {
            System.out.println("Le nombre maximal est atteint!");
        }
    }

    public void terminer() {
        this.etat = true; 
    }

    public boolean estTerminee() {
        return etat;
    }

    public Resultat getRecord() {
        Resultat best = null;
        for (int i = 0; i < nbEff; i++) {
            Resultat r = tab[i].getResultat();
            if (r != null && (best == null || r.compareTo(best) > 0)) { 
                best = r;
            }
        }
        return best;
    }

    public Candidat getVinqueur() {
        Candidat vainqueur = null;
        if (estTerminee()) {
            for (int i = 0; i < nbEff; i++) {
                if (tab[i].getResultat() != null) {
                    if (vainqueur == null || tab[i].getResultat().compareTo(vainqueur.getResultat()) > 0) {
                        vainqueur = tab[i]; 
                    }
                }
            }
        }
        return vainqueur;
    }

    public void fixeResultat(int id, Resultat r) throws Exception {
        if (etat) {
            throw new IllegalUpdateException("L'épreuve est terminée!");
        }
        for (int i = 0; i < nbEff; i++) {
            if (tab[i].getId() == id) {
                tab[i].setResultat(r);
                return;
            }
        }
        System.out.println("Candidat non trouvé!");
    }

    public Resultat getResultat(int id) {
        for (int i = 0; i < nbEff; i++) {
            if (tab[i].getId() == id) {
                return tab[i].getResultat();
            }
        }
        return null;
    }
}
