package extracteur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExtracteurFichier implements Extracteur {

    private final FileInputStream fichier;
    private int ligne;
    private int colonne;

    public ExtracteurFichier(FileInputStream fichier) throws FileNotFoundException {
        this.fichier = fichier;
        this.ligne = 1;
        this.colonne = 0;
    }

    @Override
    public InfosMot getNext() {
        StringBuilder sb = new StringBuilder();
        //Position dans le fichier
        int cursor = 0;
        try {
            while ((cursor = this.fichier.read()) != -1 && Character.isLetterOrDigit((char) cursor)) {
                //on insère le caractère dans la chaine
                sb.append((char) cursor);
                this.colonne++;
            }
            switch ((char) cursor) {
                case '\n':
                    //  System.out.println("HERE");
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
        return null;
    }


}
