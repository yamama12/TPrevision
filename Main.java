package TPRevision;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Epreuve e = new Epreuve("Science", 3);
        
        Candidat c1 = new Candidat(1, "Yamama");
        Candidat c2 = new Candidat(2, "Khalili");
        Candidat c3 = new Candidat(3, "Nadia");

        e.ajoutCandidat(c1);
        e.ajoutCandidat(c2);
        e.ajoutCandidat(c3);

        System.out.println(e);

        e.fixeResultat(1, new ResultatPoints(20));
        e.fixeResultat(2, new ResultatPoints(19));
        e.fixeResultat(3, new ResultatPoints(18));

        e.terminer();

        Candidat vainqueur = e.getVinqueur();
        if (vainqueur != null) {
            System.out.println("Le vainqueur est : " + vainqueur.getNon());
        } else {
            System.out.println("Aucun vainqueur trouvé !");
        }

        Resultat record = e.getRecord();
        if (record != null) {
            System.out.println("Le meilleur résultat réalisé par les participants : " + record);
        } else {
            System.out.println("Aucun résultat disponible !");
        }
    }
}
