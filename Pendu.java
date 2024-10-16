/*
 * Projet : Pendu
 * Nom : Pendu
 * Description : Point d'entrée du jeu du pendu.
 * Auteur : Y0WayzZ
 * Date : 14/12/2023
 * Version : 1.0
 * 
 */

public class Pendu {
    public static void main(String[] args) {
        // Configuration de la fenêtre d'affichage
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, 400);
        StdDraw.setYscale(0, 400);
        StdDraw.enableDoubleBuffering();

        // Lancement du jeu
        Partie partie = new Partie();
        partie.jouer();
    }
}
