/*
 * Projet : Pendu
 * Nom : Affichage
 * Description : Gère les éléments visuels du jeu du pendu.
 * Auteur : Y0WayzZ
 * Date : 14/12/2023
 * Version : 1.0
 * 
 */

public class Affichage {
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * Affiche les traits représentant les lettres du mot à deviner.
     * 
     * @param n : nombre de lettres du mot.
     */
    public void afficherTrait(int n) {
        for (int i = 0; i < n; i++) {
            StdDraw.text(100 + i * 20, 50, "_");
        }
        StdDraw.show();
    }

    /**
     * Affiche le nombre d'essais restants.
     * 
     * @param n : nombre d'essais restants.
     */
    public void afficherEssaiRestant(int n) {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledSquare(100, 350, 50);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(100, 350, "Essais restants : " + n);
        StdDraw.show();
    }

    /**
     * Affiche la victoire avec le mot à deviner.
     * 
     * @param mot : le mot deviné.
     */
    public void affichageVictoire(String mot) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(200, 200, "Vous avez gagné ! Le mot était : " + mot);
        StdDraw.text(200, 150, "Voulez-vous rejouer ? (1 pour oui, 0 pour non)");
        StdDraw.show();
    }

    /**
     * Affiche la défaite avec le mot à deviner.
     * 
     * @param mot : le mot non deviné.
     */
    public void affichageDefaite(String mot) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(200, 200, "Vous avez perdu ! Le mot était : " + mot);
        StdDraw.text(200, 150, "Voulez-vous rejouer ? (1 pour oui, 0 pour non)");
        StdDraw.show();
    }

    /**
     * Affiche l'alphabet à l'écran.
     */
    public void afficherAlphabet() {
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < alphabet.length; i++) {
            StdDraw.text(10 + i * 15, 20, String.valueOf(alphabet[i]));
        }
        StdDraw.show();
    }

    /**
     * Barres une lettre de l'alphabet après une tentative.
     * 
     * @param c : la lettre à barrer.
     */
    public void barrerLettre(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.line(7 + i * 15, 15, 13 + i * 15, 25);
                StdDraw.show();
                break;
            }
        }
    }

    /**
     * Affiche la progression du pendu en fonction du nombre d'erreurs.
     * 
     * @param compteur : nombre de fautes.
     */
    public void afficherPendu(int compteur) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        switch (compteur) {
            case 1:
                StdDraw.line(200, 100, 350, 100); // Base
                break;
            case 2:
                StdDraw.line(280, 100, 280, 350); // Poteau vertical
                break;
            case 3:
                StdDraw.line(280, 350, 200, 350); // Poteau horizontal
                break;
            case 4:
                StdDraw.line(200, 350, 200, 300); // Corde
                break;
            case 5:
                StdDraw.circle(200, 280, 20); // Tête
                break;
            case 6:
                StdDraw.line(200, 260, 200, 200); // Corps
                break;
            case 7:
                StdDraw.line(200, 200, 180, 180); // Bras gauche
                break;
            case 8:
                StdDraw.line(200, 200, 220, 180); // Bras droit
                break;
            case 9:
                StdDraw.line(180, 240, 220, 240); // Jambes
                break;
        }
        StdDraw.show();
    }

    /**
     * Affiche le mot partiellement deviné.
     * 
     * @param motAffiche : le tableau des lettres du mot à afficher.
     */
    public void afficherMot(char[] motAffiche) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < motAffiche.length; i++) {
            StdDraw.text(100 + i * 20, 50, String.valueOf(motAffiche[i]));
        }
        StdDraw.show();
    }
}
