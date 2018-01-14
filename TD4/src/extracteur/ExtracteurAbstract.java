package extracteur;

/**
 * Classe abstraite implémentant l'interface Extracteur
 * @author Julien
 * @author Elie
 *
 */
public abstract class ExtracteurAbstract implements Extracteur {
	
    @Override
    public InfosMot getNext() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Retourne un saut de ligne
     * @param c
     * @return char
     */
    public Boolean sautDeLigne(char c) {

        return c == '\n';
    }

}
