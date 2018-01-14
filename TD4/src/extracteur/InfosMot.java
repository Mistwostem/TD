package extracteur;

/**
 * CLasse InfosMot permettant le transit des informations d'un mot vers l'indexeur
 * @author Julien
 * @author Elie
 *
 */
public class InfosMot {

    private String mot;
    private int ligne;
    private int colonne;

    /**
     * Constructeur de la classe InfosMot prenant en paramètre un mot, un numéro de ligne et un numéro de colonne
     * @param mot
     * @param ligne
     * @param colonne
     */
    public InfosMot(String mot, int ligne, int colonne) {
        this.mot = mot;
        this.ligne = ligne;
        this.colonne = colonne;
    }

    /**
     * Constructeur vide de la classe InfosMot
     */
    public InfosMot() {
    }

    /**
     * Retourne une chaîne de caractères correspondant au mot
     * @return String
     */
    public String getMot() {
        return this.mot;
    }

    /**
     * Retourne un entier correspondant au numéro de ligne
     * @return int
     */
    public int getLigne() {
        return this.ligne;
    }

    /**
     * Retourne un entier correspondant au numéro de colonne
     * @return int
     */
    public int getColonne() {
        return this.colonne;
    }

    /**
     * Retourne une chaîne de caractères construite via les méthodes getMot(), getLigne() et getColonne()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getMot());
        sb.append(" ->  ligne : ");
        sb.append(this.getLigne());
        sb.append("  colonne : ");
        sb.append(this.getColonne());
        return sb.toString();
    }    
}
