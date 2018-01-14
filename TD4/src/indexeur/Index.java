package indexeur;

import java.util.List;
import java.util.Set;

/**
 * Interface exposant les fonctionnalit�s disponibles
 * @author julien et Elie
 *
 * @param <K> Comparable K
 * @param <V> Comparable V
 */
public interface Index<K extends Comparable<K>, V extends Comparable<V>> {
    
	/**
     * Fonction qui supprime la cl� de l'index ainsi que les valeurs qui sont attach�es
     *
     * @param cle K
     */
    public void supprimer(K cle);

    /**
     * Fonction qui supprime une valeur de l'index, or si c'est la derni�re alors la cl� est supprim�e
     * 
     * @param  cle K
     * @param  valeur V
     */
    public void supprimer(K cle, V valeur);

    /**
     * Fonction qui prend en entr�e une cl� et une valeur puis les ajoute � l'index si la cl� existe d�ja alors 
     * on ajoute la valeur � celle ci
     *
     * @param cle K
     * @param valeur V
     */
    public void ajouter(K cle, V valeur);

    /**
     * Fonction qui retourne la ou les valeurs de la cl� K prise en entr�e
     *
     * @param cle K
     * @return List
     */
    public List<V> rechercher(K cle);

    /**
     * Fonction qui v�rifie si la cl� contient bien les valeurs prises en entr�e
     *
     * @param cle K
     * @param valeur V
     * @return boolean 
     */
    public boolean rechercher(K cle, V valeur);

    /**
     * Fonction qui retourne le nombre de cl�s pr�sentes dans l'index
     *
     * @return int
     */
    public int nbeCles();

    /**
     * Fonction qui v�rifie si l'index est vide ou non
     *
     * @return boolean
     */
    public boolean estVide();

    /**
     * Fonction qui vide l'index
     */
    public void vider();
 
    /**
     * Fonction qui retourne l'ensemble des cl�s pr�sentes dans l'index
     *
     * @return Set
     */
    public Set<K> obtenirCles();

    /**
     * Fonction qui retourne une chaine de caract�res contenant les informations pr�sentes dans l'index
     *
     * @return String
     */
    @Override
    public String toString();

}
