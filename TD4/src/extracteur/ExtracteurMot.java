package extracteur;

/**
 * Classe concr�te h�ritant l'interface Extracteur
 * @author Elie
 * @author Julien
 *
 */
public class ExtracteurMot implements Extracteur {
	
    private final String chaine;
    private int ligne;
    private int colonne;
    private int cursor;

    /**
     * Constructeur de la classe ExtracteurMot prenant en param�tre une cha�ne de caract�res
     * @param chaine String
     */
    public ExtracteurMot(String chaine) {
        this.chaine = chaine;
        this.cursor = 0;
        this.ligne = 1;
        this.colonne = 0;
    }

    /**
     * Retourne un objet de type InfosMot
     */
    @Override
    public InfosMot getNext() {
        StringBuilder sb = new StringBuilder();
        int cptColonne = 0;
        //Si on n'est pas � la fin de la cha�ne
        if (this.cursor < this.chaine.length()) {
            //Parcours du mot � retourner
            while (Character.isLetterOrDigit(this.chaine.charAt(this.cursor))) {
                sb.append(this.chaine.charAt(this.cursor));
                cptColonne++;
                this.cursor++;
                this.colonne++;
            }
            //Si on a un changement de ligne
            switch (this.chaine.charAt(this.cursor)) {
                case '\n':
                    this.ligne++;
                    this.colonne = 0;
                    break;
                default:
                    this.colonne++;
            }
            //Dans tous les cas, on avance d'un caract�re dans la chaine
            this.cursor++;
            if (sb.toString().equals("")) {
                return this.getNext();
            }
            return new InfosMot(sb.toString(), this.ligne, this.colonne - cptColonne);
        } else {
            return null;
        }
    }   

}
