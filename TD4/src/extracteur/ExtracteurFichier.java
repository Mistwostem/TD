package extracteur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe concrète héritant de la classe abstraite ExtracteurAbstract 
 * @author Elie
 * @author Julien
 *
 */
public class ExtracteurFichier implements Extracteur {

    private final FileInputStream fichier;
    private int ligne;
    private int colonne;

    /**
     * Constructeur de la classe ExtracteurFichier prenant en paramètre un fichier de type FileInputStream
     * @param fichier
     * @throws FileNotFoundException
     */
    public ExtracteurFichier(FileInputStream fichier) throws FileNotFoundException {
        this.fichier = fichier;
        this.ligne = 1;
        this.colonne = 0;
    }

    /**
     * Retourne un objet de type InfosMot
     */
    @Override
    public InfosMot getNext() {
        StringBuilder sb = new StringBuilder();
        //Position dans le fichier
        int cursor = 0;
        try {
            while ((cursor = this.fichier.read()) != -1 && Character.isLetterOrDigit((char) cursor)) {
                //On insère le caractère dans la chaine
                sb.append((char) cursor);
                this.colonne++;
            }
            switch ((char) cursor) {
                case '\n':
                    this.ligne++;
                    this.colonne = 0;
                    break;
                default:
                    this.colonne++;
            }
            //Dans tous les cas, on avance d'un caractère dans la chaine
            if (sb.toString().equals("") && cursor != -1) {
                return this.getNext();
            } else if (cursor != -1) {
                return new InfosMot(sb.toString(), ligne, (colonne - sb.length()));
            }
            this.fichier.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return new InfosMot();
    }


}
