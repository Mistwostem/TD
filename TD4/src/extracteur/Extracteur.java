package extracteur;

/**
 * Interface exposant la/les fonctionnalité(s) disponible(s)
 * @author Elie
 * @author Julien
 *
 */
public interface Extracteur {

	/**
     * Renvoie le prochain mot 
     *
     * @return InfosMot
     */
    public InfosMot getNext();
}
