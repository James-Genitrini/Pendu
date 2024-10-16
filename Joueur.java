/*
 * Projet : Pendu
 * Nom : Joueur
 * Description : Gère les interactions avec le joueur.
 * Auteur : Y0WayzZ
 * Date : 14/12/2023
 * Version : 1.0
 * 
 */

public class Joueur {

    /**
     * Lit une lettre entrée par le joueur.
     * 
     * @return le caractère saisi.
     */
    public char lireCaractere() {
        char c = ' ';
        while (c == ' ') {
            if (StdDraw.hasNextKeyTyped()) {
                c = StdDraw.nextKeyTyped();
            }
        }
        return c;
    }

    /**
     * Demande au joueur s'il souhaite rejouer.
     * 
     * @return true si le joueur souhaite rejouer, false sinon.
     */
    public boolean demanderRejouer() {
        int valeur = -1;
        while (valeur == -1) {
            if (StdDraw.hasNextKeyTyped()) {
                char c = StdDraw.nextKeyTyped();
                if (c == '1') {
                    return true;
                } else if (c == '0') {
                    return false;
                }
            }
        }
        return false;
    }
}
