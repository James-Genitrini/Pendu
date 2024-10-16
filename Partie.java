/*
 * Projet : Pendu
 * Nom : Partie
 * Description : Gère une partie de pendu.
 * Auteur : Y0WayzZ
 * Date : 14/12/2023
 * Version : 1.0
 * 
 */

public class Partie {
    private int essaisRestants;
    private int compteurErreurs;
    private Mot motADeviner;
    private Affichage affichage;
    private Joueur joueur;

    public Partie() {
        this.essaisRestants = 9; // Initialisation des essais restants
        this.compteurErreurs = 0; // Compteur d'erreurs
        this.motADeviner = new Mot(); // Choisit un mot aléatoirement
        this.affichage = new Affichage();
        this.joueur = new Joueur();
    }

    /**
     * Lance une partie de pendu.
     */
    public void jouer() {
        char[] motAffiche = motADeviner.initMotAffiche();
        affichage.afficherTrait(motADeviner.getMot().length());
        affichage.afficherEssaiRestant(essaisRestants - compteurErreurs);
        affichage.afficherAlphabet();

        while (compteurErreurs < essaisRestants) {
            affichage.afficherEssaiRestant(essaisRestants - compteurErreurs);
            char lettre = joueur.lireCaractere();
            affichage.barrerLettre(lettre);

            if (motADeviner.contains(lettre)) {
                motADeviner.completerMot(lettre, motAffiche);
                affichage.afficherMot(motAffiche);

                if (motADeviner.estTrouve(motAffiche)) {
                    affichage.affichageVictoire(motADeviner.getMot());
                    if (joueur.demanderRejouer()) {
                        StdDraw.clear();
                        new Partie().jouer();
                    } else {
                        System.exit(0);
                    }
                }
            } else {
                compteurErreurs++;
                affichage.afficherPendu(compteurErreurs);

                if (compteurErreurs == essaisRestants) {
                    affichage.affichageDefaite(motADeviner.getMot());
                    if (joueur.demanderRejouer()) {
                        StdDraw.clear();
                        new Partie().jouer();
                    } else {
                        System.exit(0);
                    }
                }
            }
        }
    }
}
