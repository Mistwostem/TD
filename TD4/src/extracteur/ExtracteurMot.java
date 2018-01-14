package extracteur;

public class ExtracteurMot implements Extracteur {
	
    private final String chaine;
    private int ligne;
    private int colonne;
    private int cursor;

    public ExtracteurMot(String chaine) {
        this.chaine = chaine;
        this.cursor = 0;
        this.ligne = 1;
        this.colonne = 0;
    }

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
