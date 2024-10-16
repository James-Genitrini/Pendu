/*
 * Projet : Pendu
 * Nom : Mot
 * Description : Gère le mot à deviner et les interactions avec celui-ci.
 * Auteur : Y0WayzZ
 * Date : 14/12/2023
 * Version : 1.0
 * 
 */

 import java.text.Normalizer;
 import java.util.Random;
 import java.util.List;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.io.File; 
 import javax.xml.parsers.DocumentBuilder; 
 import javax.xml.parsers.DocumentBuilderFactory; 
 import org.w3c.dom.Document;
 import org.w3c.dom.NodeList; 
 import org.w3c.dom.Element; 
 

public class Mot {
    private String mot;
    private char[] motCache;

    private static List<String> mots;

    // Constructeur
    public Mot() {

        mots = chargerMotsDepuisXML("mots.xml"); // Charger les mots depuis le fichier XML
        this.mot = choisirMotAleatoire();
        this.motCache = mot.toCharArray();
    }

    // Méthode pour charger les mots depuis le fichier XML
    private List<String> chargerMotsDepuisXML(String nomFichier) {
        List<String> mots = new ArrayList<>();
        try {
            File fichier = new File(nomFichier);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fichier);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("mot");
            for (int i = 0; i < nList.getLength(); i++) {
                Element element = (Element) nList.item(i);
                mots.add(element.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mots;
    }

    // Méthode pour charger les mots depuis le fichier XML
    // (Cette partie reste inchangée, assure-toi de l'inclure)

    private String choisirMotAleatoire() {
        return mots.get(new Random().nextInt(mots.size()));
    }

    public boolean contains(char c) {
        // Normaliser le mot à deviner et la lettre saisie
        String motNormalise = normaliserString(mot);
        return motNormalise.contains(normaliserString(String.valueOf(c)));
    }

    private String normaliserString(String input) {
        // Normalise la chaîne de caractères pour enlever les accents
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", ""); // Supprime les marques (accents)
    }

    public void completerMot(char c, char[] motAffiche) {
        for (int i = 0; i < motCache.length; i++) {
            if (motCache[i] == c) {
                motAffiche[i] = c;
            }
        }
    }

    public char[] initMotAffiche() {
        char[] motAffiche = new char[mot.length()];
        Arrays.fill(motAffiche, '_'); // Remplir avec des underscores
        return motAffiche;
    }

    public boolean estTrouve(char[] motAffiche) {
        return String.valueOf(motAffiche).equals(mot);
    }

    public String getMot() {
        return mot;
    }
}
